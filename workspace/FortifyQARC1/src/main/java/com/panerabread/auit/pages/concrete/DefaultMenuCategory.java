package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.MenuCategory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultMenuCategory extends BasePageWithMenuFrame implements
		MenuCategory {

	private final String ORDER_BTN="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.col-xs-8')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('btn-primary')[0]})();",
			CATEGORY="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('a')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.getElementsByTagName('a')[0]})();",
			ADD_TO_ORDER="div.pull-right > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)",
			CANCEL="div.pull-right > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)";
	
	public DefaultMenuCategory(AdvancedWebDriver driver) {
		super(driver);
	}

	public MenuCategory orderItem(String name) {
		driver().clickByJavascript(String.format(this.ORDER_BTN, name));
		return this;
	}
	
	public MenuCategory orderYP2Combo(String pick1Category, String pick1, String pick2Category, String pick2) {
		driver().clickByJavascript(String.format(this.CATEGORY, pick1Category));
		driver().clickByJavascript(String.format(this.ORDER_BTN, pick1));
		driver().clickByJavascript(String.format(this.CATEGORY, pick2Category));
		driver().clickByJavascript(String.format(this.ORDER_BTN, pick2));
		driver().clickByCSS(this.ADD_TO_ORDER);
		return this;
	} 
	
	public MenuCategory orderCombo(String pick1, String pick2) {
		driver().clickByJavascript(String.format(this.ORDER_BTN, pick1));
		driver().clickByJavascript(String.format(this.ORDER_BTN, pick2));
		driver().clickByCSS(this.ADD_TO_ORDER);
		return this;
	}
	
	/*public MenuCategory orderFavorite(String favorite) {
		driver().clickByCSS(this.FAVORITES);
		driver().clickByJavascript(this.ORDER_BTN);
		return this;
	}*/

}
