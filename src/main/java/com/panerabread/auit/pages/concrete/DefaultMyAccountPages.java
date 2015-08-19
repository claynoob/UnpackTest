package com.panerabread.auit.pages.concrete;

import java.io.IOException;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.MyAccountPages;
import com.panerabread.auit.pages.StoredCreditCardConfig;
import com.panerabread.auit.pages.StoredGiftCardConfig;
import com.panerabread.auit.pages.UpdateAccountInfoConfig;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultMyAccountPages extends BasePageWithMenuFrame implements MyAccountPages {
	
	private final String ADD_NEW_ADDRESS="button.btn-primary", ADDRESS_TYPE="select.ng-valid-schema", 
		NEW_ADDRESS="#address1", NAME="#name", NEW_CITY="#city", NEW_STATE="select.ng-invalid", NEW_ZIP="#zip",
		PHONE="#primaryPhone", INSTRUCTIONS="#additionalInfo", SAVE_ADDRESS="input.btn",
		CANCEL_ADD_ADDRESS="button.btn:nth-child(2)", ADD_PHONE="button.btn-primary", PHONE_NAME="#name", ADD_NUMBER="#number", 
		SAVE_PHONE=".text-right > button:nth-child(1)", CANCEL_ADD_PHONE=".text-right > button:nth-child(1)",
		DELETE_PHONE="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('.lead')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement.parentElement.parentElement.getElementsByClassName('col-xs-offset-2')[0]})();",
		EDIT_PHONE="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('.lead')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement.parentElement.nextElementSibling.firstElementChild.firstElementChild})();",
		CHECK_PHONE_SAVED="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('.lead')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s')})();",
		SET_DEFAULT_PHONE="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('.lead')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement.parentElement.parentElement.getElementsByClassName('check')[0]})();",
		ADD_FAV_CAFE="button.btn-primary", SEARCH="#cafeSearch",
		CHOOSE_CAFE="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('.cafeName')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement.parentElement.nextSibling.nextSibling.getElementsByTagName('a')[0]})();",
		ADD_CREDIT_CARD=".col-sm-9 > div:nth-child(1) > my-cards:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h1:nth-child(1) > button:nth-child(1)",
		NICKNAME="#cardName", CARDHOLDER_NAME="#cardHolderName",
		CARD_NUMBER="#cardNum", EXPIRY_MONTH="[name='month']",
		EXPIRY_YEAR="[name='year']", SECURITY_CODE="#securityCode", BILLING_ZIP="#zipCode",
		SAVE="input.btn", CANCEL="button.col-xs-2",
		ADD_GIFT_CARD="div.row:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h1:nth-child(1) > button:nth-child(1)",
		DELETE_CARD="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement.getElementsByClassName('btn-default')[1]})();",
		EDIT_CARD="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement.getElementsByClassName('btn-default')[0]})();",
		RELOAD_GIFT_CARD="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement.getElementsByClassName('btn-primary')[0]})();",
		SET_DEFAULT_CARD="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement.getElementsByClassName('check')[0]})();",
		EMAIL_PREF_OPT_IN_OUT=".ng-pristine > bootstrap-decorator:nth-child(1) > div:nth-child(1) > sf-decorator:nth-child(1) > div:nth-child(1) > sf-decorator:nth-child(2) > div:nth-child(1)",
		REWARDS_AND_ALERTS=".ng-pristine > bootstrap-decorator:nth-child(2) > div:nth-child(1) > sf-decorator:nth-child(2) > div:nth-child(1) > sf-decorator:nth-child(4) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
		UPDATES_AND_SPECIAL_OFFERS=".ng-pristine > bootstrap-decorator:nth-child(1) > div:nth-child(1) > sf-decorator:nth-child(2) > div:nth-child(1) > sf-decorator:nth-child(5) > div:nth-child(1)",				    
		LOCAL_NEWS=".ng-pristine > bootstrap-decorator:nth-child(1) > div:nth-child(1) > sf-decorator:nth-child(2) > div:nth-child(1) > sf-decorator:nth-child(3) > div:nth-child(1)",
		IN_PERSON_ONLINE_EVENTS=".ng-valid > bootstrap-decorator:nth-child(2) > div:nth-child(1) > sf-decorator:nth-child(2) > div:nth-child(1) > sf-decorator:nth-child(7) > div:nth-child(1)",
		COMMUNICATION_WITH_OTHER_MEMBERS=".ng-valid > bootstrap-decorator:nth-child(2) > div:nth-child(1) > sf-decorator:nth-child(2) > div:nth-child(1) > sf-decorator:nth-child(6) > div:nth-child(1)",
		SHARE_YOUR_THOUGHTS=".ng-pristine > bootstrap-decorator:nth-child(1) > div:nth-child(1) > sf-decorator:nth-child(2) > div:nth-child(1) > sf-decorator:nth-child(2) > div:nth-child(1)",
		UPDATE="input.btn",
		FIRST_NAME="#info\\.firstName", LAST_NAME="#info\\.lastName", ADDRESS="#address\\.address1",
		CITY="#address\\.city", STATE="#address\\.state", ZIP="#address\\.zip", 
		PHONE_NUMBER="#info\\.phone", EMAIL="#info\\.email",
		UPDATE_ACCOUNT_INFO="div.form-group:nth-child(16) > div:nth-child(1) > button:nth-child(1)",
		DELETE_YES="div.row:nth-child(5) > div:nth-child(1) > button:nth-child(1)",
		DELETE_NO="div.row:nth-child(5) > div:nth-child(1) > button:nth-child(2)",
		CARD_FIND="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement})();",
		CARD_NAME="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('[ng-if=\"!showCcForm\"]')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('Chaels').getElementsByClassName('check')[%s].parentElement.parentElement.parentElement.parentElement.previousElementSibling.firstElementChild})();",
		CARD_COUNT="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('[ng-if=\"!showCcForm\"]')).forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('Chaels').getElementsByClassName('check')})();";
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((CHECK_PHONE_SAVED == null) ? 0 : CHECK_PHONE_SAVED
						.hashCode());
		result = prime * result
				+ ((EDIT_PHONE == null) ? 0 : EDIT_PHONE.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultMyAccountPages other = (DefaultMyAccountPages) obj;
		if (CHECK_PHONE_SAVED == null) {
			if (other.CHECK_PHONE_SAVED != null)
				return false;
		} else if (!CHECK_PHONE_SAVED.equals(other.CHECK_PHONE_SAVED))
			return false;
		if (EDIT_PHONE == null) {
			if (other.EDIT_PHONE != null)
				return false;
		} else if (!EDIT_PHONE.equals(other.EDIT_PHONE))
			return false;
		return true;
	}

	public DefaultMyAccountPages(AdvancedWebDriver driver) {
		super(driver);
	}
	
	public MyAccountPages updateAccountInfo() throws IOException{
		String today = driver().getDateTimeNumbers();
		UpdateAccountInfoConfig config = new UpdateAccountInfoConfig(today);
		updateAccountInformation(config);
		driver().clickByCSS(this.UPDATE_ACCOUNT_INFO);
		driver().pause(6000);
		return this;
	}
	
	public MyAccountPages updateEmail(String email) {
		driver().findByCSS(this.EMAIL).sendKeys(Keys.chord(Keys.CONTROL, "a"), email);
		driver().findByCSS(this.UPDATE_ACCOUNT_INFO);
		return this;
	}
	
	public MyAccountPages updateAccountInformation(UpdateAccountInfoConfig config) throws IOException {
		safeSendKeys(driver().findByCSS(this.FIRST_NAME), config.getFirstName());
		safeSendKeys(driver().findByCSS(this.LAST_NAME), config.getLastName());
		driver().findByCSS(this.ADDRESS).sendKeys(Keys.chord(Keys.CONTROL, "a"), config.getAddress());
		driver().findByCSS(this.CITY).sendKeys(Keys.chord(Keys.CONTROL, "a"), config.getCity());
		safeSendKeys(driver().findByCSS(this.STATE), config.getState());
		driver().findByCSS(this.ZIP).sendKeys(Keys.chord(Keys.CONTROL, "a"), config.getZip());
		driver().findByCSS(this.PHONE_NUMBER).sendKeys(Keys.chord(Keys.CONTROL, "a"), config.getPhone());
		driver().findByCSS(this.EMAIL).sendKeys(Keys.chord(Keys.CONTROL, "a"), config.getEmail());
		driver().captureScreenshot();
		return this; 
	}
	
	public MyAccountPages removeDateAcctInfo(){
		int i = 0;
		while (i < 15) {
			driver().findByCSS(this.FIRST_NAME).sendKeys(Keys.BACK_SPACE);
			driver().findByCSS(this.LAST_NAME).sendKeys(Keys.BACK_SPACE);
			i++;
		}
		driver().findByCSS(this.ADDRESS).sendKeys(Keys.chord(Keys.CONTROL, "a"), "203 Mallard Dr");
		driver().findByCSS(this.CITY).sendKeys(Keys.chord(Keys.CONTROL, "a"), "Glennville");
		driver().findByCSS(this.STATE).sendKeys("GA");
		driver().findByCSS(this.ZIP).sendKeys(Keys.chord(Keys.CONTROL, "a"), "30427");
		driver().findByCSS(this.EMAIL).sendKeys(Keys.chord(Keys.CONTROL, "a"), "chaley.stanfieldqa@gmail.com");
		driver().findByCSS(this.PHONE_NUMBER).sendKeys(Keys.chord(Keys.CONTROL, "a"), "9122372905");
		driver().clickByCSS("div.form-group:nth-child(16) > div:nth-child(1) > button:nth-child(1)");
		driver().pause(6000);
		return this;
	}
	
	public MyAccountPages addNewAddress(String type, String address, String name,
			String city, String state, String zip, String phone, String instructions) {
		driver().clickByCSS(this.ADD_NEW_ADDRESS);
		driver().findByCSS(this.ADDRESS_TYPE).sendKeys(type);
		driver().findByCSS(this.NEW_ADDRESS).sendKeys(address);
		driver().findByCSS(this.NAME).sendKeys(name);
		driver().findByCSS(this.NEW_CITY).sendKeys(city);
		driver().findByCSS(this.NEW_STATE).sendKeys(state);
		driver().findByCSS(this.NEW_ZIP).sendKeys(zip);
		driver().findByCSS(this.PHONE).sendKeys(phone);
		driver().findByCSS(this.INSTRUCTIONS).sendKeys(instructions);
		driver().clickByCSS(this.SAVE_ADDRESS);
		return this;
	}
	
	public MyAccountPages addNewPhone() {
		driver().clickByCSS(this.ADD_PHONE);
		String today = driver().getDateTimeNumbers();
		{System.setProperty("today", today);}
		UpdateAccountInfoConfig config = new UpdateAccountInfoConfig(today);
		String name = System.getProperty("phoneName");
		String number = System.getProperty("phoneNum");
		boolean isDisabled = (driver().findByCSS(this.ADD_PHONE).isEnabled() == false);
		Assert.assertTrue("Button is enabled", isDisabled);
		driver().findByCSS(this.PHONE_NAME).sendKeys(config.getNewPhoneName());
		driver().findByCSS(this.ADD_NUMBER).sendKeys(config.getNewPhoneNum());
		driver().clickByCSS(this.SAVE_PHONE);
		String phoneNumber = formatPhoneNum(number);
		Assert.assertTrue("Phone number did not save: " + name + " " + number, checkForPhone(name, phoneNumber));
		boolean isEnabled = driver().findByCSS(this.ADD_PHONE).isEnabled();
		Assert.assertTrue("Button is disabled", isEnabled);
		return this;
	}
	
	public Boolean checkForPhone(String name, String number) {
		boolean isSaved = false;
		try {
			WebElement phoneNumberCheck = driver().findByJavascript(String.format(this.CHECK_PHONE_SAVED, number));
			if (name != null) {
				WebElement phoneNameCheck = driver().findByJavascript(String.format(this.CHECK_PHONE_SAVED, name));
				if (phoneNameCheck.toString().contentEquals(phoneNumberCheck.toString())) {
					isSaved = true;
				}
			}
			if ((name == null) && (phoneNumberCheck != null)) {
				isSaved = true;
			}
		}
		catch (Exception e) {
		}
		return isSaved;
	}
	
	public String formatPhoneNum(String number) {
		String phoneNumber = number.substring(0,3) + "-" + number.substring(3, 6) + "-" + number.substring(6, 10);
		return phoneNumber;
	}
	
	public MyAccountPages deletePhone() {
		String today = System.getProperty("today");
		UpdateAccountInfoConfig config = new UpdateAccountInfoConfig(today);
		String name = config.getNewPhoneName();
		String number = config.getNewPhoneNum();
		String phoneNumber = formatPhoneNum(number);
		if (checkForPhone(name, phoneNumber) == true) {
			driver().clickByJavascript(String.format(this.DELETE_PHONE, phoneNumber));
		}
		Assert.assertTrue("Phone number not deleted: " + name + " " + phoneNumber, verifyPhoneDeleted(name, phoneNumber));
		return this;
	}
	
	public MyAccountPages setDefaultPhoneNum() {
		String today = System.getProperty("today");
		UpdateAccountInfoConfig config = new UpdateAccountInfoConfig(today);
		String name = config.getNewPhoneName();
		String number = config.getNewPhoneNum();
		String phoneNumber = formatPhoneNum(number);
		if (checkForPhone(name, phoneNumber) == true) {
			driver().clickByJavascript(String.format(this.SET_DEFAULT_PHONE, phoneNumber));
		} 
		Assert.assertTrue("Phone is not set as default phone: " + name + " " + phoneNumber, 
				verifyDefaultPhone(name, phoneNumber));
		return this;
	}
	
	public Boolean verifyDefaultPhone(String name, String number) {
		boolean isSelected = false;
		try {
			driver().findByJavascript(String.format(this.SET_DEFAULT_PHONE, name)).getAttribute("ng-dirty");
			driver().findByJavascript(String.format(this.SET_DEFAULT_PHONE, number)).getAttribute("ng-dirty");
			isSelected = true;
		}
		catch (Exception e) {
		}
		return isSelected;
	}
	
	public Boolean verifyPhoneDeleted(String name, String number) {
		boolean isDeleted = true;
		if (checkForPhone(name, number) == false) {
			isDeleted = false;
			}
		return isDeleted;
	}
	
	public MyAccountPages editPhone() throws IOException {
		String today = driver().getDateTimeNumbers();
		UpdateAccountInfoConfig config = new UpdateAccountInfoConfig(today);
		driver().captureScreenshot();
		driver().findByCSS(this.PHONE_NAME).sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.NULL, config.getStoredPhoneName()));
		driver().findByCSS(this.ADD_NUMBER).sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.NULL, config.getStoredPhoneNum()));
		driver().clickByCSS(this.SAVE_PHONE);
		driver().pause(3750);
		driver().captureScreenshot();
		return this;
	}
	
	public MyAccountPages editPhoneOpt() throws IOException {
		String phoneName = System.getProperty("phoneName");
		String phoneNum = System.getProperty("phoneNum");
		String phoneNumber = formatPhoneNum(phoneNum);
		if (checkForPhone(phoneName, phoneNumber) == true) {
			driver().clickByJavascript(String.format(this.EDIT_PHONE, phoneNumber));
			editPhone();
		}
		return this;
	}

	public MyAccountPages addNewCafe(String search, int cafeNumber) {
		driver().clickByCSS(this.ADD_FAV_CAFE);
		driver().findByCSS(this.SEARCH).sendKeys(search);
		driver().clickByJavascript(String.format(this.CHOOSE_CAFE, cafeNumber));
		return this;
	}
	
	public MyAccountPages addFavoriteCafe(String search, int cafeId) {
		searchForCafe(search);
		return addNewCafe(cafeId);
	}

	public DefaultMyAccountPages searchForCafe(String search) {
		driver().clickByCSS(this.ADD_FAV_CAFE);
		WebElement searchBox = driver().findByCSS(this.SEARCH);
		searchBox.sendKeys(search);
		driver().pause(5000);
		return this;
	}
	
	public MyAccountPages addNewCafe(int cafeId) {
		driver().clickByJavascript(String.format(this.CHOOSE_CAFE, cafeId));
		return this;
	}
	
	public MyAccountPages storeCreditCardOpt(CardTypes type) {
		String number = findCardNumber(type);
		String today = driver().getDateTimeNumbers();
		StoredCreditCardConfig config = new StoredCreditCardConfig(today, type, number);
		driver().clickByCSS(this.ADD_CREDIT_CARD);
		storeCreditCard(config);
		return this;
	}
	
	public MyAccountPages storeCreditCard(StoredCreditCardConfig config) {
		safeSendKeys(driver().findByCSS(this.NICKNAME), config.getNickname());
		safeSendKeys(driver().findByCSS(this.CARDHOLDER_NAME), config.getCardholderName());
		safeSendKeys(driver().findByCSS(this.CARD_NUMBER), config.getCardNumber());
		safeSendKeys(driver().findByCSS(this.EXPIRY_MONTH), config.getExpMonth());
		safeSendKeys(driver().findByCSS(this.EXPIRY_YEAR), config.getExpYear());
		try {
			driver().findByCSS(this.SECURITY_CODE).sendKeys(config.getSecurityCode());
			driver().findByCSS(this.BILLING_ZIP).sendKeys(config.getBillingZip());
		}
		catch (Exception e) {
		}
		driver().clickByCSS(this.SAVE);
		driver().pause(15000);
		boolean isSaved = checkForStoredCard(config.getNickname(), 
				config.getCardNumber().substring(config.getCardNumber().length() - 4), 
				config.getExpMonth() + "/" + config.getExpYear().substring(config.getExpYear().length() - 2));
		Assert.assertTrue("Credit Card was not saved: " + config.getNickname() + " " + config.getCardNumber(), isSaved == true);
		return this;
	}
	
	/*public Boolean checkForCVVFields() {
		boolean isPresent = false;
		if (driver.findByCSS(this.SECURITY_CODE) != null) {
			isPresent = true;
		}
		return isPresent;
	}*/
	
	public Boolean checkForStoredCard(String nickname, String ccInfo, String expDate) {
		boolean isSaved = false;
		WebElement nicknameCheck = null;
		WebElement expDateCheck = null;
		WebElement ccInfoCheck = driver().findByJavascript(String.format(this.CARD_FIND, ccInfo));
		if (nickname != null) {
		nicknameCheck = driver().findByJavascript(String.format(this.CARD_FIND, nickname));
		}
		if (expDate != null) {
		expDateCheck = driver().findByJavascript(String.format(this.CARD_FIND, expDate));
		}
		if ((nickname != null) && (expDate != null)) {
			if ((nicknameCheck.getText().contains((ccInfoCheck).getText()) && (ccInfoCheck.getText().contains(expDateCheck.getText())))) {
			isSaved = true;
			}
		}
		if ((nickname != null) && (expDate == null)) {
			if (nicknameCheck.getText().contains((ccInfoCheck.getText()))){
				isSaved = true;
			}
		}
		if ((nickname == null) && (expDate != null)) {
			if (expDateCheck.getText().contains(ccInfoCheck.getText())){
				isSaved = true;
			}
		}
		return isSaved;
	}
	
	public MyAccountPages deleteCard(String nickname, String ccInfo, String expDate, Boolean deleteConfirm) {
		if (checkForStoredCard(nickname, ccInfo, expDate) == true) {
				driver().clickByJavascript(String.format(this.DELETE_CARD, nickname));
				if (deleteConfirm == true) {
					driver().clickByCSS(this.DELETE_YES);
				}
				else {
					driver().clickByCSS(this.DELETE_NO);
				}
		}
		Assert.assertFalse("Card was not deleted: Nickname: " + nickname + " Card Info: " + ccInfo
				+ " Exp Date: " + expDate, checkForStoredCard(nickname, ccInfo, expDate));
		return this;
	}
	
	public MyAccountPages deleteTestCards() {
		Collection<Object[]> cards = driver().countByJavascript(this.CARD_COUNT);
		//int cardCount = cards.size();
		for (int i = 0; i < cards.size(); i++) {
			String name = driver().findByJavascript(String.format(this.CARD_NAME, i)).getText();
			if (name.contains("Chaels")) {
				driver().clickByJavascript(String.format(this.DELETE_CARD, name));
				driver().clickByCSS(this.DELETE_YES);
				driver().pause(1000);
			}
		}
		return this;
		
	}
	
	public MyAccountPages storeGiftCardOpt() {
		String today = driver().getDateTimeNumbers();
		driver().clickByCSS(this.ADD_GIFT_CARD);
		StoredGiftCardConfig config = new StoredGiftCardConfig(today);
		storeGiftCard(config);
		return this;
	}
	
	public MyAccountPages storeGiftCard(StoredGiftCardConfig config) {
		safeSendKeys(driver().findByCSS(this.NICKNAME), config.getNickname());
		safeSendKeys(driver().findByCSS(this.CARD_NUMBER), config.getCardNumber());
		driver().clickByCSS(this.SAVE);
		driver().pause(15000);
		boolean isSaved = checkForStoredCard(config.getNickname(), 
				config.getCardNumber().substring(config.getCardNumber().length() - 4), null);
		Assert.assertTrue("Gift Card was not saved", isSaved == true);
		return this;
	}
	
	public MyAccountPages editEmailPreferences(String emailPreferences, String rewardsAndAlerts,
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
		return this;
	}
	
	public MyAccountPages verifyNotificationUpdates() {
		
		return this;
	}

}