package com.panerabread.auit.pages.concrete;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.CheckoutPage;
import com.panerabread.auit.pages.CheckoutPageConfig;
import com.panerabread.auit.pages.OrderConfirmationPage;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultCheckoutPage extends BasePageWithMenuFrame implements CheckoutPage {

	private final String SPECIAL_INSTRUCTIONS = "#specialInstructions",
			PROMO_CODE = "#promoCode", CARDHOLDER_NAME = "#cardName",
			CARD_NUMBER = "form.ng-invalid > bootstrap-decorator:nth-child(6) > div:nth-child(1) > sf-decorator:nth-child(1) > div:nth-child(1) > sf-decorator:nth-child(1) > div:nth-child(1) > input:nth-child(2)", 
			EXPIRY_MONTH = ".col-xs-7 > select:nth-child(2)", 
			EXPIRY_YEAR = ".schema-form-fieldset > sf-decorator:nth-child(4) > div:nth-child(1) > select:nth-child(2)",
			SECURITY_CODE="#securityCode", BILLING_ZIP="#zipCode",
			EMAIL_ADDRESS = "#emailAddress", CONTACT_NUMBER = "#phoneNumber", PLACE_YOUR_ORDER = "input.col-sm-3",
			STORE_CC=".checkbox > label:nth-child(1) > span:nth-child(2)",
			STORE_GC="div.row:nth-child(8) > div:nth-child(2) > gift-card:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			MODAL_CHECK="return (function b(){ return (function a(bakeryModalId){ var selectedBakeryItem = null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(bakeryModal) { if(bakeryModal.innerHTML.indexOf(bakeryModalId)> 0) { selectedBakeryItem = bakeryModal; }}); return selectedBakeryItem; })('%s')})();",
			BEVERAGE_UPSELL_NO_THANKS=".btn-secondary",
			BEVERAGE_PROCEED_TO_PAYMENT="button.btn-secondary:nth-child(2)", 
			SELECT_BEVERAGES="#upsellModal > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(3)",
			ORDER_BEVERAGE="return (function b(){ return (function a(beverageUpsellId){ var selectedBeverage = null; Array.prototype.slice.call(document.querySelectorAll(\'.col-xs-8\')).forEach(function(beverageUpsell) { if(beverageUpsell.innerHTML.indexOf(beverageUpsellId)> 0) { selectedBeverage = beverageUpsell; }}); return selectedBeverage; })('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('btn-primary')[0]})();",
			RETURN_TO_CHECKOUT="#upsellModal > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(2)",
			REWARDS_NO="#rewardModal > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > button:nth-child(1)",
			REWARDS_YES="#rewardModal > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > button:nth-child(2)", BAKERY_NO_THANKS="button.btn-secondary:nth-child(1)",
			SELECT_REWARDS="return (function b(){ return (function a(rewardId){ var selectedReward = null; Array.prototype.slice.call(document.querySelectorAll('.col-xs-12')).forEach(function(reward) { if(reward.innerHTML.indexOf(rewardId)> 0) { selectedReward = reward; }}); return selectedReward; })('%s').parentElement.parentElement.parentElement.getElementsByClassName('btn-primary')[0]})();",
			BAKERY_PROCEED_TO_PAYMENT="button.btn:nth-child(2)", 
			SELECT_BAKERY_ITEMS="#upsellModal > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(2)",
			ORDER_BAKERY_ITEM="return (function b(){ return (function a(bakeryModalId){ var selectedBakeryItem = null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(bakeryModal) { if(bakeryModal.innerHTML.indexOf(bakeryModalId)> 0) { selectedBakeryItem = bakeryModal; }}); return selectedBakeryItem; })('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('btn-primary')[0]})();",
			BAKERY_RETURN_TO_CHECKOUT="#upsellModal > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)",
			STORED_CC_RADIO_BTN="div.radio:nth-child(2) > label:nth-child(1) > input:nth-child(1)",
			MANUAL_CC_RADIO_BTN="div.radio:nth-child(3) > label:nth-child(1) > input:nth-child(1)",
			STORED_CC_NAME=".store-cc-dd > select:nth-child(2)",
			MANUAL_GC="#cardNumber", GC_APPLY="div.pull-right > input:nth-child(1)",
			ADD_ITEM_TO_FAVORITES="return (function b(){ return (function a(itemId){var selectedItem = null; Array.prototype.slice.call(document.querySelectorAll('h4')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {selectedItem = item;}}); return selectedItem;}) ('%s').parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByTagName('add-favorite')[0]})();",
			ADD_ORDER_TO_FAVORITES="add-favorite.ng-isolate-scope:nth-child(1)",
			FAV_NAME="#favoriteName", SAVE_FAV="form.ng-dirty > bootstrap-decorator:nth-child(2) > div:nth-child(1) > input:nth-child(1)",
			INGREDIENT_CHECK="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('span')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s')})();",
			DELETE_ITEM="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.nextElementSibling.getElementsByClassName('col-xs-2')[0]})();",
			DELETE_COMBO="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.nextElementSibling.lastElementChild.lastElementChild.getElementsByClassName('col-xs-2')[0]})();",
			DELETE_CONFIRM=".confirmation-modal > div:nth-child(5) > div:nth-child(1) > button:nth-child(1)",
			DELETE_DENY="button.btn-default:nth-child(2)",
			DUPLICATE_ITEM="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.nextElementSibling.getElementsByClassName('col-xs-3')[0]})();",
			DUPLICATE_COMBO="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.nextElementSibling.lastElementChild.lastElementChild.lastElementChild.getElementsByClassName('col-xs-3')[0]})();",
			CUSTOMIZE_ITEM="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s').parentElement.parentElement.parentElement.parentElement.nextElementSibling.lastElementChild.lastElementChild.lastElementChild.getElementsByClassName('col-xs-4')[0]})();",
			CUSTOMIZE_COMBO="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.nextElementSibling.lastElementChild.lastElementChild.lastElementChild.getElementsByClassName('col-xs-4')[0]})();",
			ITEM_PRICE="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('text-right')[0].firstElementChild.innerHTML})();";
	 
	public DefaultCheckoutPage(AdvancedWebDriver driver) {
		super(driver);
	}
	
	public OrderConfirmationPage payWithCC(CardTypes type, String number, String storedManual, 
			String nameStoredCC, boolean storeCC) {
		if (System.getProperty("environment").equalsIgnoreCase("prod") == false) {
			number = findCardNumber(type);
		}
		populateCheckoutFormCC(new CheckoutPageConfig(type, number), storedManual, nameStoredCC);
		if (storeCC == true) {
			storeCardCheck(this.STORE_CC, getCardInfo(type, number));
		}
		submit();
		return PageFactory.getOrderConfirmationPage(driver);
	}
	
	public OrderConfirmationPage payWithGC(String GCNum, String storedManual, boolean storeGC) {
		populateCheckoutFormGC(new CheckoutPageConfig(null, null), GCNum, storedManual);
		if (storeGC == true) {
			storeCardCheck(this.STORE_GC, GCNum);
		}
		submit();
		return PageFactory.getOrderConfirmationPage(driver);	
	}
	
	public OrderConfirmationPage payWithGCAndCC(String GCNum, String GCStoredManual, boolean storeGC, 
			CardTypes type, String CCNum, String CCStoredManual, String nameStoredCC, boolean storeCC) {
		if (System.getProperty("environment").equalsIgnoreCase("prod") == false) {
			CCNum = findCardNumber(type);
		}
		populateCheckoutFormGC(new CheckoutPageConfig(null, null), GCNum, GCStoredManual);
		if (storeCC == true) {
			storeCardCheck(this.STORE_GC, GCNum);
		}
		populateCheckoutFormCC(new CheckoutPageConfig(type, CCNum), CCStoredManual, nameStoredCC);
		if (storeCC == true) {
			storeCardCheck(this.STORE_CC, getCardInfo(type, CCNum));
		}		
		submit();
		return PageFactory.getOrderConfirmationPage(driver);	
	}
	
	public CheckoutPage storeCardCheck(String format, String cardInfo) {
		driver().clickByCSS(format);
		setCardInfo(format, cardInfo);
		return this;
	}
	
	public void setCardInfo(String format, String cardNum) {
		if (format.equals(this.STORE_CC)) {
			{System.setProperty("storedCCNum", cardNum);}
		}
		if(format.equals(this.STORE_GC)) {
			{System.setProperty("storedGCNum", cardNum);}
		}
	}
	
	public String getCardInfo(CardTypes type, String cardNum) {
		String cardInfo = type.toString() + " " + cardNum;
		return cardInfo;
	}
	
	public OrderConfirmationPage freeOrderCheckout() {
		CheckoutPageConfig config = new CheckoutPageConfig(null, null);
		populateEmailAndPhone(config);
		return submit();
	}
	
	public OrderConfirmationPage submit() {
		driver().clickByCSS(this.PLACE_YOUR_ORDER);
		driver().pause(5000);
		return PageFactory.getOrderConfirmationPage(driver());
	}
	
	public CheckoutPage populateSpecInstructionsPromoCode(CheckoutPageConfig config) {
		if (System.getProperty("environment").equalsIgnoreCase("qarc")) {
			safeSendKeys(driver().findByCSS(this.SPECIAL_INSTRUCTIONS), config.getProdSpecialInstructions());
		}
		else {
			safeSendKeys(driver().findByCSS(this.SPECIAL_INSTRUCTIONS), config.getSpecialInstructions());
		}
		safeSendKeys(driver().findByCSS(this.PROMO_CODE), config.getSpecialcode());
		return this;
	}
	
	public CheckoutPage populateCheckoutFormCC(CheckoutPageConfig config, String storedManual, String nameStoredCC) {
		populateSpecInstructionsPromoCode(config);
		checkCCStoredManual(storedManual, config, nameStoredCC);
		populateEmailAndPhone(config);
		return this;
	}
	
	public void checkCCStoredManual(String storedManual, CheckoutPageConfig config, String nameStoredCC) {
		if (storedManual.toLowerCase() == "manual") {
			if(checkForCCRadioBtns() == true){
				driver().clickByCSS(MANUAL_CC_RADIO_BTN);
			}
			safeSendKeys(driver().findByCSS(this.CARD_NUMBER), config.getCardNumber());
			driver().dropdownSelectByText(driver().findByCSS(this.EXPIRY_MONTH), config.getExpireMonth());
			driver().dropdownSelectByText(driver().findByCSS(this.EXPIRY_YEAR), config.getExpireYear());
			try {
				driver().findByCSS(this.SECURITY_CODE).sendKeys(config.getSecurityCode());
				driver().findByCSS(this.BILLING_ZIP).sendKeys(config.getBillingZip());
			}
			catch (Exception e) {
			}
			safeSendKeys(driver().findByCSS(this.CARDHOLDER_NAME), config.getCardHolderName());
			
		}
		if (storedManual.toLowerCase() == "stored") {
			if(checkForCCRadioBtns() == true){
				driver().clickByCSS(this.STORED_CC_RADIO_BTN);
			}
			driver().clickByCSS(this.STORED_CC_NAME);
			driver().findByCSS(this.STORED_CC_NAME).sendKeys(nameStoredCC);
		}
	}
	
	public CheckoutPage verifyItemPrices() throws IOException {
		driver().captureScreenshot();
		return this;
	}
	
	public CheckoutPage verifyCardDisplaysInDropDown(String ccInfo) {
		boolean isPresent = false;
		try {
			driver().findByJavascript(String.format(this.STORED_CC_NAME, ccInfo));
			isPresent = true;
		}
		catch (Exception e) {
		}
		Assert.assertTrue("Card should be present in dropdown: " + ccInfo, isPresent);
		return this;
	}
	
	public CheckoutPage verifyCardNotInDropDown(String ccInfo) {
		boolean notPresent = true;
		try {
			driver().findByJavascript(String.format(this.STORED_CC_NAME, ccInfo));
			notPresent = false;
		}
		catch (Exception e) {
		}
		Assert.assertTrue("Card should not be present in dropdown: " + ccInfo, notPresent);
		return this;
	}
	
	public CheckoutPage populateCheckoutFormGC(CheckoutPageConfig config, String GCNum, String storedManual) {
		populateSpecInstructionsPromoCode(config);
		checkGCStoredManual(storedManual, GCNum);
		populateEmailAndPhone(config);
		return this;
	}
	
	public void checkGCStoredManual(String storedManual, String GCNum) {
		if (storedManual.toLowerCase() == "manual") {
			driver().findByCSS(this.MANUAL_GC).sendKeys(GCNum);
			driver().clickByCSS(this.GC_APPLY);
		}
		if (storedManual.toLowerCase() == "stored") {
			driver().clickByCSS(this.GC_APPLY);
			driver().pause(1000);
		}
	}
	
	public CheckoutPage populateEmailAndPhone(CheckoutPageConfig config) {
		driver().findByCSS(this.CONTACT_NUMBER).clear();
			safeSendKeys(driver().findByCSS(this.CONTACT_NUMBER), config.getPhone());
			driver().findByCSS(this.EMAIL_ADDRESS).clear();
			safeSendKeys(driver().findByCSS(this.EMAIL_ADDRESS), config.getEmail());
		return this;
	}
		
	public CheckoutPage dismissBeverageUpsell() {
		try {
			driver().findByJavascript(String.format(this.MODAL_CHECK, "Would you like to add a drink?"));
			driver().clickByCSS(this.BEVERAGE_UPSELL_NO_THANKS);
		}
		catch (Exception e) {
		}
		return PageFactory.getCheckoutPage(driver());
	}
	
	public CheckoutPage beverageProceedToPayment() {
		if(driver().checkForElement(By.cssSelector(this.BEVERAGE_PROCEED_TO_PAYMENT))){
			driver().clickByCSS(this.BEVERAGE_PROCEED_TO_PAYMENT);
		}
		return PageFactory.getCheckoutPage(driver());
	}
	
	public CheckoutPage selectBeverages(String beverage) {
		if(driver().checkForElement(By.cssSelector(this.SELECT_BEVERAGES))){
			driver().clickByCSS(SELECT_BEVERAGES);
			driver().clickByJavascript(String.format(this.ORDER_BEVERAGE, beverage));
			driver().clickByCSS(this.RETURN_TO_CHECKOUT);
		}
			return this;
	}
	
	public CheckoutPage dismissRewards() {
		if(driver().checkForElement(By.cssSelector(this.REWARDS_NO))){
			driver().clickByCSS(REWARDS_NO);
		}
		return PageFactory.getCheckoutPage(driver());
	}
	
	public CheckoutPage selectRewards(String reward) {
		if(driver().checkForElement(By.cssSelector(this.REWARDS_YES))){
			driver().clickByCSS(REWARDS_YES);
			driver().clickByJavascript(String.format(this.SELECT_REWARDS, reward));
		}
		return this;
	}

	public CheckoutPage dismissBakeryUpsellModal() {
		try {
			driver().findByJavascript(String.format(this.MODAL_CHECK, 
					"You are eligible for a special price on the bakery item of your choice"));
			driver().clickByCSS(this.BEVERAGE_UPSELL_NO_THANKS);
		}
		catch (Exception e) {
		}
		return PageFactory.getCheckoutPage(driver());
	}
	
	public CheckoutPage bakeryProceedToPayment() {
		if(driver().checkForElement(By.cssSelector(this.BAKERY_PROCEED_TO_PAYMENT))){
			driver().clickByCSS(this.BAKERY_PROCEED_TO_PAYMENT);
		}
		return PageFactory.getCheckoutPage(driver());
	}
	
	public CheckoutPage selectBakeryItems(String bakeryItem) {
		if(driver().checkForElement(By.cssSelector(this.SELECT_BAKERY_ITEMS))){
			driver().clickByCSS(SELECT_BAKERY_ITEMS);
			driver().clickByJavascript(String.format(this.ORDER_BAKERY_ITEM, bakeryItem));
			driver().clickByCSS(this.BAKERY_RETURN_TO_CHECKOUT);
		}
		return this;
	}
	
	public Boolean checkForCCRadioBtns() {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.MANUAL_CC_RADIO_BTN));
		return isPresent;
	}
	
	public CheckoutPage dismissAllModals() {
		driver().pause(1000);
		dismissBeverageUpsell();
		driver().pause(1000);
		dismissBakeryUpsellModal();
		driver().pause(1000);
		dismissRewards();
		return PageFactory.getCheckoutPage(driver());
	}
	
	public CheckoutPage addFavoriteItem(String item, String name) {
		driver().clickByJavascript(String.format(this.ADD_ITEM_TO_FAVORITES, item));
		driver().findByCSS(this.FAV_NAME).sendKeys(name);
		driver().clickByCSS(this.SAVE_FAV);
		return PageFactory.getCheckoutPage(driver());
	}
	
	public CheckoutPage addFavoriteOrder(String name) {
		driver().clickByCSS(this.ADD_ORDER_TO_FAVORITES);
		driver().findByCSS(this.FAV_NAME).sendKeys(name);
		driver().clickByCSS(this.SAVE_FAV);
		return PageFactory.getCheckoutPage(driver());
	}
	
	public CheckoutPage verifyModifications(String item, String[] ingredients) {
		for (int i = 0; i < ingredients.length; i++) {
			WebElement modification = driver().findByJavascript(String.format(this.INGREDIENT_CHECK, ingredients[i]));
			Assert.assertTrue("Modification not applied: " + ingredients[i], (modification != null));
		}
			return this;
	}
	
	public CheckoutPage deleteItem(Boolean isCombo, String item, Boolean yesDelete) {
		if (isCombo == true) {
			System.out.println(String.format(this.DELETE_COMBO, item));
			driver().clickByJavascript(String.format(this.DELETE_COMBO, item));
		}
		else {
			System.out.println(String.format(this.DELETE_ITEM, item));
			driver().clickByJavascript(String.format(this.DELETE_ITEM, item));
		}
		confirmDelete(yesDelete);
		driver().pause(1000);
		return this;
	}
	
	public CheckoutPage confirmDelete(Boolean yesDelete) {
		if (yesDelete == true) {
			driver().clickByCSS(this.DELETE_CONFIRM);
		}
		else {
			driver().clickByCSS(this.DELETE_DENY);
		}
		return this;
	}
	
	public CheckoutPage duplicateItem(Boolean isCombo, String item) {
		if (isCombo == true) {
			driver().clickByJavascript(String.format(this.DUPLICATE_COMBO, item));
		}
		else {
			System.out.println(String.format(this.DUPLICATE_ITEM, item));
			driver().clickByJavascript(String.format(this.DUPLICATE_ITEM, item));
		}		
		return this;
	}
	
	public CheckoutPage customizeItem(Boolean isCombo, String item) {
		if (isCombo == true) {
			driver().clickByJavascript(String.format(this.CUSTOMIZE_COMBO, item));
		}
		else {
		driver().clickByJavascript(String.format(this.CUSTOMIZE_ITEM, item));
		}		
		return this;
	}
	
	public CheckoutPage verifyItemPrice(String item, float expectedPrice) {
		//driver().findByJavascript(String.format(this.ITEM_PRICE, item));
		String price = driver().findByJavascript(String.format(this.ITEM_PRICE, item)).getText();
		float aPrice = Float.parseFloat(price.replace("$", ""));
		Assert.assertEquals("Total on order confirmation != " + expectedPrice, expectedPrice, aPrice, 0f);
		
		/*boolean isCorrect = (driver().findByJavascript(String.format(this.ITEM_PRICE, item)).getText() == expectedPrice);
		Assert.assertTrue("Item price is incorrect. Price should be: " + expectedPrice 
				+ " Actual price was: ", isCorrect);*/
		return this;
	}
	
	/*public WebElement getItemPrice(String item) {
		WebElement price = driver().findByJavascript(String.format(this.ITEM_PRICE, item));
		System.out.println(price);
		return price;
	}*/
	
}
