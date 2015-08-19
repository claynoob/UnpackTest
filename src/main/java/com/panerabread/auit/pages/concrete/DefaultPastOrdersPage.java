package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.PageWithMenuFrame;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultPastOrdersPage extends BasePageWithMenuFrame implements
		PageWithMenuFrame {
	
	private final String PAST_ORDER_COUNT="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('.col-xs-12')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('.15').childElementCount})();";

	public DefaultPastOrdersPage(AdvancedWebDriver driver) {
		super(driver);
	}

}
