package com.panerabread.auit.pages.concrete;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.panerabread.auit.pages.MyAccountPages;
import com.panerabread.auit.pages.OrderTypeLocationPage;
import com.panerabread.auit.pages.RegisterNewUserConfig;
import com.panerabread.auit.pages.RegisterNewUserModal;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultRegisterNewUser extends BasePageWithMenuFrame implements RegisterNewUserModal {
	
	private final String FIRST="#firstName", LAST="#lastName", PHONE="#phone", 
			EMAIL="#email", ADDRESS="#address1", CITY="#city", STATE="#state", ZIP="#zip", 
			NEXT1=".col-xs-offset-10 > button:nth-child(1)", NEW_USERNAME="#username", 
			USE_EMAIL="form.ng-invalid > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			NEW_PASSWORD="#password", CONFIRM_PASSWORD="#confirmPassword", 
			NO_LOYALTY="div.radio:nth-child(3) > label:nth-child(1) > span:nth-child(2)",
			YES_LOYALTY="div.radio:nth-child(4) > label:nth-child(1) > span:nth-child(2)", 
			LOYALTY_NUM="#cardNumber", REGISTRATION_NUM="#registrationCode",
			MONTH="#birthdateMonth", DAY="#birthdateDay", YEAR="#birthdateYear", OVER_18="#over18",
			PREVIOUS2="form.ng-invalid > div:nth-child(9) > div:nth-child(1) > button:nth-child(1)",
			NEXT2=".registration > account-info:nth-child(5) > form:nth-child(1) > div:nth-child(9) > div:nth-child(2) > button:nth-child(1)",
			DAIRY_FREE="li.col-xs-12:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			GLUTEN_FREE="li.col-xs-12:nth-child(2) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			LOW_FAT="li.col-xs-12:nth-child(3) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			LOW_SODIUM="li.col-xs-12:nth-child(4) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			LOW_SUGAR="li.col-xs-12:nth-child(5) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			VEGETARIAN="li.col-xs-12:nth-child(6) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			EMAIL_OPT=".registration > account-preferences:nth-child(6) > form:nth-child(1) > div:nth-child(5) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			START_ORDERING=".col-xs-2 > button:nth-child(1)", TERMS_COND="#agreeToTerms",
			PREVIOUS3="form.ng-pristine > div:nth-child(6) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)",
			NEXT3=".registration > account-preferences:nth-child(6) > form:nth-child(1) > div:nth-child(7) > div:nth-child(2) > button:nth-child(1)",
			MANAGE_ACCOUNT=".col-xs-offset-7 > button:nth-child(1)",
			WELCOME_EXIT=".btn-modal-close", WELCOME_MY_PANERA="#registration-welcome", WELCOME_MSG=".welcome";
	
	public DefaultRegisterNewUser(AdvancedWebDriver driver) {
		super(driver);
	}
	
	public RegisterNewUserModal regNewUser(RegisterNewUserConfig config) {
		safeSendKeys(driver().findByCSS(this.FIRST), config.getFirstName());
		safeSendKeys(driver().findByCSS(this.LAST), config.getLastName());
		safeSendKeys(driver().findByCSS(this.PHONE), config.getPhone());
		safeSendKeys(driver().findByCSS(this.EMAIL), config.getEmail());
		safeSendKeys(driver().findByCSS(this.ADDRESS), config.getAddress());
		safeSendKeys(driver().findByCSS(this.CITY), config.getCity());
		safeSendKeys(driver().findByCSS(this.STATE), config.getState());
		safeSendKeys(driver().findByCSS(this.ZIP), config.getZip());
		driver().clickByCSS(this.NEXT1);
		safeSendKeys(driver().findByCSS(this.NEW_USERNAME), config.getUsername());
		safeSendKeys(driver().findByCSS(this.NEW_PASSWORD), config.getPassword());
		safeSendKeys(driver().findByCSS(this.CONFIRM_PASSWORD), config.getPasswordConfirm());
		if (config.getLoyaltyNum() != null) {
			driver().clickByCSS(this.YES_LOYALTY);
			safeSendKeys(driver().findByCSS(this.LOYALTY_NUM), config.getLoyaltyNum());
			safeSendKeys(driver().findByCSS(this.REGISTRATION_NUM), config.getRegistrationNum());
		}
		safeSendKeys(driver().findByCSS(this.MONTH), config.getMonth());
		safeSendKeys(driver().findByCSS(this.DAY), config.getDate());
		safeSendKeys(driver().findByCSS(this.YEAR), config.getYear());
		driver().clickByCSS(this.OVER_18);
		driver().clickByCSS(this.NEXT2);
		driver().clickByCSS(this.TERMS_COND);
		checkForEmailOptOut(config.getEmailOpt());
		driver().clickByCSS(this.NEXT3);
		driver().pause(2000);
		if (verifyRegistrationSuccess() == true) {
			System.out.println("Registration successful! " + "Username: " + config.getUsername() + " Email: " + config.getEmail());
		}
		else {
			System.out.println("Registration unsuccessful! " + "Attempted Username: " + config.getUsername() +
					"Attempted Email: " + config.getEmail());			
		}
		{System.setProperty("username", config.getUsername());}
		return PageFactory.getRegisterNewUserModal(driver);
	}
	
	public RegisterNewUserModal registerNewUser(String loyaltyNum, String regNum, String emailOpt) {
		String today = driver().getDateTimeNumbers();
		regNewUser(new RegisterNewUserConfig(today, loyaltyNum, regNum, emailOpt));
		return this;
	}
	
	public void checkForEmailOptOut(String opt){
		if (opt != null){
			driver().clickByCSS(this.EMAIL_OPT);
		}
	}
	
	public boolean verifyRegistrationSuccess() {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.WELCOME_MY_PANERA));
		if (isPresent == false) {
			driver().pause(1000);
			isPresent = driver().checkForElement(By.cssSelector(this.WELCOME_MY_PANERA));
		}
		Assert.assertTrue("Registration was not successful", isPresent == true);
		return isPresent;
	}

	public OrderTypeLocationPage startOrdering() {
		driver().clickByCSS(this.START_ORDERING);
		return PageFactory.getOrderTypeLocationPage(driver);
	}
	
	public MyAccountPages manageMyAccount() {
		driver().clickByCSS(this.MANAGE_ACCOUNT);
		return PageFactory.getMyAccountPages(driver);
	}
}
