package com.panerabread.auit.pages;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.panerabread.auit.pages.concrete.BasePageWithMenuFrame;

public interface PageWithMenuFrame {
	CheckoutPage goToCheckout();
	MenuCategory clickCategoryPlacard(String category);
	MenuCategory clickSidebarCategory(String category);
	BasePageWithMenuFrame signOut();
	HomePage goToHomePage();
	MenuCategory goToBrowseOurMenu();
	BasePageWithMenuFrame verifyPageTitle(String title);
	OrderTypeLocationPage verifyLogin() throws Exception;
	SignInModal verifyInvalidLogin();
	BasePageWithMenuFrame verifyPageURL(String url);
	MyAccountPages updateAccountInfoOpt() throws IOException;
	MyAccountPages updatePassword(String currentPassword, String newPassword, String confirmPassword);
	MyAccountPages goToMyAddresses();
	MyAccountPages goToMyPhoneNumbers();
	MyAccountPages goToMyCafes();
	MyAccountPages goToMyCards();
	MyAccountPages updateEmailPreferences();
	BasePageWithMenuFrame checkForFavoriteItem(String favName);
	BasePageWithMenuFrame checkForPastOrder(String username, String pswrd, String[] items);
	String getTotal();
	BasePageWithMenuFrame checkOrderDescText(String orderType, String text);
	BasePageWithMenuFrame checkForExpressOrder();
	CafeLocationsPage goToCafeLocations();
	BasePageWithMenuFrame clickCateringFooterLink();
	BasePageWithMenuFrame clickCateringButton();
	BasePageWithMenuFrame clickCateringHeaderLink();
	SignInModal logIn();
	OrderTypeLocationPage orderAsGuest();
	OrderTypeLocationPage signInWithPhone(String phone, String password, String accountFirstName);
	OrderTypeLocationPage signIn(String user, String password);
	BasePageWithMenuFrame verifyLogOut();
	Set<String> getWindowHandles();
	BasePageWithMenuFrame captureScreenshot() throws IOException;
	void safeSendKeys(WebElement element, String value);
	String findCardNumber(CardTypes type);
	OrderTypeLocationPage changeCafeAddress();
	OrderTimePage changeFulfillmentTime();
	BasePageWithMenuFrame getSelectedCafe();
	BasePageWithMenuFrame verifyNoCafeResults();
	BasePageWithMenuFrame verifyMenuCategoriesNotPresent(String[] category);
	BasePageWithMenuFrame checkSoups() throws IOException;
}
