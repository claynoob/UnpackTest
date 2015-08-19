package com.panerabread.auit.pages.concrete;

import java.awt.Robot;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.pages.CafeLocationsPage;
import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.HomePage;
import com.panerabread.auit.pages.MenuCategory;
import com.panerabread.auit.pages.CheckoutPage;
import com.panerabread.auit.pages.MyAccountPages;
import com.panerabread.auit.pages.OrderTimePage;
import com.panerabread.auit.pages.OrderTypeLocationPage;
import com.panerabread.auit.pages.PageWithMenuFrame;
import com.panerabread.auit.pages.SignInModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.CSVReader;
import com.panerabread.auit.webdriverutils.ExcelUtils;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public abstract class BasePageWithMenuFrame extends BasePage implements PageWithMenuFrame {

	private final String MENU_SELECTION_FORMAT = "return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('.col-xs-12')).forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('placard')[0]})();", 
			ITEM_PLACARD="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.col-sm-8')).reverse().forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.parentElement})();",
			CHECKOUT_BUTTON = ".order-summary-body > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)",
			SIDEBAR_SELECT_CATEGORY="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('category')).reverse().forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').firstElementChild.firstElementChild})();",
			SIDEBAR_SELECT_BEVERAGES="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('category')).reverse().forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').nextElementSibling.firstElementChild.firstElementChild})();",
			LOGIN_SIDEBAR_OPT="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('li')).forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s')})();",
			SIGN_OUT="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)",
			PB_LOGO="#company-logo",
			INVALID_LOGIN_ERROR="form.ng-dirty > bootstrap-decorator:nth-child(1) > div:nth-child(1)",
			WELCOME=".welcome > div:nth-child(1)",
			CAFE_RESULTS="div.hidden-xs:nth-child(3) > cafe-list:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(2)",
			BROWSE_OUR_MENU="#browse-options > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)",
			OUR_MENU="li.dropdown:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)",
			MY_ACCOUNT="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)",
			MY_ACCOUNT_INFO=".open > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)",
			OLD_PASSWORD="#info\\.currentPassword", NEW_PASSWORD="#info\\.newPassword",
			CONFIRM_PASSWORD="#info\\.confirmPassword", UPDATE_PASSWORD="#changePassword > div:nth-child(8) > div:nth-child(1) > button:nth-child(1)",
			EMAIL="#info\\.email",
			MY_ADDRESSES="li.dropdown:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)",
			MY_PHONE_NUMBERS="li.dropdown:nth-child(4) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)",
			MY_CAFES=".open > ul:nth-child(2) > li:nth-child(7) > a:nth-child(1)", 
			MY_CARDS="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)",
			MY_NOTIFICATIONS="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > ul:nth-child(2) > li:nth-child(8) > a:nth-child(1)",
			ORDERING_HELP="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)",
			LOGIN_ERROR=".alert", TOTAL = "div.form-group:nth-child(4) > label:nth-child(2)",
			SUBTOTAL = ".form-horizontal > div:nth-child(1) > label:nth-child(2)",
			TAX = "div.form-group:nth-child(2) > label:nth-child(2)",
			PAST_ORDER_CHECK="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('accordion:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1)')).reverse().forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').parentElement.parentElement})();",
			PAST_ORDER_ITEM_CHECK="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('.col-lg-4', '.col-xs-9 > my-past-orders:nth-child(1) > div:nth-child(2) > div:nth-child(1) > my-order:nth-child(1)')).reverse().forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.parentElement})();",
			FAV_ORDER_CHECK="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('span')).forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s')})();",
			ORDER_TYPE_DESC="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('div.col-md-4:nth-child(%o)')).forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s')})();",
			CAFE_LOCATIONS="#browse-options > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)",
			HEADER_ORDER_CATERING="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)",
			ORDER_CATERING_BTN="#catering-info > div:nth-child(3) > a:nth-child(1)", SIGN_IN="#top-navbar > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)", 
			FOOTER_ORDER_CATERING="div.colBody:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)",
			SIGN_IN_MODAL="#login-modal", ORDER_WITHOUT_SIGNIN = "button.btn-primary", USERNAME="#user",
			PASSWORD="#password", SIGNIN="input.btn", PHONE_MODAL=".modal-sm > div:nth-child(1)",
			SELECT_USER_PHONE_MODAL="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('label')).forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').parentElement.getElementsByClassName('check')[0]})();",
			CHANGE_CAFE_ADDRESS="div.order-type-pad-bottom:nth-child(6) > div:nth-child(1) > button:nth-child(1)",
			CHANGE_FULFILLMENT_DETAILS="div.order-type-pad-bottom:nth-child(4) > div:nth-child(1) > button:nth-child(1)",
			STREET_NAME="#main-nav > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)",
			CAFE_CITY="#main-nav > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2) > span:nth-child(1)",
			MISSING_IMG_CHK="return document.querySelectorAll('[src=\"http://webuweb01-preprod.panerabread.com/delivery/menu/grid/unknown.jpg\"]');",
			MISSING_IMG_ITEM_NAME="return document.querySelectorAll('[src=\"http://webuweb01-preprod.panerabread.com/delivery/menu/grid/unknown.jpg\"]')[%s].parentElement.parentElement.parentElement.parentElement.getElementsByClassName('title')[0];";

	public static Collection<Object[]> soupData(ArrayList<String> dates) throws IOException {
		  return CSVReader.getSoupDayData(dates);
	}
	
	public BasePageWithMenuFrame(AdvancedWebDriver driver) {
		super(driver);
	}
	
	public BasePageWithMenuFrame verifyNoCafeResults() {
		boolean isPresent = false;
		try {
			driver().findByCSS(this.CAFE_RESULTS);
			isPresent = true;
		}
		catch (Exception e) {
			Assert.assertTrue("Cafe Locations returning results before searching for cafe or sharing location", isPresent);
		}
		return this;
	}
	
	public OrderTypeLocationPage changeCafeAddress() {
		driver().clickByCSS(this.CHANGE_CAFE_ADDRESS);
		return PageFactory.getOrderTypeLocationPage(driver());
	}
	
	public OrderTimePage changeFulfillmentTime() {
		driver().clickByCSS(this.CHANGE_FULFILLMENT_DETAILS);
		return PageFactory.getOrderTimePage(driver());
	}
	
	public CheckoutPage goToCheckout(){
		driver().pause(1000);
		//scrollToTop();
		driver().clickByCSS(this.CHECKOUT_BUTTON);
		return  PageFactory.getCheckoutPage(driver());
	}

	public MenuCategory clickCategoryPlacard(String category){
		driver().clickByJavascript(String.format(this.MENU_SELECTION_FORMAT, category.trim()));
		{System.setProperty("category", category);}
		{System.setProperty("menuCat", category);}
		checkForMissingImages();
		return PageFactory.getMenuCategoryPage(driver());
	}	
	
	public BasePageWithMenuFrame checkForMissingImages() {
		Collection<Object[]> images = driver().countByJavascript(this.MISSING_IMG_CHK);
		ArrayList<String> items = new ArrayList<String>();		
		int num = images.size();
		for (int i = 0; i < num; i++) {
			String name = driver().findByJavascript(String.format(this.MISSING_IMG_ITEM_NAME, i)).getText();
			items.add(name.trim());
		}
		for (int x = 0; x < items.size(); x++) {
			if (items.get(x).equals("") == false) {
				System.out.println("Missing image for item: " + items.get(x));
			}
		}
		return this;
	}
	
	public BasePageWithMenuFrame verifyMenuBefore10() {
		verifyMenuCategoriesNotPresent(new String[] {"Broth Bowls", "Broth Bowl Meals"});
		
		return this;
	}
	
	public MenuCategory clickSidebarCategory(String category) {
		if (category.startsWith("My ")) {
			driver().clickByJavascript(String.format(this.LOGIN_SIDEBAR_OPT, category));
		}
		else {
			if (category.equalsIgnoreCase("Beverages")) {
				driver().clickByJavascript(String.format(this.SIDEBAR_SELECT_BEVERAGES, category));
			}
			else {
				driver().clickByJavascript(String.format(this.SIDEBAR_SELECT_CATEGORY, category));
			}
		}
		return PageFactory.getMenuCategoryPage(driver());
	}
	
	public Boolean checkForCategory(String format, String category) {
		boolean notPresent = true;
		try {
			driver().findByJavascript(String.format(format, category));
			notPresent = false;
		}
		catch (Exception e) {
		}
		return notPresent;
	}
	
	public Boolean checkForItem(String item) {
		boolean notPresent = true;
		try {
			driver().findByJavascript(String.format(this.ITEM_PLACARD, item));
			notPresent = false;
		}
		catch (Exception e) {
		}
		return notPresent;
	}
	
	public BasePageWithMenuFrame verifyMenuCategoriesNotPresent(String[] categories) {
		boolean notPresent = true;
		for (int i = 0; i < categories.length; i++) {
			if (categories[i].startsWith("My ")) {
				checkForCategory(this.LOGIN_SIDEBAR_OPT, categories[i]);
			}
			else {
				if (categories[i].equalsIgnoreCase("Beverages")) {
					checkForCategory(this.SIDEBAR_SELECT_BEVERAGES, categories[i]);
				}
				else {
					checkForCategory(this.SIDEBAR_SELECT_CATEGORY, categories[i]);
				}
			}
			Assert.assertTrue("Category displays which should not display: " + categories[i], notPresent);
		}
		return this;
	}
	
	public BasePageWithMenuFrame verifyItemsNotPresent(String[] items) {
		boolean notPresent = true;
		for (int i = 0; i < items.length; i++) {
			checkForItem(items[i]);
			Assert.assertTrue("Item displays which should not display: " + items[i], notPresent);
		}
		return this;
	}
	
	public Collection<Object[]> getSoups(String day) throws IOException {
		ArrayList<String> scheduleDates = new ArrayList<String>();
		//String[] scheduleDates = new String[] {};
		if(day.equalsIgnoreCase("Sunday")) {
			scheduleDates.add("STTS");
		}
		if(day.equalsIgnoreCase("Monday")) {
			scheduleDates.add("MW");
			scheduleDates.add("MWF)");
		}
		if(day.equalsIgnoreCase("Tuesday")) {
			scheduleDates.add("STTS");
		}
		if(day.equalsIgnoreCase("Wednesday")) {
			scheduleDates.add("MW");
			scheduleDates.add("MWF");
		}
		if(day.equalsIgnoreCase("Thursday")) {
			scheduleDates.add("STTS");
		}
		if(day.equalsIgnoreCase("Friday")) {
			scheduleDates.add("F");
		}
		if(day.equalsIgnoreCase("Saturday")) {
			scheduleDates.add("STTS");
		}
		System.out.println("Soup Day: " + scheduleDates);
		return CSVReader.getSoupDayData(scheduleDates);
	}

	public BasePageWithMenuFrame checkSoups() throws IOException {
		clickCategoryPlacard("Soups and Mac &amp; Cheese");
		Collection<Object[]> items = getSoups(System.getProperty("orderDay"));
		ArrayList<String> dates = new ArrayList<String>();
		for (Object[] item : items) {
			System.out.println(item.toString());
			dates.add(item.toString());
		}
		Collection<Object[]> soupName = soupData(dates);
		ArrayList<String> soups = new ArrayList<String>();
		String test = soupName.toString();
		for (int x = 0; x < soupName.size(); x++) {
			soups.add(test);
		}
		System.out.println("Soups length: " + soups.size());
			for (int i = 0; i < soups.size(); i++) {
				boolean isPresent = false;
				try {
					driver().findByJavascript(String.format(this.ITEM_PLACARD, soups));
					isPresent = true;
				}
				catch (Exception e) {
				}
				Assert.assertTrue("Soup does not display: " + soups, isPresent);
		}
		return this;
	}
	
	public BasePageWithMenuFrame getSelectedCafe() {
		String streetName = driver().findByCSS(this.STREET_NAME).getText();
		System.out.println("Selected Cafe is: " + streetName);
		return this;
	}
	
	public HomePage goToHomePage() {
		driver().clickByCSS(this.PB_LOGO);
		return PageFactory.getDefaultHomePage(driver);
	}
	
	public BasePageWithMenuFrame switchWindows() {
		String parentWindowHandlerP = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
	    for (String windowHandle : handles) {
	        if (!windowHandle.equals(parentWindowHandlerP)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }
	    }
	    return this;
	}
	
	public BasePageWithMenuFrame clickCateringHeaderLink() {
		driver().clickByCSS(this.HEADER_ORDER_CATERING);
		switchWindows();
		return this;
	}
	
	public BasePageWithMenuFrame clickCateringButton() {
		driver().clickByCSS(this.ORDER_CATERING_BTN);
		switchWindows();
		return this;
	}
	
	public BasePageWithMenuFrame clickCateringFooterLink() {
		driver().clickByCSS(this.FOOTER_ORDER_CATERING);
		switchWindows();
		return this;
	}
	
	public SignInModal logIn() {
		driver().clickByCSS(this.SIGN_IN);
		return PageFactory.getSignInModal(driver);
	}
	
	public OrderTypeLocationPage CSVSignIn(String location) throws IOException {
		Collection<Object[]> userInfo = CSVReader.getData(location);
		System.out.println(userInfo);
		return PageFactory.getOrderTypeLocationPage(driver());
	}

	public BasePageWithMenuFrame verifyLogOut() {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.SIGN_IN));
		Assert.assertTrue(isPresent == true);
		return this;
	}
	
	public OrderTypeLocationPage orderAsGuest() {
		driver().clickByCSS(this.ORDER_WITHOUT_SIGNIN);
		return PageFactory.getOrderTypeLocationPage(driver());
	}

	public OrderTypeLocationPage signInWithPhone(String phone, String password, String accountFirstName) {
		if (checkForSignInModal() == true) {
		driver().findByCSS(this.USERNAME).sendKeys(phone);
		driver().findByCSS(this.PASSWORD).sendKeys(password);
		driver().clickByCSS(this.SIGNIN);
		driver().pause(1000);
		if(driver().checkForElement(By.cssSelector(this.PHONE_MODAL))){
			driver().clickByJavascript(String.format(this.SELECT_USER_PHONE_MODAL,  accountFirstName));
			driver().clickByCSS(".col-xs-offset-10 > button:nth-child(1)");
		}
		driver().getState().put("signedIn", Boolean.toString(true));
		}
		driver().pause(1000);
		return PageFactory.getOrderTypeLocationPage(driver());
	}
	
	public OrderTypeLocationPage signIn(String user, String password) {
		if (checkForSignInModal() == true) {
		driver().findByCSS(this.USERNAME).sendKeys(user);
		driver().findByCSS(this.PASSWORD).sendKeys(password);
		driver().clickByCSS(this.SIGNIN);
		driver().getState().put("signedIn", Boolean.toString(true));
		}
		driver().pause(1000);
		return PageFactory.getOrderTypeLocationPage(driver());
	}	
	
	public Boolean checkForSignInModal() {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.SIGN_IN_MODAL));
		return isPresent;
	}

	public BasePageWithMenuFrame signOut() {
		driver().clickByCSS(this.SIGN_OUT);
		return this;
	}

	public OrderTypeLocationPage verifyLogin() {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.WELCOME));
		Assert.assertTrue("Login unsuccessful", isPresent == true);
		return PageFactory.getOrderTypeLocationPage(driver());
	}

	public SignInModal verifyInvalidLogin() {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.INVALID_LOGIN_ERROR));
		Assert.assertTrue("Invalid login credentials rejected", isPresent == true);
		return PageFactory.getSignInModal(driver());
	}
	
	public CafeLocationsPage goToCafeLocations() {
		driver().clickByCSS(this.CAFE_LOCATIONS);
		return PageFactory.getCafeLocationsPage(driver());
	}
	
	public MenuCategory goToBrowseOurMenu() {
		driver().clickByCSS(this.BROWSE_OUR_MENU);
		driver().clickByCSS(this.OUR_MENU);
		return PageFactory.getMenuCategoryPage(driver());
	}
	
	public BasePageWithMenuFrame verifyPageTitle(String title) {
		boolean isPresent = driver().checkPageTitle(title);
		Assert.assertTrue(isPresent == true);
		return this;
	}
	
	public BasePageWithMenuFrame verifyPageURL(String url) {
		boolean isCorrect = driver().checkPageURL(url);
		Assert.assertTrue("User has not landed on correct page", isCorrect == true);
		return this;
	}
	
	public Set<String> getWindowHandles() {
		return driver().getWindowHandles(); 
		
	}
	
	public MyAccountPages updateAccountInfoOpt() throws IOException {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_ACCOUNT_INFO);
		captureScreenshot();
		return PageFactory.getMyAccountPages(driver());
	}
	
	public MyAccountPages updatePassword(String currentPassword, String newPassword, String confirmPassword) {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_ACCOUNT_INFO);
		driver().findByCSS(this.OLD_PASSWORD).sendKeys(currentPassword);
		driver().findByCSS(this.NEW_PASSWORD).sendKeys(newPassword);
		driver().findByCSS(this.CONFIRM_PASSWORD).sendKeys(confirmPassword);
		driver().clickByCSS(this.UPDATE_PASSWORD);
		return PageFactory.getMyAccountPages(driver());
}
	
	public MyAccountPages goToMyAddresses() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_ADDRESSES);
		return PageFactory.getMyAccountPages(driver());
	}
	
	public MyAccountPages goToMyPhoneNumbers() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_PHONE_NUMBERS);
		return PageFactory.getMyAccountPages(driver());
	}
	
	public MyAccountPages goToMyCafes() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_CAFES);
		return PageFactory.getMyAccountPages(driver());
	}
	
	public MyAccountPages goToMyCards() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_CARDS);
		return PageFactory.getMyAccountPages(driver());
	}
	
	public MyAccountPages updateEmailPreferences() {
		driver().clickByCSS(this.MY_ACCOUNT);
		driver().clickByCSS(this.MY_NOTIFICATIONS);
		return PageFactory.getMyAccountPages(driver());
	}
	
	public BasePageWithMenuFrame checkForFavoriteItem(String favName) {
		try {
			WebElement el = driver().findByJavascript(String.format(this.FAV_ORDER_CHECK, favName));
			String favItemName = el.getText();
			boolean isPresent = (favItemName.contains(favName));
			Assert.assertTrue(isPresent == true);
		}
		catch (Exception e) {
			boolean isNotPresent = true;
			Assert.assertFalse("Favorite Item is not displayed", isNotPresent == true);
		}
		return this;
	}

	public BasePageWithMenuFrame checkForPastOrder(String username, String pswrd, String[] items) {
		String orderTotal = getTotal();
		String orderDate = driver().getDate();
		signOut();
		logIn();
		signIn(username, pswrd);
		goToBrowseOurMenu();
		clickSidebarCategory("My Past Orders");
		driver().pause(3000);
		WebElement dateCheck = driver().findByJavascript(String.format(this.PAST_ORDER_CHECK, orderDate));
		WebElement priceCheck = driver().findByJavascript(String.format(this.PAST_ORDER_CHECK, orderTotal));
		System.out.println(dateCheck);
		System.out.println(priceCheck);
		boolean isPresent = ((dateCheck.equals(priceCheck)) && dateCheck.equals(checkForItemsInPastOrder(items)));
		Assert.assertTrue("Past Order is not displayed", isPresent == true);
		return this;
	}
	
	public WebElement checkForItemsInPastOrder(String[] items) {
		WebElement item = null;
		for (int i = 0; i < items.length; i++) {
			item = driver().findByJavascript(String.format(this.PAST_ORDER_ITEM_CHECK, items[i]));
			}
		return item;
	}
	
	public BasePageWithMenuFrame checkOrderDescText(String orderType, String text) {
		boolean isPresent = false;
		try { 
			int orderTypeId = getOrderId(orderType);
			WebElement el = driver().findByJavascript(String.format(this.ORDER_TYPE_DESC, orderTypeId, text));
			String orderName = el.getText();
			isPresent = (orderName.contains(text.replace("\\", "")));
			Assert.assertTrue("Order Type description text is not displayed correctly", isPresent == true);
		}
		catch (Exception e) {
			Assert.assertTrue("Order Type description text is not displayed correctly", isPresent == true);		}
		return this;
	}
	
	public int getOrderId(String type) {
		int id = 0;
		String orderType = type.toLowerCase();
		if (orderType.contains("rpu") || orderType.contains("rapid pickup") || orderType.contains("rapid-pickup")) {
			id = 1;
		}
		if (orderType.contains("delivery")) {
			id = 2;
		}
		if (orderType.contains("dine in") || orderType.contains("dine-in") || orderType.contains("order from my table")) {
			id = 3;
		}
		return id;
	}
	
	public BasePageWithMenuFrame checkForExpressOrder() {
		boolean isNotPresent = false;
		try {
			isNotPresent = (driver().findByJavascript(String.format(this.MENU_SELECTION_FORMAT, "Express")) == null);
			Assert.assertTrue("Express Order Type displays on Homepage", isNotPresent == true);
		}
		catch (Exception e) {
			Assert.assertTrue("Express Order Type displays on Homepage", isNotPresent == false);
		}
		
		return this;
	}
	
	public String getTotal() {
		String total = driver().findByCSS(this.TOTAL).getText().replace("$", "");
		System.out.println(total);
		return total;
	}
		
	public String getSubtotal() {
		String subtotal = driver().findByCSS(this.SUBTOTAL).getText().replace("$", "");
		return subtotal;
	}
	
	public String getTax() {
		String tax = driver().findByCSS(this.TAX).getText().replace("$", "");
		return tax;
	}
	
	public BasePageWithMenuFrame captureScreenshot() throws IOException {
		driver().captureScreenshot();
		return this;
	}
	
	public void safeSendKeys(WebElement element, String value) {
		if (value != null) {
			element.sendKeys(value);
		}
	}
	

	public String findCardNumber(CardTypes type) {
		String number = null;
		if (System.getProperty("environment").equalsIgnoreCase("prod") != true) {
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
		}
		if (System.getProperty("environment").equalsIgnoreCase("prod")) {
				number = "";
		}
		return number;
	}

}