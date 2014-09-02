/**
 * 
 */
package com.lumanmed.pathinfo.autotest;

import org.testng.annotations.Test;

/**
 * @author jwang25
 *
 */
public class AppTest extends BaseTest {
	@Test
	public void run() {
		driver.get("http://www.baidu.com");
	}
}
