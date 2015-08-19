package com.panerabread.auit.pages.concrete;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.panerabread.auit.pages.OrderConfirmationPage;
import com.panerabread.auit.pages.WebUAccount;
import com.panerabread.auit.pages.WebUDashboard;
import com.panerabread.auit.pages.WebUWelcomeModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultWebUWelcomeModal extends BasePageWithMenuFrame implements WebUWelcomeModal {
	
	public DefaultWebUWelcomeModal(AdvancedWebDriver driver) {
		super(driver);
	}
	
	private final String DASHBOARD=".acknowledgement > ul:nth-child(3) > a:nth-child(1)",
			ACCOUNT_INFO=".acknowledgement > ul:nth-child(3) > a:nth-child(3)",
			WELCOME_MODAL="#overlay-wrapper";
	
	public WebUDashboard viewDashboard() {
		driver().clickByCSS(this.DASHBOARD);
		return PageFactory.getWebUDashboard(driver);
	}
	
	public WebUAccount viewAccount() {
		driver().clickByCSS(this.ACCOUNT_INFO);
		return PageFactory.getWebUAccount(driver);
	}
	
	public WebUWelcomeModal verifyWebULogin() {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.WELCOME_MODAL));
		Assert.assertTrue(isPresent == true);
		return this;
	}

		/*boolean isPresent = driver().checkForElement(By.cssSelector(this.WELCOME_MODAL));
		if (isPresent == true) {
			Assert.assertTrue("Login to WebU successful - isPresent ==", isPresent);
		}
		return PageFactory.getWebUWelcomeModal(driver);
	}*/
	
	/*public OrderConfirmationPage verifyTax(float expectedTax) {
		float aTax = Float.parseFloat(driver().findByCSS(this.TAX).getText().replace("$", ""));
		Assert.assertEquals("Total on order confirmation != " + expectedTax, expectedTax, aTax, 0f);
		return this;
	}*/
}