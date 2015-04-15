package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.MenuCategory;
import com.panerabread.auit.pages.CheckoutPage;
import com.panerabread.auit.pages.HomePage;
import com.panerabread.auit.pages.OrderConfirmationPage;
import com.panerabread.auit.pages.OrderTimePage;
import com.panerabread.auit.pages.OrderTypeLocationPage;
import com.panerabread.auit.pages.PageWithMenuFrame;
import com.panerabread.auit.pages.SignInModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class PageFactory {
	public static HomePage getQARCHome(AdvancedWebDriver driver){
		return new QARCHome(driver);
	}
		
	public static OrderTypeLocationPage getOrderTypeLocationPage(AdvancedWebDriver webDriver) {
		return new DefaultOrderTypeLocationPage(webDriver);
	}

	public static OrderTimePage getOrderTimePage(AdvancedWebDriver driver) {
		return new DefaultOrderTimePage(driver);
	}
		
	public static MenuCategory getMenuCategoryPage(AdvancedWebDriver driver) {
		return new DefaultMenuCategory(driver);
	}

	public static CheckoutPage getCheckoutPage(AdvancedWebDriver driver) {
		return new DefaultCheckoutPage(driver);
	}

	public static OrderConfirmationPage getOrderConfirmationPage(AdvancedWebDriver driver) {
		return new DefaultOrderConfirmationPage(driver);
	}

	public static SignInModal getSignInModal(AdvancedWebDriver driver) {
		return new DefaultSignInModal(driver);

	}
	
	public static DefaultMyAccountPages getMyAccountPages(AdvancedWebDriver driver) {
		return new DefaultMyAccountPages(driver);
	}
	
	public static PageWithMenuFrame getLandingPage(AdvancedWebDriver driver) {
		if(Boolean.parseBoolean(driver.getState().get("signedIn"))){
			return new DefaultPastOrdersPage(driver);
		} else {
			return new DefaultMainMenuPage(driver);
		}
	}

}
