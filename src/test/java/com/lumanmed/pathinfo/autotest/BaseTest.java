/**
 * 
 */
package com.lumanmed.pathinfo.autotest;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * @author jwang25
 *
 */
public abstract class BaseTest {
	protected WebDriver driver;
	protected String pathinfoUrl;

	@Parameters({"pathinfoUrl"})
	@BeforeTest
	public void beforeTest(String pathinfoUrl) {
		this.pathinfoUrl = pathinfoUrl;
		driver = new FirefoxDriver();
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	protected void goToMainPage() {
		driver.get(pathinfoUrl);
	}
	
	protected void login(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginForm")).submit();
	}
	
	protected void logout() {

		driver.get(pathinfoUrl + "a/logout");
	}
	
	protected void assertExists(String cssSelector) {
		try {
			driver.findElement(By.cssSelector(cssSelector));
		} catch (NoSuchElementException e) {
			Assert.fail(String.format("Can't find element with selector '%s'.", cssSelector));
		}
	}
}
