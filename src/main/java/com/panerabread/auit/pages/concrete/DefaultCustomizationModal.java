package com.panerabread.auit.pages.concrete;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.panerabread.auit.pages.CustomizationModal;
import com.panerabread.auit.pages.MenuCategory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultCustomizationModal extends BasePageWithMenuFrame implements CustomizationModal {

	public DefaultCustomizationModal(AdvancedWebDriver driver) {
		super(driver);
	}
	
	private final String ORDER_BTN="div.builder-size:nth-child(4) > builder-total:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(3)",
			ADD_ITEM="div.builder-size:nth-child(4) > builder-total:nth-child(2) > div:nth-child(2) > button:nth-child(3)",
			ADD_FAV_ITEM="div.builder-size:nth-child(4) > builder-total:nth-child(2) > div:nth-child(1) > add-favorite:nth-child(2) > a:nth-child(1)", 
			FAV_NAME="#favoriteName", PREPARED_FOR="#name", INSTRUCTIONS="#instructions",
			UPDATE_ITEM="div.builder-size:nth-child(4) > builder-total:nth-child(2) > div:nth-child(2) > button:nth-child(3)",
			CUST_SIDE_TAB=".col-md-3 > customization-nav:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > side-group:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ol:nth-child(1) > li:nth-child(1)",
			CUST_SIDE="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('li')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s')})();",
			CUST_INGREDIENTS=" return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('.checkbox')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s').parentElement.getElementsByClassName('check')[0]})();",
			CUST_TAB="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('li')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s')})();",
			SPECIAL_INSTRUCTIONS_TAB="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('.col-xs-12')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('Instructions').firstElementChild.firstElementChild})();",
			INGREDIENT_CHECK="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('.component')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s')})();";
	
	public CustomizationModal chooseCustTab(String tab) {
		driver().clickByJavascript(String.format(this.CUST_TAB, tab));
		return PageFactory.getCustomizationModal(driver);
	}
	
	public CustomizationModal chooseSide(String side) {
		driver().clickByCSS(this.CUST_SIDE_TAB);
		driver().clickByJavascript(String.format(this.CUST_SIDE, side));
		return PageFactory.getCustomizationModal(driver);
	}
	
	public MenuCategory orderItem() {
		driver().clickByCSS(this.ORDER_BTN);
		return PageFactory.getMenuCategoryPage(driver);
	}
		
	public MenuCategory updateItem() {
		driver.clickByCSS(this.UPDATE_ITEM);
		return PageFactory.getMenuCategoryPage(driver);
	}

	public MenuCategory orderCustomizedItem() {
		driver().clickByCSS(this.ADD_ITEM);
		return PageFactory.getMenuCategoryPage(driver);
	}
	
	public CustomizationModal addFavItem(String favName) {
		driver().clickByCSS(this.ADD_FAV_ITEM);
		driver().findByCSS(this.FAV_NAME).sendKeys(favName, Keys.ENTER);
		return this;
	}
	
	public CustomizationModal chooseCustomizations(String[] ingredients) {
		for (int i = 0; i < ingredients.length; i++) {
		driver().clickByJavascript(String.format(this.CUST_INGREDIENTS, ingredients[i]));
		}
		return this;
	}
	
	public CustomizationModal modifyItem(String tab, String[] ingredients){
		chooseCustTab(tab);
		chooseCustomizations(ingredients);
		verifyModifications(ingredients);
		return this;
	}
	
	public CustomizationModal modifyComboItem(String tab, String[] ingredients){
		chooseCustTab(tab);
		chooseCustomizations(ingredients);
		verifyModifications(ingredients);
		return this;
	}
	
	public CustomizationModal addSpecialInstructions(String preparedFor, String instructions) {
		driver().clickByJavascript(this.SPECIAL_INSTRUCTIONS_TAB);
		driver().findByCSS(this.PREPARED_FOR).sendKeys(preparedFor);
		driver().findByCSS(this.INSTRUCTIONS).sendKeys(instructions);
		return this;
	}
	
	public CustomizationModal verifyModifications(String[] ingredients){
		for (int i = 0; i < ingredients.length; i++) {
			WebElement modification = driver().findByJavascript(String.format(this.INGREDIENT_CHECK, ingredients[i]));
			Assert.assertTrue("Modification not applied: " + ingredients[i], (modification != null));
		}
			return this;
	}

}
