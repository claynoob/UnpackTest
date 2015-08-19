package com.panerabread.auit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class SmokeTest {
	
	private AdvancedWebDriver driver = null;
	{System.setProperty("environment","qarc");}

	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
		
	@After 
	public void tearDown() throws Exception { 
		//driver.quit(); 
	}
	
	@Test
	public void orderWithRewardsModal() throws IOException {
		PageFactory.getDefaultHomePage(driver).startDeliveryOrder().signIn("fortifyqaauto@gmail.com", "bread3")
			.enterDeliveryAddress("2125 S Hurstbourne Pkwy").enterDeliveryInfo("Dormitory", "9126544598")
			.orderForASAP().clickCategoryPlacard("Pastas").orderItem("Chicken Tortellini Alfredo", false, null)
			.goToCheckout().dismissBeverageUpsell().selectRewards("Free Pasta")
			.freeOrderCheckout().verifyTax(0.21f).verifySuccessfulOrder();
	}
	@Test
	public void RPUNowRegStoredCC() throws IOException {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
			.chooseCafe("60515", "600701").orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo", false, null).goToCheckout().dismissAllModals()
			.payWithCC(null, null, "Stored", "Visa", false).verifySubtotal(7.99f).verifyTotal(8.65f).verifySuccessfulOrder();
	}
	
	@Test
	public void addStoredPhoneNumber() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("chaley.tester", "bread3")
			.goToMyPhoneNumbers().addNewPhone(); //(null, "9126544598");
	}
	
	@Test
	public void updateAccountInfo() throws IOException {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.updateAccountInfoOpt();
	}
	
	@Test
	public void addFavoriteCafe() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.goToMyCafes().addFavoriteCafe("Savannah, GA", 204389);
	}
	
	@Test
	public void addStoredCC() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
			.goToMyCards().storeCreditCardOpt(CardTypes.VISA);
	}
	
	@Test
	public void addStoredGC() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.goToMyCards().storeGiftCardOpt();
	}
	
	@Test
	public void updateEmailPreferences() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.updateEmailPreferences().editEmailPreferences(null, "yes", null, null, "yes", "yes", null);
	}
	
	@Test
	public void saveFavoriteItem() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
			.chooseCafe("60515", "600701").orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo", false, null).goToCheckout().dismissAllModals()
			.addFavoriteItem("Chicken Tortellini Alfredo", "AutoFavPasta");
	}
	
	@Test
	public void logInPhone() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signInWithPhone("9122372317", "bread3", "Fortify QAAuto").verifyLogin();
	}
	
	@Test
	public void logInUsername() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("sodapoppin", "bread3").verifyLogin();
	}
	
	@Test
	public void logInEmail() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("fortifyqaauto@gmail.com", "bread3").verifyLogin();
	}
	
	@Test
	public void logOut() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("fortifyqaauto@gmail.com", "bread3").verifyLogin()
			.signOut().verifyLogOut().verifyPageURL("https://delivery1-qarc3.panerabread.com/#!/");
	}
	
	@Test
	public void addStoredAddress() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("fortifyqaauto@gmail.com", "bread3").verifyLogin()
			.goToMyAddresses().addNewAddress("Home", "203 Mallard Drive", null, "Glennville", "GA", "30427",
					"9126543454", null);
	}
	
	@Test
	public void regVirtualUser() {
		PageFactory.getDefaultHomePage(driver).registerNewUserOpt().registerNewUser(null, null, "yes");
	}
}
