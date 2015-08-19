package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.HomePage;
import com.panerabread.auit.pages.MyAccountPages;
import com.panerabread.auit.pages.OrderTypeLocationPage;
import com.panerabread.auit.pages.PageWithMenuFrame;
import com.panerabread.auit.pages.RegisterNewUserModal;
import com.panerabread.auit.pages.SignInModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultHomePage extends BasePageWithMenuFrame implements HomePage {
	public DefaultHomePage(AdvancedWebDriver driver){
		super(driver);
		String environment = System.getProperty("environment");
		//driver.manage().window().maximize();
		getEnvironmentURL(environment);
	}
	
	public void getEnvironmentURL(String environment){
		if (environment.equalsIgnoreCase("qarc")) {
			driver().get("https://delivery1-qarc.panerabread.com/#!/");
			{System.setProperty("url", "delivery1-qarc.panerabread.com");}
			}
		if (environment.equalsIgnoreCase("qahf")) {
			driver().get("http://devecomapp01.dev.paneracloud.com:10006/#!/");
			{System.setProperty("url", "devecomapp01.dev.paneracloud.com:10006");}
		}
		if (environment.equalsIgnoreCase("preprod")) {
			driver().get("https://delivery1-preprod.panerabread.com/#!/");
			{System.setProperty("url", "delivery1-preprod.panerabread.com");}
			}
		if (environment.equalsIgnoreCase("prod")) {
			driver().get("https://delivery1.panerabread.com/#!/");
			{System.setProperty("url", "delivery1.panerabread.com");}
			}
		if (environment.equalsIgnoreCase("devhf")) {
			driver().get("http://devecomapp01.dev.paneracloud.com:8006/#!/");
			{System.setProperty("url", "devecomapp01.dev.paneracloud.com:8006");}
			}
		if (environment.equalsIgnoreCase("devrc")) {
			driver().get("http://devecomapp01.dev.paneracloud.com:9006/#!/");
			{System.setProperty("url", "devecomapp01.dev.paneracloud.com:9006");}
			}
		if (environment.equalsIgnoreCase("qarc3")) {
			driver().get("https://delivery1-qarc3.panerabread.com/#!/");
			{System.setProperty("url", "delivery1-qarc3.panerabread.com");}
		}
	}
	
	private final String SIGN_IN="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)", 
			REG_USER=".register";
		
	public SignInModal startRPUOrder() {
		driver().clickByCSS("div.col-sm-4:nth-child(1)");
		{System.setProperty("orderType", "RPU");}
		return PageFactory.getSignInModal(driver);
	}
	
	public SignInModal startDineInOrder(){
		driver().clickByCSS("div.col-sm-4:nth-child(3)");
		{System.setProperty("orderType", "Dine In");}
		return PageFactory.getSignInModal(driver);
	}
	public SignInModal startDeliveryOrder(){
		driver().clickByCSS("div.col-sm-4:nth-child(2)");
		{System.setProperty("orderType", "Delivery");}
		return PageFactory.getSignInModal(driver);
	}
	
	public RegisterNewUserModal registerNewUserOpt() {
		driver().clickByCSS(this.SIGN_IN);
		driver().clickByCSS(this.REG_USER);
		return PageFactory.getRegisterNewUserModal(driver);
	}

}