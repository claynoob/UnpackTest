package com.panerabread.auit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class AdHoc {
	
	private AdvancedWebDriver driver = null;
	{System.setProperty("environment","qarc3");}
	
	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
		
	@After 
	public void tearDown() throws Exception { 
		//driver.quit(); 
	}
	
	/*@Test
	public void test1() throws Exception {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("60515", "600701")
		.orderForLater(2, "1:15 PM", true).clickCategoryPlacard("Panini &amp; Sandwiches");
	}*/

	
	@Test
	public void test1() throws Exception {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForLater(2, "1:15 PM", true).clickCategoryPlacard("Pastas").orderItem("Pasta Primavera", false, null).checkSoups()
		.goToCheckout();
	}

}