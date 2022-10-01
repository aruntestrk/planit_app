package com.plaint.selenium.pages;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.planit.seleniium.base.BasePage;
import com.planit.selenium.pojos.Product;

public class ShopPage extends BasePage {
	
	public ShopPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getBuyBtnByProduct(String productName) {
		return waitUntilElementVisibleBy(By.xpath("//h4[text()='" + productName + "']/parent::div/p/a"));
	}
	
	public String getCostForProduct(String productName) {
		return waitUntilElementVisibleBy(By.xpath("//h4[text()='" + productName + "']/parent::div/p/span")).getText();
	}
	
	public void addProductToCart(String productName) {
		getBuyBtnByProduct(productName).click();
	}
	
	public List<Product> addAllProductsToCart(List<Product> productList) {
		productList.forEach(product -> {
			Collections.nCopies(product.getQuantity(), 1)
	           .stream()
	           .forEach(i -> addProductToCart(product.getName()));
		});
		return productList;
	}
	
	
	public List<Product> retrieveAllProductsPrice(List<Product> productList) {
		productList.forEach(product -> {
			Collections.nCopies(product.getQuantity(), 1)
	           .stream()
	           .forEach(i -> {
	        	   String productPriceString =  getCostForProduct(product.getName());
	        	   product.setPrice(Double.parseDouble(productPriceString.replace("$", "").trim()));
	        	   product.setSubTotal(product.getPrice()*product.getQuantity());
	        	   product.setPriceString(productPriceString); 
	           });
		});
		return productList;
	}
}
