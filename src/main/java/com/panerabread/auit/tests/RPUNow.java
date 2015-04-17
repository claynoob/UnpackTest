package com.panerabread.auit.tests;

import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class RPUNow {
	@Test
	public void RPUNowRegManualCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
				.chooseCafe("02215", 601272).orderForASAP().clickCategoryPlacard("Pastas")
				.orderItem("Pasta Primavera").goToCheckout().dismissAllModals().payWithManualCC(CardTypes.VISA);
		driver.quit();
}
	@Test
	public void RPUNowRegStoredCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
				.chooseCafe("02215", 601272).orderForASAP().clickCategoryPlacard("Pastas")
				.orderItem("Chicken Tortellini Alfredo").goToCheckout().dismissAllModals()
				.payWithStoredCC("visa");
		driver.quit();
}
	@Test
	public void RPUNowAnonManualCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().orderAsGuest()
				.chooseCafe("02215", 601272).orderForASAP().clickCategoryPlacard("Salads")
				.orderItem("Chicken Cobb with Avocado").goToCheckout()
				.dismissAllModals().payWithManualCC(CardTypes.AMEX).signOut();
		driver.quit();
}
	/*@Test
	public void registerNewUser() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).registerNewUser("FortifyTest", "Auto", "9124295210", "testemail@gmail.com", 
				"211 S Tillman St", "Glennville", "GA", "30427", "FortifyTestAuto", "bread3", "bread3", "July", "23", "1993");
			driver.quit();
}
	@Test
	public void updatePassword() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signInWithPhone("9122372317", "bread3", "Emma")
			.updatePassword("bread3", "bread4", "bread4");
			driver.quit();
}
	@Test
	public void resetPassword() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signInWithPhone("9122372317", "bread3", "Emma")
			.updatePassword("bread4", "bread3", "bread3");
			driver.quit();
}*/
	@Test
	public void updateAccountInfo() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.updateAccountInfo("ChaleyTaylor1", "Stanfield1", "205 Mallard Drive", "Reidsville", "GA", "30453",
					"9122221111", "chaley.stanfield@onshoreoutsourcing.com");
		driver.quit();
}
	@Test
	public void addFavoriteCafe() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.addFavoriteCafe().addNewCafe("Savannah, GA", 204389);
		driver.quit();
}
	@Test
	public void addStoredCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
			.addCard().storeCreditCard(null, "FortifyAuto", "MAST", "5500000000000004", "07", "2020");
		driver.quit();
}
	@Test
	public void addStoredGC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.addCard().storeGiftCard(null, "6006491611999952758");
		driver.quit();
}
	@Test
	public void addStoredAddress() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.addAddress().addNewAddress("Home", "217 S Tillman St", null, null, "Glennville", "GA", "30427",
					"9122375210", null);
		driver.quit();
}
	@Test
	public void addStoredPhoneNumber() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.addPhone().addNewPhone(null, "9122375210");
		driver.quit();
}
	@Test
	public void updateEmailPreferences() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.updateEmailPreferences().editEmailPreferences(null, "yes", null, null, "yes", "yes", null);
		driver.quit();
}
	@Test
	public void saveFavoriteItem() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
			.chooseCafe("02215", 601272).orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo").goToCheckout().dismissAllModals()
			.addFavoriteItem("Chicken Tortellini Alfredo", "AutoFavPasta");
		driver.quit();
}
	@Test
	public void saveFavoriteOrder() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.chooseCafe("02215", 601272).orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo").orderItem("Pasta Primavera").goToCheckout()
			.dismissAllModals().addFavoriteOrder("AutoFavPastaOrder");
		driver.quit();
}
	@Test
	public void orderWithRewardsModal() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
				.chooseCafe("02215", 601272).orderForASAP().clickCategoryPlacard("Pastas")
				.orderItem("Pasta Primavera").goToCheckout().dismissBeverageUpsell().selectRewards("Free Pasta")
				.freeOrderCheckout();
		driver.quit();
}
	@Test
	public void orderWithBeverageUpsellModal() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.chooseCafe("02215", 601272).orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Pasta Primavera").goToCheckout().selectBeverages("Lemonade")
			.dismissBakeryUpsellModal().payWithManualCC(CardTypes.AMEX);
		driver.quit();
}
	@Test
	public void orderWithBakeryUpsellModal() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
			.chooseCafe("02215", 601272).orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Pasta Primavera").clickSidebarCategory("Beverages").orderItem("Soda")
			.goToCheckout().selectBakeryItems("Butter Croissant").payWithManualCC(CardTypes.DISC);
		driver.quit();
	}
}

