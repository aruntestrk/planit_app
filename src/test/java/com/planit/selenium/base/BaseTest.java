package com.planit.selenium.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.planit.selenium.constants.DriverType;
import com.planit.selenium.factory.DriverFactory;

public class BaseTest {
	private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	protected WebDriver getDriver() {
		return this.driver.get();
	}

	@Parameters("browser")
	@BeforeMethod
	public synchronized void startDriver(@Optional String browser) {
		browser = System.getProperty("browser", browser);
		setDriver(DriverFactory.getWebDriver(DriverType.valueOf(browser)));
		System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " + "DRIVER = " + getDriver());
	}

	@Parameters("browser")
	@AfterMethod
	public synchronized void quitDriver(@Optional String browser, ITestResult result)
			throws InterruptedException, IOException {
		Thread.sleep(300);
		System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " + "DRIVER = " + getDriver());
		if (result.getStatus() == ITestResult.FAILURE) {
			File destFile = new File("scr" + File.separator + browser + File.separator
					+ result.getTestClass().getRealClass().getSimpleName() + "_" + result.getMethod().getMethodName()
					+ ".png");
			takeScreenshot(destFile);

		}
		getDriver().quit();
	}

	private void takeScreenshot(File destFile) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, destFile);
	}

}
