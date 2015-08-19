package com.panerabread.auit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class DineIn {
	
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
	public void DineInRegManualCC() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("fortifyqaauto@gmail.com", "bread3")
		.chooseCafe("63127", "600668").enterTableNumber("23").clickCategoryPlacard("Pastas")
		.orderItem("Pasta Primavera", false, null).goToCheckout().dismissAllModals()
		.payWithCC(CardTypes.VISA, null, "Manual", null, false);
	}
	@Test
	public void updateAccountInfo() throws IOException {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("chaley.tester", "bread3")
		.updateAccountInfoOpt();
	}
	@Test
	public void addFavoriteCafe() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("chaley.tester", "bread3")
		.goToMyCafes().addFavoriteCafe("63127", 600668);
	}
	@Test
	public void addStoredCC() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("fortifyqaauto@gmail.com", "bread3")
		.goToMyCards().storeCreditCardOpt(CardTypes.DISC);
	}
	@Test
	public void addStoredGC() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("chaley.tester", "bread3")
		.goToMyCards().storeGiftCardOpt();
	}
	@Test
	public void addStoredPhoneNumber() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("chaley.tester", "bread3")
		.goToMyPhoneNumbers().addNewPhone(); //(null, "9122825210");
	}
	@Test
	public void updateEmailPreferences() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("chaley.tester", "bread3")
		.updateEmailPreferences().editEmailPreferences("yes", null, null, "yes", "yes", null, null);
	}
	@Test
	public void orderWithRewardsModal() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("fortifyqaauto@gmail.com", "bread3")
		.chooseCafe("63127", "600668").enterTableNumber("23").clickCategoryPlacard("Pastas")
		.orderItem("Pasta Primavera", false, null).goToCheckout().dismissBeverageUpsell().selectRewards("Free Pasta")
		.freeOrderCheckout();
	}
}