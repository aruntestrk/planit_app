package com.planit.selenium.page.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.plaint.selenium.pages.CartPage;
import com.plaint.selenium.pages.ContactsPage;
import com.plaint.selenium.pages.ShopPage;
import com.planit.seleniium.base.BasePage;

public class Navigations extends BasePage {

	private final By contactLinkBy = By.xpath("//a[@href='#/contact']");

	private final By shopLinkBy = By.xpath("//a[@href='#/shop']");

	private final By cartsLinkBy = By.xpath("//a[contains(@href,'#/cart')]");

	public Navigations(WebDriver driver) {
		super(driver);
	}

	public WebElement getContactsLink() {
		return wait.until(ExpectedConditions.elementToBeClickable(contactLinkBy));
	}

	public WebElement getShopLink() {
		return wait.until(ExpectedConditions.elementToBeClickable(shopLinkBy));
	}
	
	public WebElement getCartsLink() {
		return wait.until(ExpectedConditions.elementToBeClickable(cartsLinkBy));
	}

	public ContactsPage clickContactsLink() {
		getContactsLink().click();
		return new ContactsPage(driver);
	}

	public ShopPage clickShopLink() {
		getShopLink().click();
		return new ShopPage(driver);
	}

	public CartPage clickCartsLink() {
		getCartsLink().click();
		return new CartPage(driver);
	}

}
