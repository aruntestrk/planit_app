package com.planit.selenium.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.plaint.selenium.pages.CartPage;
import com.plaint.selenium.pages.JupiterHomePage;
import com.plaint.selenium.pages.ShopPage;
import com.planit.seleniium.base.BaseTest;
import com.planit.selenium.page.components.Navigations;
import com.planit.selenium.pojos.Product;

public class JupiterShoppingCartTest extends BaseTest {

	private static Logger LOGGER = LoggerFactory.getLogger(JupiterShoppingCartTest.class);

	@Test(dataProvider = "productsData")
	public void shoppingCartTest(List<Product> productList) throws Exception {
		JupiterHomePage jupiterHomePage = new JupiterHomePage(getDriver());
		jupiterHomePage.load();
		Navigations navigations = jupiterHomePage.getNavigations();
		ShopPage shopPage = navigations.clickShopLink();
		productList = shopPage.retrieveAllProductsPrice(productList);
		List<Product> purchasedProductList = shopPage.addAllProductsToCart(productList);
		CartPage cartPage = navigations.clickCartsLink();
		List<Product> productListInCart = cartPage.getCheckedoutProducts();
		int productsSize = purchasedProductList.size();
		Assert.assertEquals(productsSize, productListInCart.size());

		double totalPriceOfSelectedProducts = purchasedProductList.stream()
				.mapToDouble(product -> product.getSubTotal()).sum();
		double totalPriceOfProductsInCart = productListInCart.stream().mapToDouble(product -> product.getSubTotal())
				.sum();

		Assert.assertEquals(totalPriceOfSelectedProducts, totalPriceOfProductsInCart,
				"The total price of items purchased matches between shopping page and Cart Page");

		List<Product> unmatchedProductList = findUnmatchedProducts(purchasedProductList, productListInCart);

		
		if (unmatchedProductList.size() > 0) {
			LOGGER.info("The below products are selected in Shopping page but not available in Cart Page");
			unmatchedProductList.forEach(product -> {
				LOGGER.info("Product name : ", product.getName());
				LOGGER.info("Product name : ", product.getPrice());
				LOGGER.info("Product name : ", product.getQuantity());
				LOGGER.info("Product name : ", product.getSubTotal());
			});

		}

		Assert.assertEquals(unmatchedProductList.size(), 0,
				"The Items selected in the shop page should be the same in cart page");

	}

	private List<Product> findUnmatchedProducts(List<Product> purchasedProductList, List<Product> productListInCart) {
		List<Product> unmatchedProductsFromShopPage = purchasedProductList.stream()
				// We select any elements such that in the stream of elements from the second
				// list
				.filter(two -> productListInCart.stream()
						// there is an element that has the same name and school as this element,
						.noneMatch(one -> one.getName().equals(two.getName()) && two.getPrice().equals(one.getPrice())
								&& two.getQuantity().equals(one.getQuantity())
								&& two.getSubTotal().equals(one.getSubTotal())))
				.collect(Collectors.toList());
		return unmatchedProductsFromShopPage;
	}

	@DataProvider(name = "productsData")
	public Object[] getProductsData() {
		Object[][] data = prepareProductsData();
		return data;
	}

	private Object[][] prepareProductsData() {
		List<Product> productList = new ArrayList<>();
		Product product1 = new Product();
		product1.setQuantity(2);
		product1.setName("Stuffed Frog");

		Product product2 = new Product();
		product2.setQuantity(5);
		product2.setName("Fluffy Bunny");

		Product product3 = new Product();
		product3.setQuantity(3);
		product3.setName("Valentine Bear");

		productList.add(product1);
		productList.add(product2);
		productList.add(product3);

		Object[][] productDataArray = new Object[1][1];
		productDataArray[0][0] = productList;

		return productDataArray;

	}

}
