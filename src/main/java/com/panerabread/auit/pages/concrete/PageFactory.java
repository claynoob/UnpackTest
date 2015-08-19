package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.CafeLocationsPage;
import com.panerabread.auit.pages.CustomizationModal;
import com.panerabread.auit.pages.MenuCategory;
import com.panerabread.auit.pages.CheckoutPage;
import com.panerabread.auit.pages.HomePage;
import com.panerabread.auit.pages.MyAccountPages;
import com.panerabread.auit.pages.OrderConfirmationPage;
import com.panerabread.auit.pages.OrderTimePage;
import com.panerabread.auit.pages.OrderTypeLocationPage;
import com.panerabread.auit.pages.PageWithMenuFrame;
import com.panerabread.auit.pages.RegisterNewUserModal;
import com.panerabread.auit.pages.SignInModal;
import com.panerabread.auit.pages.WebU;
import com.panerabread.auit.pages.WebUAccount;
import com.panerabread.auit.pages.WebUDashboard;
import com.panerabread.auit.pages.WebUSignInModal;
import com.panerabread.auit.pages.WebUWelcomeModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class PageFactory {
	public static HomePage getDefaultHomePage(AdvancedWebDriver driver){
		return new DefaultHomePage(driver);
	}
	
	public static CafeLocationsPage getCafeLocationsPage(AdvancedWebDriver driver){
		return new DefaultCafeLocationsPage(driver);
	}
	
	public static RegisterNewUserModal getRegisterNewUserModal(AdvancedWebDriver driver){
		return new DefaultRegisterNewUser(driver);
	}
	
	public static WebU getQARCWebU(AdvancedWebDriver driver) {
		return new QARCWebU(driver);
	}
	
	public static WebUDashboard getWebUDashboard(AdvancedWebDriver driver) {
		return new DefaultWebUDashboard(driver);
	}
	
	public static WebUAccount getWebUAccount(AdvancedWebDriver driver) {
		return new DefaultWebUAccount(driver);
	}

	public static WebUWelcomeModal getWebUWelcomeModal(AdvancedWebDriver driver) {
		return new DefaultWebUWelcomeModal(driver);
	}
		
	public static OrderTypeLocationPage getOrderTypeLocationPage(AdvancedWebDriver webDriver) {
		return new DefaultOrderTypeLocationPage(webDriver);
	}

	public static OrderTimePage getOrderTimePage(AdvancedWebDriver driver) {
		return new DefaultOrderTimePage(driver);
	}
	
	public static CustomizationModal getCustomizationModal(AdvancedWebDriver driver) {
		return new DefaultCustomizationModal(driver);
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
	
	public static WebUSignInModal getWebUSignInModal(AdvancedWebDriver driver) {
		return new DefaultWebUSignInModal(driver);
	}
	
	public static MyAccountPages getMyAccountPages(AdvancedWebDriver driver) {
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
