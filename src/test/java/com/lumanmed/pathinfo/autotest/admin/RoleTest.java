/**
 * 
 */
package com.lumanmed.pathinfo.autotest.admin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lumanmed.pathinfo.autotest.BaseTest;

/**
 * @author jwang25
 *
 */
public class RoleTest extends BaseTest {
	@BeforeMethod
	public void beforeMethod() {
		logout();
		login(adminUser, adminPassword);
		goTo("a/sys/role");
	}
	
	@Test
	public void testAddRoleEmpty() {
		goTo("a/sys/role/form");
		String name = "empty" + currentTimeString();
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("enname")).sendKeys(name);
		driver.findElement(By.id("roleType")).sendKeys(name);
		driver.findElement(By.id("inputForm")).submit();
		Assert.assertEquals(driver.findElement(By.xpath("//table[@id='contentTable']/tbody/tr[2]/td[1]/a")).getText(), name);
	}
}
