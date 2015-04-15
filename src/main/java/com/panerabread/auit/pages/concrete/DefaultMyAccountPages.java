package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultMyAccountPages extends BasePage {
		private final String ADD_NEW_ADDRESS=".btn-primary", ADDRESS_TYPE="#type", NEW_ADDRESS="#address1", NAME="#name",
		SUITE_APT_NUM="#identifier", NEW_CITY="#city", NEW_STATE="#state", NEW_ZIP="#zip",
		PHONE="#primaryPhone", INSTRUCTIONS="#additionalInfo", SAVE_ADDRESS=".text-right > button:nth-child(1)",
		CANCEL_ADD_ADDRESS="button.btn:nth-child(2)", ADD_PHONE=".btn-primary", PHONE_NAME="#name", ADD_NUMBER="#number", 
		SAVE_PHONE=".text-right > button:nth-child(1)", CANCEL_ADD_PHONE=".text-right > button:nth-child(1)",
		ADD_FAV_CAFE=".btn-primary", SEARCH="#cafeSearch",
		CHOOSE_CAFE="return (function b(){ return (function a(cafeId){var foundCafe = null; Array.prototype.slice.call(document.querySelectorAll('.cafeName')).forEach(function(cafe) {if(cafe.innerHTML.indexOf(cafeId) > 0) {foundCafe = cafe;}}); return foundCafe;}) ('601272').parentElement.parentElement.nextSibling.nextSibling.getElementsByTagName('a')[0]})();",
		ADD_CREDIT_CARD="my-cards.ng-scope > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h1:nth-child(1) > button:nth-child(1)",
		NICKNAME="#cardName", CARDHOLDER_NAME="#cardHolderName", CARD_TYPE="select.ng-invalid",
		CARD_NUMBER="#cardNum", EXPIRY_MONTH=".col-xs-7 > select:nth-child(2)",
		EXPIRY_YEAR="sf-decorator.ng-scope:nth-child(4) > div:nth-child(1) > select:nth-child(2)",
		SAVE="input.btn", CANCEL="button.col-xs-2",
		ADD_GIFT_CARD="my-cards.ng-scope > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h1:nth-child(1) > button:nth-child(1)",
		EMAIL_PREF_OPT_IN_OUT="#emailPreferences\\.optIn",
		REWARDS_AND_ALERTS="#emailPreferences\\.preferences\\[0\\]\\.allow",
		UPDATES_AND_SPECIAL_OFFERS="#emailPreferences\\.preferences\\[1\\]\\.allow",
		LOCAL_NEWS="#emailPreferences\\.preferences\\[2\\]\\.allow",
		IN_PERSON_ONLINE_EVENTS="#emailPreferences\\.preferences\\[3\\]\\.allow",
		COMMUNICATION_WITH_OTHER_MEMBERS="#emailPreferences\\.preferences\\[4\\]\\.allow",
		SHARE_YOUR_THOUGHTS="#emailPreferences\\.preferences\\[5\\]\\.allow",
		UPDATE=".btn-primary";
		
		public DefaultMyAccountPages(AdvancedWebDriver driver) {
			super(driver);
		}
		
		public DefaultMyAccountPages addNewAddress(String type, String address, String name, String suite, 
				String city, String state, String zip, String phone, String instructions) {
			driver().clickByCSS(this.ADD_NEW_ADDRESS);
			driver().findByCSS(this.ADDRESS_TYPE).sendKeys(type);
			driver().findByCSS(this.NEW_ADDRESS).sendKeys(address);
			driver().findByCSS(this.NAME).sendKeys(name);
			driver().findByCSS(this.SUITE_APT_NUM).sendKeys(suite);
			driver().findByCSS(this.NEW_CITY).sendKeys(city);
			driver().findByCSS(this.NEW_STATE).sendKeys(state);
			driver().findByCSS(this.NEW_ZIP).sendKeys(zip);
			driver().findByCSS(this.PHONE).sendKeys(phone);
			driver().findByCSS(this.INSTRUCTIONS).sendKeys(instructions);
			driver().clickByCSS(this.SAVE_ADDRESS);
			return PageFactory.getMyAccountPages(driver());
		}
		public DefaultMyAccountPages addNewPhone(String name, String number) {
			driver().clickByCSS(this.ADD_PHONE);
			driver().findByCSS(this.PHONE_NAME).sendKeys(name);
			driver().findByCSS(this.ADD_NUMBER).sendKeys(number);
			driver().clickByCSS(this.SAVE_PHONE);
			return PageFactory.getMyAccountPages(driver());
		}
		
		public DefaultMyAccountPages addNewCafe(String search, String cafeNumber) {
			driver().clickByCSS(this.ADD_FAV_CAFE);
			driver().findByCSS(this.SEARCH).sendKeys(search);
			driver().findByJavascript(String.format(this.CHOOSE_CAFE, cafeNumber)).click();
			return PageFactory.getMyAccountPages(driver());
		}
		
		public DefaultMyAccountPages storeCreditCard(String nickname, String cardholderName, String type, 
				String number, String expMonth, String expYear) {
			driver().clickByCSS(this.ADD_CREDIT_CARD);
			driver().findByCSS(this.NICKNAME).sendKeys(nickname);
			driver().findByCSS(this.CARDHOLDER_NAME).sendKeys(cardholderName);
			driver().findByCSS(this.CARD_TYPE).sendKeys(type);
			driver().findByCSS(this.CARD_NUMBER).sendKeys(number);
			driver().findByCSS(this.EXPIRY_MONTH).sendKeys(expMonth);
			driver().findByCSS(this.EXPIRY_YEAR).sendKeys(expYear);
			driver().clickByCSS(this.SAVE);
			return PageFactory.getMyAccountPages(driver());
		}
		
		public DefaultMyAccountPages storeGiftCard(String nickname, String cardNumber) {
			driver().clickByCSS(this.ADD_GIFT_CARD);
			driver().findByCSS(this.NICKNAME).sendKeys(nickname);
			driver().findByCSS(this.CARD_NUMBER).sendKeys(cardNumber);;
			driver().clickByCSS(this.SAVE);
			return PageFactory.getMyAccountPages(driver());
		}
		
		public DefaultMyAccountPages editEmailPreferences(String emailPreferences, String rewardsAndAlerts,
				String updatesAndSpecialOffers, String localNews, String inPersonOnlineEvents, 
				String communicationsWithOtherMembers, String shareYourThoughts) {
			if (emailPreferences != null) {
				driver().clickByCSS(this.EMAIL_PREF_OPT_IN_OUT);
			}
			if (rewardsAndAlerts != null) {
				driver().clickByCSS(this.REWARDS_AND_ALERTS);
			}
			if (updatesAndSpecialOffers != null) {
				driver().clickByCSS(this.UPDATES_AND_SPECIAL_OFFERS);
			}
			if (localNews != null) {
				driver().clickByCSS(this.LOCAL_NEWS);
			}
			if (inPersonOnlineEvents != null) {
				driver().clickByCSS(this.IN_PERSON_ONLINE_EVENTS);
			}
			if (communicationsWithOtherMembers != null) {
				driver().clickByCSS(this.COMMUNICATION_WITH_OTHER_MEMBERS);
			}
			if (shareYourThoughts != null) {
				driver().clickByCSS(this.SHARE_YOUR_THOUGHTS);
			}
			driver().clickByCSS(this.UPDATE);
			return PageFactory.getMyAccountPages(driver());
		}		
}