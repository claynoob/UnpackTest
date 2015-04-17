package com.panerabread.auit.tests;

import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class Troubleshooting {
	@Test
	public void addFavoriteCafe() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.addFavoriteCafe().addNewCafe("95630", 601591);
		driver.quit();
	}
	@Test
	public void saveFavoriteItem() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.enterDeliveryAddress("201 Brookline Ave Boston, MA").chooseDelAddressType("Dormitory")
			.enterPhoneNumber("9126544598").orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo").goToCheckout().dismissAllModals()
			.addFavoriteItem("Chicken Tortellini Alfredo", "AutoFavPasta");
		driver.quit();
	}
	@Test
	public void DeliveryAnonManualCC() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().orderAsGuest()
				.enterDeliveryAddress("201 Brookline Ave Boston, MA").chooseDelAddressType("Dormitory")
				.enterPhoneNumber("9126544598").orderForASAP().clickCategoryPlacard("Salads")
				.orderItem("Chicken Cobb with Avocado").goToCheckout()
				.dismissAllModals().payWithManualCC(CardTypes.AMEX).signOut();
		driver.quit();
	}
	@Test
	public void saveFavoriteOrder() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startDeliveryOrder().signIn("chaley.tester", "bread3")
			.enterDeliveryAddress("201 Brookline Ave Boston, MA").chooseDelAddressType("Dormitory")
			.enterPhoneNumber("9126544598").orderForASAP().clickCategoryPlacard("Pastas")
			.orderItem("Chicken Tortellini Alfredo").orderItem("Pasta Primavera").goToCheckout()
			.dismissAllModals().addFavoriteOrder("AutoFavPastaOrder");
		driver.quit();
	}
}