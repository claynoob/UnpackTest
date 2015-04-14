package com.panerabread.auit.pages.concrete;

import org.junit.Assert;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.pages.HomePage;
import com.panerabread.auit.pages.OrderConfirmationPage;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultOrderConfirmationPage extends BasePage implements
		OrderConfirmationPage {
	
	private final String TOTAL = "div.form-group:nth-child(4) > label:nth-child(2)",
			SUBTOTAL = ".form-horizontal > div:nth-child(1) > label:nth-child(2)",
			TAX = "div.form-group:nth-child(2) > label:nth-child(2)",
			SIGN_OUT="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)";

	public DefaultOrderConfirmationPage(AdvancedWebDriver driver) {
		super(driver);
	}

	public OrderConfirmationPage verifyTotal(float expectedTotal) {
		float aTotal = Float.parseFloat(driver().findByCSS(this.TOTAL).getText().replace("$", ""));
		Assert.assertEquals("Total on order confirmation != " + expectedTotal, expectedTotal, aTotal, 0f);
		return this;
	}

	public OrderConfirmationPage verifySubtotal(float expectedSubtotal) {
		float aSubtotal = Float.parseFloat(driver().findByCSS(this.SUBTOTAL).getText().replace("$", ""));
		Assert.assertEquals("Subtotal on order confirmation != " + expectedSubtotal, expectedSubtotal, aSubtotal, 0f);
		return this;
	}

	public OrderConfirmationPage verifyTax(float expectedTax) {
		float aTax = Float.parseFloat(driver().findByCSS(this.TAX).getText().replace("$", ""));
		Assert.assertEquals("Total on order confirmation != " + expectedTax, expectedTax, aTax, 0f);
		return this;
	}
	
	public HomePage signOut() {
		driver().clickByCSS(this.SIGN_OUT);
		return PageFactory.getQARCHome(driver());
	}
	
}
