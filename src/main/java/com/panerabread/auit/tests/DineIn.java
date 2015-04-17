package com.panerabread.auit.tests;

import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class DineIn {
	@Test
	public void DineInRegManualCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("fortifyqaauto@gmail.com", "bread3")
				.chooseCafe("02215", 601272).enterTableNumber("23").clickCategoryPlacard("Pastas")
				.orderItem("Pasta Primavera").goToCheckout().dismissAllModals().payWithManualCC(CardTypes.VISA);
		driver.quit();
	}
	@Test
	public void DineInRegStoredCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("chaley.tester", "bread3")
				.chooseCafe("02215", 601272).enterTableNumber("23").clickCategoryPlacard("Pastas")
				.orderItem("Chicken Tortellini Alfredo").goToCheckout().dismissAllModals()
				.payWithStoredCC("visa");
		driver.quit();
	}
	@Test
	public void DineInAnonManualCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().orderAsGuest()
				.chooseCafe("02215", 601272).enterTableNumber("23").clickCategoryPlacard("Salads")
				.orderItem("Chicken Cobb with Avocado").goToCheckout()
				.dismissAllModals().payWithManualCC(CardTypes.AMEX).signOut();
		driver.quit();
	}
	/*@Test
	public void registerNewUser() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).registerNewUser("FortifyTest", "Auto", "9124295210", "testemail2@gmail.com", 
				"211 S Tillman St", "Glennville", "GA", "30427", "FortifyTestAuto2",
				"bread3", "bread3", "July", "23", "1993");
			driver.quit();
	}
	@Test
	public void updatePassword() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signInWithPhone("9122372317", "bread3", "Emma")
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
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("chaley.tester", "bread3")
			.updateAccountInfo("ChaleyTaylor2", "Stanfield", "204 Mallard Drive", "Statesboro", "GA", "30458",
					"9122221113", "fortifyqaauto@gmail.com");
		driver.quit();
	}
	@Test
	public void addFavoriteCafe() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("chaley.tester", "bread3")
			.addFavoriteCafe().addNewCafe("63127", 600668);
		driver.quit();
	}
	@Test
	public void addStoredCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("fortifyqaauto@gmail.com", "bread3")
			.addCard().storeCreditCard(null, "FortifyAuto1", "DISC", "6011000000000004", "07", "2020");
		driver.quit();
	}
	@Test
	public void addStoredGC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("chaley.tester", "bread3")
			.addCard().storeGiftCard("test", "6006491611999952725");
		driver.quit();
	}
	@Test
	public void addStoredAddress() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("chaley.tester", "bread3")
			.addAddress().addNewAddress("Home", "211 S Tillman St", null, null, "Glennville", "GA", "30427",
					"9122825210", null);
		driver.quit();
	}
	@Test
	public void addStoredPhoneNumber() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("chaley.tester", "bread3")
			.addPhone().addNewPhone(null, "9122825210");
		driver.quit();
	}
	@Test
	public void updateEmailPreferences() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("chaley.tester", "bread3")
			.updateEmailPreferences().editEmailPreferences("yes", null, null, "yes", "yes", null, null);
		driver.quit();
	}
	@Test
	public void saveFavoriteItem() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("chaley.tester", "bread3")
			.chooseCafe("02215", 601272).enterTableNumber("23").clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo").goToCheckout().dismissAllModals()
			.addFavoriteItem("Pasta Primavera", "AutoFavPasta1");
		driver.quit();
	}
	@Test
	public void saveFavoriteOrder() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("chaley.tester", "bread3")
			.chooseCafe("02215", 601272).enterTableNumber("23").clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo").orderItem("Pasta Primavera").clickSidebarCategory("Salads")
			.orderItem("Thai Chicken Salad").goToCheckout()
			.dismissAllModals().addFavoriteOrder("AutoFavOrder");
		driver.quit();
	}
	@Test
	public void orderWithRewardsModal() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDineInOrder().signIn("fortifyqaauto@gmail.com", "bread3")
				.chooseCafe("02215", 601272).enterTableNumber("23").clickCategoryPlacard("Pastas")
				.orderItem("Pasta Primavera").goToCheckout().dismissBeverageUpsell().selectRewards("Free Pasta")
				.freeOrderCheckout();
		driver.quit();
	}
}