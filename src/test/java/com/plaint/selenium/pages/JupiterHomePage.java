package com.plaint.selenium.pages;

import org.openqa.selenium.WebDriver;

import com.planit.seleniium.base.BasePage;
import com.planit.selenium.page.components.Navigations;

public class JupiterHomePage extends BasePage {

	Navigations navigations;

	public JupiterHomePage(WebDriver driver) {
		super(driver);
		navigations = new Navigations(driver);
	}

	public JupiterHomePage load() {
		load("/");
		return this;
	}

	public Navigations getNavigations() {
		return navigations;
	}

	public void setNavigations(Navigations navigations) {
		this.navigations = navigations;
	}
}