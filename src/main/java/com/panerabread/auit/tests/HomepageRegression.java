package com.panerabread.auit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class HomepageRegression {
	
	private AdvancedWebDriver driver = null;
	//{System.setProperty("environment","qarc");}
	
	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
		
	@After 
	public void tearDown() throws Exception { 
		driver.quit(); 
	}
	
	@Test
	public void found6852() {
		PageFactory.getDefaultHomePage(driver).checkForExpressOrder();
	}
	
	@Test
	public void found6847() {
		PageFactory.getDefaultHomePage(driver)
		.checkOrderDescText("RPU", "We\\'ll have your order ready on the Rapid Pick-Up shelf at the time you choose. No lines, no wait.");
	}
	
	@Test
	public void found6851() {
		PageFactory.getDefaultHomePage(driver)
		.checkOrderDescText("Order From My Table", "We\\'ll bring your food right to your table at the bakery-cafe.");
	}
	
	@Test
	public void found6850() {
		PageFactory.getDefaultHomePage(driver)
		.checkOrderDescText("Delivery", "We\\'ll deliver your meal to you at your home or business. Have a large order? Click \\'Order Catering\\' in the box below");
	}
	
	@Test
	public void found7324() {
		PageFactory.getDefaultHomePage(driver).goToCafeLocations().verifyNoCafeResults()
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/cafeLocations/");
	}

	@Test
	public void found7322CateringButton() {
		PageFactory.getDefaultHomePage(driver).clickCateringButton()
		.verifyPageURL("https://cater.panerabread.com/catering-webapp/?show_welcome=true");
	}
	
	@Test
	public void found7322CateringHeader() {
		PageFactory.getDefaultHomePage(driver).clickCateringHeaderLink()
		.verifyPageURL("https://cater.panerabread.com/catering-webapp/?show_welcome=true");
	}
	
	@Test
	public void found7322CateringFooter() {
		PageFactory.getDefaultHomePage(driver).clickCateringFooterLink()
		.verifyPageURL("https://cater.panerabread.com/catering-webapp/?show_welcome=true");
	}
}