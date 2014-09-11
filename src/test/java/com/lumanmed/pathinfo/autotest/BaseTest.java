/**
 * 
 */
package com.lumanmed.pathinfo.autotest;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
	protected WebDriver driver;
	protected String pathinfoUrl;
	protected String adminUser;
	protected String adminPassword;

	@Parameters({"pathinfoUrl", "adminUser", "adminPassword"})
	@BeforeTest
	public void beforeTest(String pathinfoUrl, String adminUser, String adminPassword) {
		this.pathinfoUrl = pathinfoUrl;
		this.adminUser = adminUser;
		this.adminPassword = adminPassword;
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
	
	protected String currentTimeString() {
		return sdf.format(new Date());
	}
	
	protected void goTo(String relativePath) {
		driver.get(pathinfoUrl + relativePath);
	}

	protected void goToMainPage() {
		goTo("");
	}
	
	protected void login(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginForm")).submit();
	}
	
	protected void logout() {
		goTo("a/logout");
	}
	
	protected void assertExists(String cssSelector) {
		try {
			driver.findElement(By.cssSelector(cssSelector));
		} catch (NoSuchElementException e) {
			Assert.fail(String.format("Can't find element with selector '%s'.", cssSelector));
		}
	}
}
