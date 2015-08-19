package com.panerabread.auit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisteredUserNewUserRegression {
	
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
	
	@Test
	public void found6903() {
		PageFactory.getDefaultHomePage(driver).registerNewUserOpt().registerNewUser("123402908305", "4549", null);
	}

	@Test
	public void found6959_found6892() {
		PageFactory.getDefaultHomePage(driver).registerNewUserOpt().registerNewUser(null, null, null);
	}
	
	@Test
	public void found6960() {
		PageFactory.getDefaultHomePage(driver).registerNewUserOpt().registerNewUser(null, null, "");
	}
	
	@Test
	public void found7060() throws Exception {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("Lily_Coton", "bread3").verifyLogin()
		.chooseCafe("60515", "600701").orderForASAP().clickCategoryPlacard("Salads")
		.orderItem("Thai Chicken Salad", false, null).goToCheckout().dismissAllModals()
		.payWithCC(CardTypes.DISC, null, "Manual", null, false).verifySuccessfulOrder();
	}
	
	@Test
	public void found7059() throws Exception {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("Stanley_Collie", "bread3").verifyLogin()
		.chooseCafe("60515", "600701").orderForASAP().clickCategoryPlacard("Pastas")
		.orderItem("Chicken Tortellini Alfredo", false, null).goToCheckout().dismissAllModals()
		.payWithCC(CardTypes.DISC, null, "Manual", null, false).verifySuccessfulOrder();
	}
	
	@Test
	public void found7001() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("jandurrence", "coast65").verifyLogin();
	}
	
	@Test
	public void logInLegacyUser() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("sodapoppin", "bread3").verifyLogin();
	}
	
	@Test
	public void found7007mDot() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("tommythomas", "bread3").verifyLogin();
	}

	@Test
	public void found7007iOS() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("elmer.fudd", "bread3").verifyLogin();
	}

	@Test
	public void found7007Android() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("ninja.turtle", "bread3").verifyLogin();
	}
	
	@Test
	public void found7037() {
		PageFactory.getQARCWebU(driver).logIn().signIn("Lily_Coton", "bread3").verifyWebULogin();
	}

	@Test
	public void found7038() {
		PageFactory.getQARCWebU(driver).logIn().signIn("sodapoppin", "bread3").verifyWebULogin();
	}
	
	@Test
	public void found6923() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("fortifyqaauto@gmail.com", "bread3").verifyLogin();
	}
	
	@Test
	public void found6922() {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("fortifyqaauto@gmail.com", "bread5").verifyInvalidLogin();
	}
	
	@Test
	public void found7019() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("fortifyqaauto", "bread3").verifyLogin().signOut()
		.logIn().signIn("fortifyqaauto@gmail.com", "bread3").verifyLogin().signOut()
		.logIn().signInWithPhone("9122372317", "bread3", "Fortify").verifyLogin();
	}
	
	@Test
	public void found6994() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("Stanley_Collie", "bread3").chooseCafe("60515", "600701")
		.orderForASAP().clickCategoryPlacard("Salads").orderItem("Thai Chicken Salad", false, null).goToCheckout()
		.dismissAllModals().addFavoriteItem("Thai Chicken Salad", "FavSalad").goToBrowseOurMenu()
		.clickSidebarCategory("My Favorites").checkForFavoriteItem("FavSalad")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/menu/myPanera/my_favorites");
	}
	
	@Test
	public void found6993() {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("Stanley_Collie", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/menu/myPanera/my_past_orders");
	}
	
	@Test
	public void found6984() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("Lily_Coton", "bread3").chooseCafe("60515", "600701")
		.orderForASAP().clickCategoryPlacard("Salads").orderItem("Thai Chicken Salad", false, null).goToCheckout()
		.dismissAllModals().addFavoriteItem("Thai Chicken Salad", "FavSalad").goToBrowseOurMenu()
		.clickSidebarCategory("My Favorites").checkForFavoriteItem("FavSalad")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/menu/myPanera/my_favorites");
	}
	
	@Test
	public void found6991() {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("Lily_Coton", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/menu/myPanera/my_past_orders");
	}
	
	@Test
	public void found7058() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("Lily_Coton", "bread3").chooseCafe("60515", "600701")
		.orderForLater(3, "5:00", false).clickCategoryPlacard("Salads").customizeItemFromMenu("Chicken Caesar Salad")
		.chooseSide("Apple").modifyItem("Toppings", new String[] {"Almonds", "Pecans", "Croutons"}).orderCustomizedItem().goToCheckout()
		.dismissAllModals().payWithCC(CardTypes.MAST, null, "Manual", null, false);
	}
	
	@Test
	public void found7057() throws IOException {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("Stanley_Collie", "bread3").chooseCafe("60515", "600701")
		.orderForLater(2, "5:00", false).clickCategoryPlacard("Salads").customizeItemFromMenu("Chicken Caesar Salad")
		.chooseSide("Chips").modifyItem("Popular", new String[] {"Feta", "Chicken"})
		.modifyItem("Toppings", new String[] {"Almonds", "Avocado", "Chopped Bacon"})
		.modifyItem("Meats", new String[] {"Steak", "Ham"}).orderCustomizedItem().goToCheckout()
		.dismissAllModals().payWithCC(CardTypes.MAST, null, "Manual", null, false).verifySuccessfulOrder();
	}
	
	@Test
	public void found7052() throws IOException {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("Lily_Coton", "bread3")
		.chooseCafe("60515", "600701").orderForASAP()
		.goToMyCards().storeCreditCardOpt(CardTypes.AMEX).goToBrowseOurMenu()
		.clickCategoryPlacard("Panini &amp; Sandwiches").customizeItemFromMenu("Tuna Salad Sandwich")
		.modifyItem("Condiments", new String[] {"Chipotle Mayonnaise"})
		.modifyItem("Toppings", new String[] {"Red Onions", "Cucumber", "Chopped Bacon"}).orderCustomizedItem().goToCheckout()
		.dismissAllModals().payWithCC(null, null, "Stored", "Visa", false).verifySuccessfulOrder();
	}
	
	@Test
	public void found7048() throws IOException {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("Stanley_Collie", "bread3").chooseCafe("60515", "600701").orderForASAP()
		.goToMyCards().storeCreditCardOpt(CardTypes.MAST).goToBrowseOurMenu()
		.clickCategoryPlacard("Panini &amp; Sandwiches").customizeItemFromMenu("Tuna Salad Sandwich")
		.modifyItem("Condiments", new String[] {"Chipotle Mayonnaise"})
		.modifyItem("Toppings", new String[] {"Red Onions", "Cucumber", "Chopped Bacon"}).orderCustomizedItem().goToCheckout()
		.dismissAllModals().payWithCC(null, null, "Stored", "Visa", false).verifySuccessfulOrder();
	}

	@Test
	public void found7055() throws IOException {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToMyCards()
		.storeCreditCardOpt(CardTypes.MAST).goToHomePage().startRPUOrder()
		.signIn(null, null).chooseCafe("60515", "600701").orderForASAP().clickCategoryPlacard("Pastas")
		.orderItem("Chicken Tortellini Alfredo", false, null).goToCheckout().dismissAllModals()
		.payWithCC(null, null, "Stored", "MAST", false).verifySuccessfulOrder();
	}
	
	@Test
	public void found7054() throws IOException {
		PageFactory.getDefaultHomePage(driver).registerNewUserOpt().registerNewUser(null, null, null).manageMyAccount()
		.goToMyCards().storeCreditCardOpt(CardTypes.MAST).goToHomePage().startRPUOrder()
		.signIn(null, null).chooseCafe("60515", "600701").orderForASAP().clickCategoryPlacard("Pastas")
		.orderItem("Chicken Tortellini Alfredo", false, null).goToCheckout().dismissAllModals()
		.payWithCC(null, null, "Stored", "MAST", false).verifySuccessfulOrder();
	}
	
}