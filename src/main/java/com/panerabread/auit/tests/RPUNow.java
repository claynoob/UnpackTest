package com.panerabread.auit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class RPUNow {
	
	private AdvancedWebDriver driver = null;
	//{System.setProperty("environment","qarc");}

	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
	}
		
	@After 
	public void tearDown() throws Exception 
	{ 
	driver.quit(); 
	}
	
	@Test
	public void RPUNowRegStoredCC() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
		.chooseCafe("60515", "600701").orderForASAP().clickCategoryPlacard("Pastas")
		.orderItem("Chicken Tortellini Alfredo", false, null).goToCheckout().dismissAllModals()
		.payWithCC(null, null, "Stored", "Visa", false);
		driver.quit();
	}
	
	@Test
	public void updateAccountInfo() throws IOException {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3")
		.updateAccountInfoOpt();
		driver.quit();
	}
	
	@Test
	public void addFavoriteCafe() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3")
		.goToMyCafes().addFavoriteCafe("Savannah, GA", 204389);
		driver.quit();
	}
	
	@Test
	public void addStoredCC() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
		.goToMyCards().storeCreditCardOpt(CardTypes.MAST);
		driver.quit();
	}
	
	@Test
	public void addStoredGC() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3")
		.goToMyCards().storeGiftCardOpt();
		driver.quit();
	}
	
	@Test
	public void addStoredPhoneNumber() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3")
		.goToMyPhoneNumbers().addNewPhone(); //(null, "9122375210");
		driver.quit();
	}
	
	@Test
	public void updateEmailPreferences() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3")
		.updateEmailPreferences().editEmailPreferences(null, "yes", null, null, "yes", "yes", null);
		driver.quit();
	}
	
	@Test
	public void saveFavoriteItem() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
		.chooseCafe("60515", "600701").orderForASAP().clickCategoryPlacard("Pastas")
		.orderItem("Chicken Tortellini Alfredo", false, null).goToCheckout().dismissAllModals()
		.addFavoriteItem("Chicken Tortellini Alfredo", "AutoFavPasta");
		driver.quit();
	}
}

