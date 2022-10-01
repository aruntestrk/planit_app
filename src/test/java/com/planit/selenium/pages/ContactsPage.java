package com.planit.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planit.selenium.base.BasePage;

public class ContactsPage extends BasePage {

	private final By foreNameTextBy = By.id("forename");

	private final By surNameTextBy = By.id("surname");

	private final By emailTextBy = By.id("email");

	private final By telephoneTextBy = By.id("telephone");

	private final By messageTextBy = By.id("message");

	private final By submitBtnBy = By.cssSelector(".btn-contact.btn.btn-primary");

	private final By overlay = By.xpath("//div[@class='popup modal hide ng-scope in']");

	private final By successMessageDivBy = By.xpath("//div[@class='alert alert-success']");

	private final By backBtnBy = By.xpath("//a[@class='btn']");
	
	private final By foreNameErrorBy = By.id("forename-err");
	
	private final By emailErrorBy = By.id("email-err");
	
	private final By messageErrorBy = By.id("message-err");

	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	public ContactsPage enterTextInFirstNameField(String txt) {
		waitUntilElementVisibleBy(foreNameTextBy).sendKeys(txt);
		return this;
	}

	public ContactsPage enterTextInSurNameField(String txt) {
		waitUntilElementVisibleBy(surNameTextBy).sendKeys(txt);
		return this;
	}

	public ContactsPage enterTextInEmailField(String txt) {
		waitUntilElementVisibleBy(emailTextBy).sendKeys(txt);
		return this;
	}

	public ContactsPage enterTextInTelephoneField(String txt) {
		waitUntilElementVisibleBy(telephoneTextBy).sendKeys(txt);
		return this;
	}

	public ContactsPage enterTextInMessageField(String txt) {
		waitUntilElementVisibleBy(messageTextBy).sendKeys(txt);
		return this;
	}

	public void clickSubmitBtn() {
		waitUntilElementVisibleBy(submitBtnBy).click();
	}

	public void clickBackButton() {
		waitUntilElementVisibleBy(backBtnBy).click();
	}

	public String getContactsSuccessMessage() {
		waitForOverlaysToDisappear(overlay);
		return waitUntilElementVisibleBy(successMessageDivBy).getText();
	}
	
	public String getForeNameErrorMessage() {
		return waitUntilElementVisibleBy(foreNameErrorBy).getText();
	}
	
	public String getEmailErrorMessage() {
		return waitUntilElementVisibleBy(emailErrorBy).getText();
	}
	
	public String getMessageErrorMessage() {
		return waitUntilElementVisibleBy(messageErrorBy).getText();
	}

}
