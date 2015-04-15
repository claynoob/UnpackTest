package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.pages.HomePage;
import com.panerabread.auit.pages.SignInModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class QARCHome extends BasePage implements HomePage {
	public QARCHome(AdvancedWebDriver driver){
		super(driver);
		driver().get("https://delivery1-qarc.panerabread.com/#!/");
	}
	
	private final String SIGN_IN="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)", 
			REG_USER=".register", FIRST="#firstName", LAST="#lastName", PHONE="#phone", 
			EMAIL="#email", ADDRESS="#address1", CITY="#city", STATE="#state", ZIP="#zip", 
			NEXT1=".col-xs-offset-10 > button:nth-child(1)", NEW_USERNAME="#username", 
			USE_EMAIL="form.ng-invalid > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			NEW_PASSWORD="#password", CONFIRM_PASSWORD="#confirmPassword", 
			NO_LOYALTY="div.radio:nth-child(3) > label:nth-child(1) > span:nth-child(2)",
			YES_LOYALTY="div.radio:nth-child(4) > label:nth-child(1) > span:nth-child(2)", MONTH="#birthdateMonth",
			DAY="#birthdateDay", YEAR="#birthdateYear", 
			OVER_18="account-info.ng-isolate-scope > form:nth-child(1) > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			PREVIOUS2="form.ng-invalid > div:nth-child(9) > div:nth-child(1) > button:nth-child(1)",
			NEXT2="account-info.ng-isolate-scope > form:nth-child(1) > div:nth-child(9) > div:nth-child(2) > button:nth-child(1)",
			DAIRY_FREE="li.col-xs-12:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			GLUTEN_FREE="li.col-xs-12:nth-child(2) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			LOW_FAT="li.col-xs-12:nth-child(3) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			LOW_SODIUM="li.col-xs-12:nth-child(4) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			LOW_SUGAR="li.col-xs-12:nth-child(5) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			VEGETARIAN="li.col-xs-12:nth-child(6) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			EMAIL_OPT="form.ng-pristine > div:nth-child(5) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			TERMS_COND="account-preferences.ng-isolate-scope > form:nth-child(1) > div:nth-child(6) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			PREVIOUS3="form.ng-pristine > div:nth-child(6) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			NEXT3="account-preferences.ng-isolate-scope > form:nth-child(1) > div:nth-child(7) > div:nth-child(2) > button:nth-child(1)",
			MANAGE_ACCOUNT=".col-xs-offset-7 > button:nth-child(1)", START_ORDERING=".col-xs-2 > button:nth-child(1)",
			WELCOME_EXIT=".btn-modal-close";
	
	public SignInModal startRPUOrder(){
		driver().clickByCSS(".rapid-pickup");
		return PageFactory.getSignInModal(driver);
	}
	public SignInModal startDineInOrder(){
		driver().clickByCSS(".dine-in");
		return PageFactory.getSignInModal(driver);
	}
	public SignInModal startDeliveryOrder(){
		driver().clickByCSS(".delivery");
		return PageFactory.getSignInModal(driver);
	}
	
	public void registerNewUser(String firstName, String lastName, String phoneNum, String email, String address, 
			String city, String state, String zip, String username, String password, String passwordConfirm, 
			String month, String date, String year) {
		driver().clickByCSS(this.SIGN_IN);
		driver().clickByCSS(this.REG_USER);
		driver().findByCSS(this.FIRST).sendKeys(firstName);
		driver().findByCSS(this.LAST).sendKeys(lastName);
		driver().findByCSS(this.PHONE).sendKeys(phoneNum);
		driver().findByCSS(this.EMAIL).sendKeys(email);
		driver().findByCSS(this.ADDRESS).sendKeys(address);
		driver().findByCSS(this.CITY).sendKeys(city);
		driver().findByCSS(this.STATE).sendKeys(state);
		driver().findByCSS(this.ZIP).sendKeys(zip);
		driver().clickByCSS(this.NEXT1);
		driver().findByCSS(this.NEW_USERNAME).sendKeys(username);
		driver().findByCSS(this.NEW_PASSWORD).sendKeys(password);
		driver().findByCSS(this.CONFIRM_PASSWORD).sendKeys(passwordConfirm);
		driver().clickByCSS(this.NO_LOYALTY);
		driver().findByCSS(this.MONTH).sendKeys(month);
		driver().findByCSS(this.DAY).sendKeys(date);
		driver().findByCSS(this.YEAR).sendKeys(year);
		driver().clickByCSS(this.OVER_18);
		driver().clickByCSS(this.NEXT2);
		driver().clickByCSS(this.EMAIL_OPT);
		driver().clickByCSS(this.TERMS_COND);
		driver().clickByCSS(this.NEXT3);
		driver().clickByCSS(this.WELCOME_EXIT);
	}
}