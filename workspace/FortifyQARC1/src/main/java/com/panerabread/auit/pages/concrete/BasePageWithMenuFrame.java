package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.pages.MenuCategory;
import com.panerabread.auit.pages.CheckoutPage;
import com.panerabread.auit.pages.PageWithMenuFrame;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public abstract class BasePageWithMenuFrame extends BasePage implements PageWithMenuFrame {

	private final String MENU_SELECTION_FORMAT = "return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll(\'.col-xs-12\')).forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('placard')[0]})();", 
			//CELEBRATIONS = ".menu-content > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > img:nth-child(1)",
			CHECKOUT_BUTTON = ".order-summary-body > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > button:nth-child(1)",
			SIDEBAR_SELECT_CATEGORY="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('.ng-scope')).forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').parentElement.getElementsByClassName('ng-binding')[0]})();",
			SIDEBAR_SELECT_MY_PANERA_CATEGORY="return ";			
			//SALAD_IDX = ".menu-content > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)";
	public BasePageWithMenuFrame(AdvancedWebDriver driver) {
		super(driver);
	}
	
	public CheckoutPage goToCheckout(){
		driver().clickByCSS(this.CHECKOUT_BUTTON);
		return  PageFactory.getCheckoutPage(driver());
	}

	public MenuCategory clickCategoryPlacard(String category){
		driver().clickByJavascript(String.format(this.MENU_SELECTION_FORMAT, category));
		return PageFactory.getMenuCategoryPage(driver());

	}
	
	public MenuCategory clickSidebarCategory(String category) {
		//driver().clickByJavascript(String.format(this.SIDEBAR_SELECT, category));
		return PageFactory.getMenuCategoryPage(driver());
	}
	
	/*public MenuCategory openSalads() {
		clickCategory();
		return PageFactory.getMenuCategoryPage(driver());
	}*/
}