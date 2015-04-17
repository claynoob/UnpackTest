package com.panerabread.auit.pages.concrete;

import org.openqa.selenium.WebElement;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.pages.OrderTimePage;
import com.panerabread.auit.pages.OrderTypeLocationPage;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultOrderTypeLocationPage extends BasePage implements
		OrderTypeLocationPage {
	
	private final String SEARCH_BOX = "#cafeSearch", DEL_ADDRESS_FIELD = ".form-control", CHECK_AVAILABILITY = "input.btn",
			CAFE_SCRIPT_FORMAT = "return (function b(){ return (function a(cafeId){var foundCafe = null; Array.prototype.slice.call(document.querySelectorAll(\'.cafeName\')).forEach(function(cafe) {if(cafe.innerHTML.indexOf(cafeId) > 0) {foundCafe = cafe;}}); return foundCafe;}) ('%s').parentElement.nextSibling.nextSibling.getElementsByTagName('a')[0]})();",
			MY_ACCOUNT="li.dropdown:nth-child(4) > a:nth-child(1)",
			MY_ACCOUNT_INFO="li.dropdown:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)",
			OLD_PASSWORD="#info\\.currentPassword", NEW_PASSWORD="#info\\.newPassword",
			CONFIRM_PASSWORD="#info\\.confirmPassword", UPDATE_PASSWORD="#changePassword > div:nth-child(8) > div:nth-child(1) > button:nth-child(1)",
			FIRST_NAME="#info\\.firstName", LAST_NAME="#info\\.lastName", ADDRESS="#address\\.address1",
			CITY="#address\\.city", STATE="#address\\.state", ZIP="#address\\.zip", 
			PHONE_NUMBER="#info\\.phone", EMAIL="#info\\.email",
			UPDATE_ACCOUNT_INFO="div.form-group:nth-child(16) > div:nth-child(1) > button:nth-child(1)",
			MY_ADDRESSES="li.dropdown:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)",
			MY_PHONE_NUMBERS="li.dropdown:nth-child(4) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)",
			MY_CAFES="li.ng-scope:nth-child(7) > a:nth-child(1)", 
			MY_CARDS="li.dropdown:nth-child(4) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)",
			MY_NOTIFICATIONS="li.ng-scope:nth-child(8) > a:nth-child(1)";
	
	public DefaultOrderTypeLocationPage(AdvancedWebDriver driver) {
		super(driver);
	}

	public OrderTimePage chooseCafe(String search, int cafeId) {
		searchForCafe(search);
		return chooseCafe(cafeId);
	}

	public OrderTypeLocationPage searchForCafe(String search) {
		WebElement searchBox = driver().findByCSS(this.SEARCH_BOX);
		searchBox.sendKeys(search);
		driver().pause(5000);
		return this;
	}

	public OrderTimePage chooseCafe(int cafeId) {
		driver().clickByJavascript(String.format(this.CAFE_SCRIPT_FORMAT, cafeId));
		return PageFactory.getOrderTimePage(driver());
	}
	
	public OrderTimePage enterDeliveryAddress(String address){
		driver().pause(1000);
		driver().findByCSS(this.DEL_ADDRESS_FIELD).sendKeys(address);
		driver().clickByCSS(this.CHECK_AVAILABILITY);
		return PageFactory.getOrderTimePage(driver());
	}
	
	public void updateAccountInfo(String first, String last, String address, String city, String state, String zip, 
			String phone, String email) {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_ACCOUNT_INFO);
		driver().findByCSS(this.FIRST_NAME).clear();
		driver().findByCSS(this.FIRST_NAME).sendKeys(first);
		driver().findByCSS(this.LAST_NAME).clear();
		driver().findByCSS(this.LAST_NAME).sendKeys(last);
		driver().findByCSS(this.ADDRESS).clear();
		driver().findByCSS(this.ADDRESS).sendKeys(address);
		driver().findByCSS(this.CITY).clear();
		driver().findByCSS(this.CITY).sendKeys(city);
		driver().findByCSS(this.STATE).sendKeys(state);
		driver().findByCSS(this.ZIP).clear();
		driver().findByCSS(this.ZIP).sendKeys(zip);
		driver().findByCSS(this.PHONE_NUMBER).clear();
		driver().findByCSS(this.PHONE_NUMBER).sendKeys(phone);
		driver().findByCSS(this.EMAIL).clear();
		driver().findByCSS(this.EMAIL).sendKeys(email);
		driver().clickByCSS(this.UPDATE_ACCOUNT_INFO);
	}
	
	public void updatePassword(String currentPassword, String newPassword, String confirmPassword) {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_ACCOUNT_INFO);
		driver().findByCSS(this.OLD_PASSWORD).sendKeys(currentPassword);
		driver().findByCSS(this.NEW_PASSWORD).sendKeys(newPassword);
		driver().findByCSS(this.CONFIRM_PASSWORD).sendKeys(confirmPassword);
		driver().clickByCSS(this.UPDATE_PASSWORD);
	}
	
	public DefaultMyAccountPages addAddress() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_ADDRESSES);
		return PageFactory.getMyAccountPages(driver());
	}
	
	public DefaultMyAccountPages addPhone() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_PHONE_NUMBERS);
		return PageFactory.getMyAccountPages(driver());
	}
	
	public DefaultMyAccountPages addFavoriteCafe() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_CAFES);
		return PageFactory.getMyAccountPages(driver());
	}
	
	public DefaultMyAccountPages addCard() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_CARDS);
		return PageFactory.getMyAccountPages(driver());
	}
	
	public DefaultMyAccountPages updateEmailPreferences() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_NOTIFICATIONS);
		return PageFactory.getMyAccountPages(driver());
	}
	
}