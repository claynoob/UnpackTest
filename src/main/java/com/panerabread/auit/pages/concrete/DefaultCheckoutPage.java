package com.panerabread.auit.pages.concrete;

import org.openqa.selenium.By;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.CheckoutPage;
import com.panerabread.auit.pages.CheckoutPageConfig;
import com.panerabread.auit.pages.OrderConfirmationPage;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultCheckoutPage extends BasePage implements CheckoutPage {

	private final String SPECIAL_INSTRUCTIONS = "#specialInstructions",
			PROMO_CODE = "#promoCode",
			CARDHOLDER_NAME = "#cardName", CARD_TYPE = "div.col-xs-2:nth-child(1) > select:nth-child(2)",
			CARD_NUMBER = "form.ng-invalid:nth-child(1) > bootstrap-decorator:nth-child(4) > div:nth-child(1) > sf-decorator:nth-child(3) > div:nth-child(1) > sf-decorator:nth-child(2) > div:nth-child(1) > input:nth-child(2)", 
			EXPIRY_MONTH = ".col-xs-7 > select:nth-child(2)", EXPIRY_YEAR = "div.col-xs-4:nth-child(1) > select:nth-child(2)",
			EMAIL_ADDRESS = "#emailAddress", CONTACT_NUMBER = "#phoneNumber", PLACE_YOUR_ORDER = "input.col-xs-3",
			BEVERAGE_UPSELL_NO_THANKS="#upsellModal > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button.btn-secondary:nth-child(1)",
			BEVERAGE_PROCEED_TO_PAYMENT="button.btn-secondary:nth-child(2)", 
			SELECT_BEVERAGES="#upsellModal > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(3)",
			ORDER_BEVERAGE="return (function b(){ return (function a(beverageUpsellId){ var selectedBeverage = null; Array.prototype.slice.call(document.querySelectorAll(\'.col-xs-8\')).forEach(function(beverageUpsell) { if(beverageUpsell.innerHTML.indexOf(beverageUpsellId)> 0) { selectedBeverage = beverageUpsell; }}); return selectedBeverage; })('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('btn-primary')[0]})();",
			RETURN_TO_CHECKOUT="#upsellModal > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(2)",
			REWARDS_NO="#rewardModal > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > button:nth-child(1)",
			REWARDS_YES="button.ng-binding:nth-child(2)", BAKERY_NO_THANKS="button.btn-secondary:nth-child(1)",
			SELECT_REWARDS="return (function b(){ return (function a(rewardId){ var selectedReward = null; Array.prototype.slice.call(document.querySelectorAll('.col-xs-12')).forEach(function(reward) { if(reward.innerHTML.indexOf(rewardId)> 0) { selectedReward = reward; }}); return selectedReward; })('%s').parentElement.parentElement.parentElement.getElementsByClassName('btn-primary')[0]})();",
			BAKERY_PROCEED_TO_PAYMENT="button.btn:nth-child(2)", 
			SELECT_BAKERY_ITEMS="#upsellModal > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(3)",
			ORDER_BAKERY_ITEM="return (function b(){ return (function a(bakeryModalId){ var selectedBakeryItem = null; Array.prototype.slice.call(document.querySelectorAll(\'.col-xs-8\')).forEach(function(bakeryModal) { if(bakeryModal.innerHTML.indexOf(bakeryModalId)> 0) { selectedBakeryItem = bakeryModal; }}); return selectedBakeryItem; })('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('btn-primary')[0]})();",
			BAKERY_RETURN_TO_CHECKOUT="#upsellModal > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)",
			STORED_CC_RADIO_BTN="div.radio:nth-child(2) > label:nth-child(1) > input:nth-child(1)",
			STORED_CC_NAME=".store-cc-dd",
			MANUAL_CC_RADIO_BTN="div.radio:nth-child(3) > label:nth-child(1) > input:nth-child(1)",
			MANUAL_GC="#cardNumber", GC_APPLY="div.pull-right > input:nth-child(1)",
			ADD_ITEM_TO_FAVORITES="return (function b(){ return (function a(itemId){var selectedItem = null; Array.prototype.slice.call(document.querySelectorAll('h4')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {selectedItem = item;}}); return selectedItem;}) ('%s').parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByTagName('add-favorite')[0]})();",
			ADD_ORDER_TO_FAVORITES="add-favorite.ng-isolate-scope:nth-child(1)",
			FAV_NAME="#favoriteName",
			SAVE_FAV="input.pull-right";
	public DefaultCheckoutPage(AdvancedWebDriver driver) {
		super(driver);
	}

	public OrderConfirmationPage payWithManualCC(CardTypes type) {
		String number = null;
		if (type == CardTypes.VISA){
			number = "4111111111111111";
		}
		if (type == CardTypes.DISC){
			number = "6011000000000004";
		}
		if (type == CardTypes.AMEX){
			number = "340000000000009";
		}
		if (type == CardTypes.MAST){
			number = "5500000000000004";
		}
		populateCheckoutFormManualCC(new CheckoutPageConfig(type, number));
		return submit();
	}
		
	public OrderConfirmationPage payWithManualGC(String GCNum) {
		populateCheckoutFormManualGC(new CheckoutPageConfig(null, null), GCNum);
		return submit();
	}
	
	public OrderConfirmationPage payWithStoredCC(String cardName){
		populateCheckoutFormStoredCC(new CheckoutPageConfig(null, null), cardName);
		return submit();
	}
	
	public OrderConfirmationPage payWithStoredGC(){
		populateCheckoutFormStoredGC(new CheckoutPageConfig(null, null));
		return submit();
	}
	

	public OrderConfirmationPage freeOrderCheckout() {
		CheckoutPageConfig config = new CheckoutPageConfig(null, null);
		if (driver().findByCSS(this.CONTACT_NUMBER) == null) {
			safeSendKeys(this.CONTACT_NUMBER, config.getPhone());
		}
		if (driver().findByCSS(this.EMAIL_ADDRESS) == null) {
		safeSendKeys(this.EMAIL_ADDRESS, config.getEmail());
		}
		return submit();
	}

	public OrderConfirmationPage submit() {
		driver().clickByCSS(this.PLACE_YOUR_ORDER);
		driver().pause(5000);
		return PageFactory.getOrderConfirmationPage(driver());
	}

	public CheckoutPage populateCheckoutFormManualCC(CheckoutPageConfig config) {
		safeSendKeys(this.SPECIAL_INSTRUCTIONS, config.getSpecialInstructions());
		safeSendKeys(this.PROMO_CODE, config.getSpecialcode());
		if(checkForCCRadioBtns() == true){
			driver.clickByCSS(MANUAL_CC_RADIO_BTN);
		}
		safeSendKeys(this.CARDHOLDER_NAME, config.getCardHolderName());
		driver().dropdownSelectByText(driver().findByCSS(this.CARD_TYPE), config.getCardType());
		safeSendKeys(this.CARD_NUMBER, config.getCardNumber());
		driver().dropdownSelectByText(driver().findByCSS(this.EXPIRY_MONTH), config.getExpireMonth());
		driver().dropdownSelectByText(driver().findByCSS(this.EXPIRY_YEAR), config.getExpireYear());
		if (driver().findByCSS(this.CONTACT_NUMBER) == null) {
			safeSendKeys(this.CONTACT_NUMBER, config.getPhone());
		}
		if (driver().findByCSS(this.EMAIL_ADDRESS) == null) {
		safeSendKeys(this.EMAIL_ADDRESS, config.getEmail());
		}
		return this;
	}
	
	public CheckoutPage populateCheckoutFormManualGC(CheckoutPageConfig config, String giftCard) {
		safeSendKeys(this.SPECIAL_INSTRUCTIONS, config.getSpecialInstructions());
		safeSendKeys(this.PROMO_CODE, config.getSpecialcode());
		driver().findByCSS(MANUAL_GC).sendKeys(giftCard);
		driver().clickByCSS(GC_APPLY);
		if (driver().findByCSS(this.CONTACT_NUMBER) == null) {
			safeSendKeys(this.CONTACT_NUMBER, config.getPhone());
		}
		if (driver().findByCSS(this.EMAIL_ADDRESS) == null) {
		safeSendKeys(this.EMAIL_ADDRESS, config.getEmail());
		}
		return this;
	}

	public CheckoutPage populateCheckoutFormStoredCC(CheckoutPageConfig config, String name) {
		safeSendKeys(this.SPECIAL_INSTRUCTIONS, config.getSpecialInstructions());
		safeSendKeys(this.PROMO_CODE, config.getSpecialcode());
		if(checkForCCRadioBtns() == true){
			driver().clickByCSS(STORED_CC_RADIO_BTN);
		}
		driver().findByCSS(this.STORED_CC_NAME).sendKeys(name);
		if (driver().findByCSS(this.CONTACT_NUMBER) == null) {
			safeSendKeys(this.CONTACT_NUMBER, config.getPhone());
		}
		if (driver().findByCSS(this.EMAIL_ADDRESS) == null) {
		safeSendKeys(this.EMAIL_ADDRESS, config.getEmail());
		}
		return this;
	}
	
	public CheckoutPage populateCheckoutFormStoredGC(CheckoutPageConfig config) {
		safeSendKeys(this.SPECIAL_INSTRUCTIONS, config.getSpecialInstructions());
		safeSendKeys(this.PROMO_CODE, config.getSpecialcode());
		//Need to add way to select GC from dropdown
		driver().clickByCSS(GC_APPLY);
		driver().pause(1000);
		if (driver().findByCSS(this.CONTACT_NUMBER) == null) {
			safeSendKeys(this.CONTACT_NUMBER, config.getPhone());
		}
		if (driver().findByCSS(this.EMAIL_ADDRESS) == null) {
		safeSendKeys(this.EMAIL_ADDRESS, config.getEmail());
		}
		return this;
	}
	
	private void safeSendKeys(String cssSelector, String value) {
		if (value != null) {
			driver().findByCSS(cssSelector).sendKeys(value);
		}
	}
	
	public CheckoutPage dismissBeverageUpsell() {
		if(driver().checkForElement(By.cssSelector(this.BEVERAGE_UPSELL_NO_THANKS))){
			driver().clickByCSS(this.BEVERAGE_UPSELL_NO_THANKS);
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
			driver().clickByCSS(this.SELECT_BEVERAGES);
			driver().clickByJavascript(String.format(this.ORDER_BEVERAGE, beverage));
			driver().clickByCSS(RETURN_TO_CHECKOUT);
		}
			return this;
	}

	public CheckoutPage dismissRewards() {
		if(driver().checkForElement(By.cssSelector(this.REWARDS_NO))){
			driver().clickByCSS(this.REWARDS_NO);
		}
		return PageFactory.getCheckoutPage(driver());
	}
	
	public CheckoutPage selectRewards(String reward) {
		if(driver().checkForElement(By.cssSelector(this.REWARDS_YES))){
			driver().clickByCSS(this.REWARDS_YES);
			driver().clickByJavascript(String.format(this.SELECT_REWARDS, reward));
		}
		return this;
	}


	public CheckoutPage dismissBakeryUpsellModal() {
		if(driver().checkForElement(By.cssSelector(this.BAKERY_NO_THANKS))){
			driver().clickByCSS(this.BAKERY_NO_THANKS);
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
			driver().clickByCSS(this.SELECT_BAKERY_ITEMS);
			driver().clickByJavascript(String.format(this.ORDER_BAKERY_ITEM, bakeryItem));
			driver().clickByCSS(BAKERY_RETURN_TO_CHECKOUT);
		}
		return this;
	}
	
	public Boolean checkForCCRadioBtns() {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.MANUAL_CC_RADIO_BTN));
		return isPresent;
	}
	
	public CheckoutPage dismissAllModals() {
		dismissBeverageUpsell();
		dismissRewards();
		dismissBakeryUpsellModal();
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
			
}
