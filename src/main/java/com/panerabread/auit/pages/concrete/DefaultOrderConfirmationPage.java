package com.panerabread.auit.pages.concrete;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.panerabread.auit.pages.OrderConfirmationPage;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultOrderConfirmationPage extends BasePageWithMenuFrame implements
		OrderConfirmationPage {
	
	private final String DEL_TOTAL = "div.form-group:nth-child(6) > label:nth-child(2)",
			TOTAL="div.form-group:nth-child(5) > label:nth-child(2)",
			SUBTOTAL = ".form-horizontal > div:nth-child(1) > label:nth-child(2)",
			TAX = "div.form-group:nth-child(2) > label:nth-child(2)",
			DATE=".col-xs-5 > div:nth-child(1) > div:nth-child(2)",
			ORDER_NUMBER="div.row-spaced:nth-child(1) > div:nth-child(1)",
			ORDER_TYPE=".col-xs-5 > div:nth-child(1) > div:nth-child(1)",
			INGREDIENT_CHECK="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('span')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s')})();";

	public DefaultOrderConfirmationPage(AdvancedWebDriver driver) {
		super(driver);
	}
	
	public OrderConfirmationPage getOrderInfo() throws IOException {
		String total = null;
		try {
			total = driver().findByCSS(this.TOTAL).getText();
			{System.setProperty("total", total);}
		}
		catch (Exception e) {
			{System.setProperty("total", driver().findByCSS(this.DEL_TOTAL).getText());}
		}
		driver().captureScreenshot();
		{System.setProperty("datePlaced", driver().getDate());}
		{System.setProperty("subtotal", driver().findByCSS(this.SUBTOTAL).getText());}
		{System.setProperty("tax", driver().findByCSS(this.TAX).getText());}
		{System.setProperty("orderNumber", driver().findByCSS(this.ORDER_NUMBER).getText());}
		System.out.println(driver().findByCSS(this.ORDER_NUMBER).getText());
		return this;
	}
	
	public String getFulfillmentDate(String date) {
		String day = date.substring(0, 1);
		String month = date.substring(3, 4);
		String year = date.substring(date.length()-2);
		if (day.endsWith("/")) {
			day = "0" + day;
		}
		if (month.endsWith("/")) {
			month = "0" + month;
		}
		String newDate = day + month + year;
		return newDate.replace("/", ".");
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
	
	public OrderConfirmationPage verifySuccessfulOrder() throws IOException {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.ORDER_NUMBER));
		Assert.assertTrue("Order Number is not displayed", isPresent == true);
		getOrderInfo();
		return this;
	}
	
	public OrderConfirmationPage verifyModifications(String item, String[] ingredients){
		for (int i = 0; i < ingredients.length; i++) {
			WebElement modification = driver().findByJavascript(String.format(this.INGREDIENT_CHECK, ingredients[i]));
			Assert.assertTrue("Modification not applied: " + ingredients[i], (modification != null));
		}
			return this;
	}
	
}
