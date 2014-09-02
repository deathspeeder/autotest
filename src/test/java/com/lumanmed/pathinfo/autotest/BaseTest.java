/**
 * 
 */
package com.lumanmed.pathinfo.autotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * @author jwang25
 *
 */
public abstract class BaseTest {
	protected WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
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
}
