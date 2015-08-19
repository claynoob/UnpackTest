package com.panerabread.auit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class Demo {
	
	private AdvancedWebDriver driver = null;
	//{System.setProperty("environment","qarc");}

	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
		
	@After 
	public void tearDown() throws Exception 
	{ 
	driver.quit(); 
	}

	@Test
	public void virtualLoyaltyAccessFavorites() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("Stanley_Collie", "bread3").chooseCafe("63127", "600668")
		.orderForASAP().clickCategoryPlacard("Salads").orderItem("Thai Chicken Salad", false, null).goToCheckout()
		.dismissAllModals().addFavoriteItem("Thai Chicken Salad", "FavSalad").goToBrowseOurMenu()
		.clickSidebarCategory("My Favorites").checkForFavoriteItem("FavSalad")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/menu/myPanera/my_favorites");
	}
	
	@Test
	public void physicalLoyaltyAccessFavorites() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("Lily_Coton", "bread3").chooseCafe("63127", "600668")
		.orderForASAP().clickCategoryPlacard("Salads").orderItem("Thai Chicken Salad", false, null).goToCheckout()
		.dismissAllModals().addFavoriteItem("Thai Chicken Salad", "FavSalad").goToBrowseOurMenu()
		.clickSidebarCategory("My Favorites").checkForFavoriteItem("FavSalad")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/menu/myPanera/my_favorites");
	}
	
	@Test
	public void virtualLoyaltyAccessPastOrders() {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("Stanley_Collie", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/menu/myPanera/my_past_orders");
	}
	
	@Test
	public void physicalLoyaltyAccessPastOrders() {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("Lily_Coton", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/menu/myPanera/my_past_orders");
	}
	
	/*@Test
	public void newAcctEmailOptIn() {
		PageFactory.getDefaultHomePage(driver).registerNewUser("Chaley", "Auto", "9126540283", "chaley_stanfield_auto@googlemail.com", 
				"203 Mallard Drive", "Glennville", "GA", "30427", "Chaley_S_Auto", "bread3", "bread3", 
				null, null, "April", "15", "1990", null).verifyRegistrationSuccess();
	}*/
	
	@Test
	public void checkforExpressOrderOption() {
		PageFactory.getDefaultHomePage(driver).checkForExpressOrder();
	}
	
	@Test
	public void checkRPUOrderDescText() {
		PageFactory.getDefaultHomePage(driver)
		.checkOrderDescText("RPU", "We\\'ll have your order ready on the Rapid Pick-Up shelf at the time you choose. No lines, no wait.");
	}
	
	@Test
	public void checkDineInOrderDescText() {
		PageFactory.getDefaultHomePage(driver)
		.checkOrderDescText("Order From My Table", "We\\'ll bring your food right to your table at the bakery-cafe.");
	}
	
	@Test
	public void checkDeliveryOrderDescText() {
		PageFactory.getDefaultHomePage(driver)
		.checkOrderDescText("Delivery", "We\\'ll deliver your meal to you at your home or business. Have a large order? Click \\'Order Catering\\' in the box below");
	}
	
	@Test
	public void goToCafeLocationsPage() {
		PageFactory.getDefaultHomePage(driver).goToCafeLocations().verifyNoCafeResults()
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/cafeLocations/");
	}

	@Test
	public void checkOrderCateringButton() {
		PageFactory.getDefaultHomePage(driver).clickCateringButton()
		.verifyPageURL("https://cater.panerabread.com/catering-webapp/?show_welcome=true");
	}
	
	@Test
	public void checkCateringHeaderButton() {
		PageFactory.getDefaultHomePage(driver).clickCateringHeaderLink()
		.verifyPageURL("https://cater.panerabread.com/catering-webapp/?show_welcome=true");
	}
	
	@Test
	public void checkCateringFooterButton() {
		PageFactory.getDefaultHomePage(driver).clickCateringFooterLink()
		.verifyPageURL("https://cater.panerabread.com/catering-webapp/?show_welcome=true");
	}
}