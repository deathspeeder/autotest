/**
 * 
 */
package com.lumanmed.pathinfo.autotest;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * @author jwang25
 *
 */
public class UserTest extends BaseTest {
	@Test
	public void testLogin() {
		logout();

		WebElement selectLanguage = null;
		try {
			selectLanguage = driver.findElement(By
					.cssSelector("#languageSwitch a"));
		} catch (NoSuchElementException e) {
			Assert.fail("Can't find languageSwitch element.");
		}
		if ("Select Language".equals(selectLanguage.getText())) {
			System.out.println("Change locale to zh_CN");
			driver.get(pathinfoUrl + "change_locale/zh_CN?url=" + pathinfoUrl);
		}
		
		login(adminUser, adminPassword);
		assertExists("#menu");
	}
	
	@Test(dependsOnMethods = {"testLogin"})
	public void testLogout() {
		logout();
		assertExists("#languageSwitch");
	}
}
