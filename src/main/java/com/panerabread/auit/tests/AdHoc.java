package com.panerabread.auit.tests;

import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class AdHoc {
	@Test
	public void run() {
		AdvancedWebDriver driver = AdvancedWebDriverFactory.getFirefoxDriver(10);
		PageFactory.getQARCHome(driver).startRPUOrder().signIn("chaley.tester", "bread3")
				.chooseCafe("02215", 601272).orderForASAP().clickCategoryPlacard("Pastas")
				.orderItem("Pasta Primavera").goToCheckout().dismissAllModals().payWithManualCC(CardTypes.VISA)
				.verifySubtotal(8.39f).verifyTax(0.59f).verifyTotal(8.98f);
		driver.quit();
	}
}