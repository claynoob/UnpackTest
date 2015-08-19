package com.panerabread.auit.pages.concrete;

import org.openqa.selenium.WebElement;

import com.panerabread.auit.pages.OrderTimePage;
import com.panerabread.auit.pages.OrderTypeLocationPage;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultOrderTypeLocationPage extends BasePageWithMenuFrame implements
		OrderTypeLocationPage {
	
	private final String SEARCH_BOX = "#cafeSearch", DEL_ADDRESS_FIELD = ".form-control[name='address']", 
			CHECK_AVAILABILITY = "input.btn", RPU="#orderTypesWrapper > div:nth-child(1)", 
			DINE_IN="div.col-md-4:nth-child(3)", DELIVERY="#orderTypesWrapper > div:nth-child(2)",
			CAFE_SCRIPT_FORMAT = "return (function b(){ return (function a(cafeId){var foundCafe = null; Array.prototype.slice.call(document.querySelectorAll('.cafeName')).forEach(function(cafe) {if(cafe.innerHTML.indexOf(cafeId) > 0) {foundCafe = cafe;}}); return foundCafe;}) ('%s').parentElement.nextSibling.nextSibling.getElementsByTagName('a')[0]})();";
	
	public DefaultOrderTypeLocationPage(AdvancedWebDriver driver) {
		super(driver);
	}
	
	public OrderTypeLocationPage chooseRPU() {
		driver().clickByCSS(this.RPU);
		return this;
	}

	public OrderTypeLocationPage chooseDelivery() {
		driver().clickByCSS(this.DELIVERY);
		return this;
	}

	public OrderTypeLocationPage chooseDineIn() {
		driver().clickByCSS(this.DINE_IN);
		return this;
	}

	public OrderTimePage chooseCafe(String search, String cafeId) {
		searchForCafe(search);
		return chooseCafe(cafeId);
	}

	public OrderTypeLocationPage searchForCafe(String search) {
		WebElement searchBox = driver().findByCSS(this.SEARCH_BOX);
		searchBox.sendKeys(search);
		driver().pause(5000);
		return this;
	}

	public OrderTimePage chooseCafe(String cafeId) {
		driver().clickByJavascript(String.format(this.CAFE_SCRIPT_FORMAT, cafeId));
		getSelectedCafe();
		return PageFactory.getOrderTimePage(driver());
	}
	
	public OrderTimePage enterDeliveryAddress(String address){
		driver().pause(1000);
		driver().findByCSS(this.DEL_ADDRESS_FIELD).sendKeys(address);
		driver().clickByCSS(this.CHECK_AVAILABILITY);
		return PageFactory.getOrderTimePage(driver());
	}
}