package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.MenuCategory;
import com.panerabread.auit.pages.MainMenuPage;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultMainMenuPage extends BasePageWithMenuFrame implements MainMenuPage {
	
	//private final String PICTURE_MENU_FORMAT = "div.ng-scope:nth-child(7) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > img:nth-child(1)";

	public DefaultMainMenuPage(AdvancedWebDriver driver) {
		super(driver);
	}

	public MenuCategory clickCategoryPlacard(String item) {
		driver().clickByCSS(item);
		return PageFactory.getMenuCategoryPage(driver());
	}
	
	/*private void clickByIndex(int index){
		driver().clickByCSS(String.format(this.PICTURE_MENU_FORMAT, index));
	}*/
}
