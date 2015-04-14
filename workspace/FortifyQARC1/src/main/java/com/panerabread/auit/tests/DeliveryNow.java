package com.panerabread.auit.tests;

import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class DeliveryNow {
	@Test
	public void DeliveryRegManualCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.stanfield@panerabread.com", "bread3")
				.enterDeliveryAddress("201 Brookline Ave Boston, MA").chooseDelAddressType("Dormitory")
				.enterPhoneNumber("9126544598").orderForASAP().clickCategoryPlacard("Pastas")
				.orderItem("Pasta Primavera").goToCheckout().dismissAllModals().payWithManualCC(CardTypes.VISA);
		//driver.quit();
	}
	@Test
	public void DeliveryRegStoredCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
				.enterDeliveryAddress("201 Brookline Ave Boston, MA").chooseDelAddressType("Dormitory")
				.enterPhoneNumber("9126544598").orderForASAP().clickCategoryPlacard("Pastas")
				.orderItem("Chicken Tortellini Alfredo").goToCheckout().dismissAllModals()
				.payWithStoredCC("visa");
	
	}
	@Test
	public void DeliveryAnonManualCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().orderAsGuest()
				.enterDeliveryAddress("201 Brookline Ave Boston, MA").chooseDelAddressType("Dormitory")
				.enterPhoneNumber("9126544598").orderForASAP().clickCategoryPlacard("Salads")
				.orderItem("Chicken Cobb with Avocado").goToCheckout()
				.dismissAllModals().payWithManualCC(CardTypes.AMEX).signOut();
	}
	/*@Test
	public void registerNewUser() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).registerNewUser("FortifyTest", "Auto", "9124295210", "testemail2@gmail.com", 
				"211 S Tillman St", "Glennville", "GA", "30427", "FortifyTestAuto2", "bread3", "bread3", "July", "23", "1993");
	}
	@Test
	public void updatePassword() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signInWithPhone("9122372317", "bread3", "Emma")
			.updatePassword("bread3", "bread4", "bread4");
	}
	@Test
	public void resetPassword() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signInWithPhone("9122372317", "bread3", "Emma")
			.updatePassword("bread4", "bread3", "bread3");
	}*/
	@Test
	public void updateAccountInfo() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.updateAccountInfo("ChaleyTaylor", "Stanfield2", "205 Mallard Drive", "Reidsville", "GA", "30453",
					"9122223333", "chaley.stanfield@onshoreoutsourcing.com");
	}
	@Test
	public void addFavoriteCafe() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.addFavoriteCafe().addNewCafe("Savannah, GA", "204389");
	}
	@Test
	public void addStoredCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.addCard().storeCreditCard(null, "FortifyAuto", "MAST", "5500000000000004", "07", "2020");
	}
	@Test
	public void addStoredGC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.addCard().storeGiftCard(null, "6006491611999952758");
	}
	@Test
	public void addStoredAddress() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.addAddress().addNewAddress("Home", "217 S Tillman St", null, null, "Glennville", "GA", "30427",
					"9122375210", null);
	}
	@Test
	public void addStoredPhoneNumber() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.addPhone().addNewPhone(null, "9122375210");
	}
	@Test
	public void updateEmailPreferences() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.updateEmailPreferences().editEmailPreferences(null, "yes", null, null, "yes", "yes", null);
	}
	@Test
	public void saveFavoriteItem() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.enterDeliveryAddress("201 Brookline Ave Boston, MA").chooseDelAddressType("Dormitory")
			.enterPhoneNumber("9126544598").orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo").goToCheckout().dismissAllModals()
			.addFavoriteItem("Chicken Tortellini Alfredo", "AutoFavPasta");
	}
	@Test
	public void saveFavoriteOrder() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.enterDeliveryAddress("201 Brookline Ave Boston, MA").chooseDelAddressType("Dormitory")
			.enterPhoneNumber("9126544598").orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo").orderItem("Pasta Primavera").goToCheckout()
			.dismissAllModals().addFavoriteOrder("AutoFavPastaOrder");
	}
	@Test
	public void orderWithRewardsModal() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.stanfield@panerabread.com", "bread3")
				.enterDeliveryAddress("201 Brookline Ave Boston, MA").chooseDelAddressType("Dormitory")
				.enterPhoneNumber("9126544598").orderForASAP().clickCategoryPlacard("Pastas")
				.orderItem("Pasta Primavera").goToCheckout().dismissBeverageUpsell().selectRewards("Free Pasta")
				.freeOrderCheckout();
	}
}