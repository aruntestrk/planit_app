package com.planit.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.planit.selenium.base.BasePage;
import com.planit.selenium.pojos.Product;

public class CartPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//tr[@class='cart-item ng-scope']") 
    private List<WebElement> productRowWebElementist;
    
    private final By productTableRowsBy = By.xpath("//tr[@class='cart-item ng-scope']");
    
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Check Out']") 
    @CacheLookup 
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    
    public boolean isCartFull() {
    	return productRowWebElementist.size() > 0;
    }
    
    public List<Product> getCheckedoutProducts() {
    	List<Product> productList = new ArrayList<Product>();
    	List<WebElement> productRowsList = waitUntilAllElementVisibleBy(productTableRowsBy);
    	productRowsList.forEach(rowWebElement -> {
    		List<WebElement> tdWebElementsList = rowWebElement.findElements(By.tagName("td"));
    		Product product = new Product();
    		product.setName(tdWebElementsList.get(0).getText());
    		product.setPriceString(tdWebElementsList.get(1).getText());
    		product.setPrice(Double.parseDouble(product.getPriceString().replace("$", "")));
    		WebElement quantityElement = tdWebElementsList.get(2).findElement(By.tagName("input"));
    		String quantityString = quantityElement.getAttribute("value");
    		product.setQuantity(Integer.parseInt(quantityString));
    		String subTotalString = tdWebElementsList.get(3).getText();
    		product.setSubTotal(Double.parseDouble(subTotalString.replace("$", "")));
    		productList.add(product);
    	});
    	return productList;
    }
   
}
