package com.panerabread.auit.pages.concrete;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.panerabread.auit.pages.CustomizationModal;
import com.panerabread.auit.pages.MenuCategory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultMenuCategory extends BasePageWithMenuFrame implements
		MenuCategory {

	private final String ORDER_BTN="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.col-sm-8')).reverse().forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('btn-primary')[0]})();",
			CATEGORY="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('a')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.getElementsByTagName('a')[0]})();",
			ADD_TO_ORDER="div.pull-right > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)",
			MENU_CUST_BTN="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.col-sm-8')).reverse().forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('btn-default')[0]})();",
			CART_CUST_BTN="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.items')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').firstElementChild.lastElementChild.getElementsByTagName('button')[0]})();",
			DUPLICATE_BTN="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.items')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').firstElementChild.lastElementChild.getElementsByTagName('button')[1]})();",
			CUST_BTN="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.col-sm-8')).reverse().forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('btn-default')[0]})();",
			INGREDIENT_CHECK="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('li')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s').firstElementChild.firstElementChild.nextElementSibling.nextElementSibling.firstElementChild.getElementsByTagName('span')})();",
			ITEM_DESC="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('.col-xs-12')).forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('js-popover')[0]})();",
			ITEM_NUTRITION="return (function b(){ return (function a(menuCategoryId){ var foundCategory = null; Array.prototype.slice.call(document.querySelectorAll('.col-xs-12')).forEach(function(menuCategory) {if(menuCategory.innerHTML.indexOf(menuCategoryId) > 0) {foundCategory = menuCategory;}}); return foundCategory;})('%s').parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName('js-popover')[0].parentElement.nextElementSibling.firstElementChild})();",
			CART_ITEM_CHECK="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('div[ng-if=\"!item.isCombo\"]')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s')})();",
			CART_COMBO_CHECK="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('.row')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s')})();",
			CART_COMBO_ITEM_CHECK="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('#comboItems')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s')})();",
			PAST_ORDER_CHECK="return (function b(){ return (function a(itemId){var foundItem = null; Array.prototype.slice.call(document.querySelectorAll('span')).reverse().forEach(function(item) {if(item.innerHTML.indexOf(itemId) > 0) {foundItem = item;}}); return foundItem;}) ('%s').parentElement.getElementsByTagName('button')[0]})();",
			ORDER_FIRST_PAST_ORDER=".col-md-8 > div:nth-child(1) > div:nth-child(1) > my-past-orders:nth-child(1) > div:nth-child(2) > div:nth-child(1) > my-order:nth-child(1) > div:nth-child(1) > accordion:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > button:nth-child(1)",
			SELECT_ELIGIBLE_REWARD="#rewardModal", SELECT_ELIGIBLE_ITEM="button.btn:nth-child(2)",
			REDEEM_REWARD="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.parentElement.parentElement.getElementsByClassName('btn-primary')[0]})();",
			VARIANT_DROPDOWN="return (function b(){ return (function a(itemId){ var foundItem=null; Array.prototype.slice.call(document.querySelectorAll('div')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.parentElement.parentElement.parentElement.getElementsByClassName('dropdown-toggle')[0]})();",
			SOUP_VARIANT_DROPDOWN="return (function b(){ return (function a(itemId){ var foundItem=null; Array.prototype.slice.call(document.querySelectorAll('.col-xs-8')).reverse().forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').parentElement.parentElement.parentElement.parentElement.getElementsByClassName('dropdown-toggle')[0]})();",
			WHOLE=".open > ul:nth-child(2) > li:nth-child(1)",
			HALF=".open > ul:nth-child(2) > li:nth-child(2)",
			BAGUETTE=".menu-content > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1)",
			MICHE=".menu-content > div:nth-child(1) > div:nth-child(1) > div:nth-child(9) > div:nth-child(3) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2)",
			LOAF=".menu-content > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1)",
			DEMI=".menu-content > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2)",
			XL_LOAF=".menu-content > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2)",
			BREAD_BREADBOWL=".menu-content > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3)",
			BOWL=".menu-content > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1)",
			CUP=".menu-content > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2)",
			SOUP_BREADBOWL=".menu-content > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > placard:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3)",
			BAKERY_PREP="#preorder", JUST_THE_BAGEL_THIN_SLICE="#preorder > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)",
			SLICED_TOASTED_THICK_SLICE="#preorder > div:nth-child(1) > div:nth-child(2) > button:nth-child(1)",
			UNSLICED="#preorder > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)",
			ITEM_CNT="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.comboHeader')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').nextElementSibling.children})();",
			ITEM_COUNT="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.comboHeader')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('%s').nextElementSibling.childElementCount})();",
			RANDOM_PICK="return (function b(){ return (function a(itemId){ var foundItem= null; Array.prototype.slice.call(document.querySelectorAll('.comboHeader')).forEach(function(itemPlacard) {if(itemPlacard.innerHTML.indexOf(itemId) > 0) {foundItem= itemPlacard;}}); return foundItem;})('Pick').nextElementSibling.getElementsByClassName('btn-primary')[%d]})();";
	
	public DefaultMenuCategory(AdvancedWebDriver driver) {
		super(driver);
	}
		
	public int getNum(int num){
		Random r = new Random();
		int i = r.nextInt(num);
		System.out.println(num);
		System.out.println(i);
		return i;
	}

	public MenuCategory comboOrder(String cat1, String cat2) {
		driver().clickByJavascript(String.format(this.CATEGORY, cat1));
		driver().pause(750);
		driver().clickByJavascript(String.format(this.RANDOM_PICK, 
				getNum(driver().countByJavascript(String.format(this.ITEM_CNT, cat1)).size())));
		driver().clickByJavascript(String.format(this.CATEGORY, cat2));
		driver().clickByJavascript(String.format(this.RANDOM_PICK, 
				getNum(driver().countByJavascript(String.format(this.ITEM_CNT, cat2)).size())));
		driver().clickByCSS(this.ADD_TO_ORDER);
		return this;
	}

	public MenuCategory orderItem(String name, boolean variantOpt, String variantSize) {
		if (variantOpt == true) {
			variantDropdownSelect(name, variantSize);
		}
		driver().clickByJavascript(String.format(this.ORDER_BTN, name));
		if(checkForBakeryPrepModal() == true) {
			driver().clickByCSS(this.JUST_THE_BAGEL_THIN_SLICE);
		}
		return this;
	}
	
	public MenuCategory verifyItemNotDisplayed(String name) {
		boolean notPresent = false;
		try {
			driver.findByJavascript(String.format(this.ORDER_BTN, name));
			notPresent = true;
		}
		catch (Exception e) {
		}
		Assert.assertTrue("Item displayed at incorrect time: " + name, notPresent);
		return this;
	}
	
	public MenuCategory orderSpecialBakeryItem(String name) {
			driver().clickByCSS(this.JUST_THE_BAGEL_THIN_SLICE);
		return this;
	}
	
	public MenuCategory getBagelPrepOpt(boolean customizeBagel) {
		if (customizeBagel == true) {
			driver().clickByCSS(this.SLICED_TOASTED_THICK_SLICE);
		}
		return this;
	}
	
	public MenuCategory variantDropdownSelect(String name, String size) {
		@SuppressWarnings("unused")
		boolean isPresent = false;
		String variantSize = getVariantSize(size);
		try {
			driver().clickByJavascript(String.format(this.VARIANT_DROPDOWN, name));
			driver().clickByCSS(variantSize);
			isPresent = true;
		}
		catch (Exception e) {
		}
		if (isPresent = false) {
			driver().clickByJavascript(String.format(this.SOUP_VARIANT_DROPDOWN, name));
			driver().clickByCSS(variantSize);
		}
		return this;
	}
	
	public Boolean checkForBakeryPrepModal() {
		boolean isPresent = false;
		try {
			driver().findByCSS(this.BAKERY_PREP);
			isPresent = true;
		}
		catch(Exception e) {
		}
		return isPresent;
	}
	
	public String getVariantSize(String size) {
		String variantSize = null;
		try {
			if (size.equalsIgnoreCase("half")) {
				variantSize = this.HALF;
			}
			if (size.equalsIgnoreCase("whole")) {
				variantSize = this.WHOLE;
			}
			if (size.equalsIgnoreCase("bowl")) {
				variantSize = this.BOWL;
			}
			if (size.equalsIgnoreCase("cup")) {
				variantSize = this.CUP;
			}
			if (size.equalsIgnoreCase("soup breadbowl")) {
				variantSize = this.SOUP_BREADBOWL;
			}
			if (size.equalsIgnoreCase("baguette")) {
				variantSize = this.BAGUETTE;
			}
			if (size.equalsIgnoreCase("miche")) {
				variantSize = this.MICHE;
			}
			if (size.equalsIgnoreCase("loaf")) {
				variantSize = this.LOAF;
			}
			if (size.equalsIgnoreCase("demi")) {
				variantSize = this.DEMI;
			}
			if (size.equalsIgnoreCase("bread breadbowl")) {
				variantSize = this.BREAD_BREADBOWL;
			}
			if (size.equalsIgnoreCase("xl loaf")) {
				variantSize = this.XL_LOAF;
			}
		}
		catch (Exception e) {
		}
		return variantSize;
	}
	
	public MenuCategory orderYP2Combo(String pick1Category, String pick1, String pick2Category, String pick2) {
		driver().clickByJavascript(String.format(this.CATEGORY, pick1Category));
		driver().clickByJavascript(String.format(this.ORDER_BTN, pick1));
		driver().clickByJavascript(String.format(this.CATEGORY, pick2Category));
		driver().clickByJavascript(String.format(this.ORDER_BTN, pick2));
		driver().clickByCSS(this.ADD_TO_ORDER);
		checkCartForComboItems(System.getProperty("category"), pick1, pick2);
		return this;
	} 
	
	public MenuCategory orderCombo(String pick1, String pick2) {
		driver().clickByJavascript(String.format(this.ORDER_BTN, pick1));
		driver().pause(500);
		driver().clickByJavascript(String.format(this.ORDER_BTN, pick2));
		driver().clickByCSS(this.ADD_TO_ORDER);
		checkCartForComboItems(System.getProperty("category"), pick1, pick2);
		return this;
	}
	
	public CustomizationModal customizeYP2Pick1(String pick1Category, String pick1) {
		driver().clickByJavascript(String.format(this.CATEGORY, pick1Category));
		driver().clickByJavascript(String.format(this.MENU_CUST_BTN, pick1)); 
		return PageFactory.getCustomizationModal(driver);
	}
	
	public CustomizationModal customizeYP2Pick2(String pick2Category, String pick2) {
		driver().clickByJavascript(String.format(this.CATEGORY, pick2Category));
		driver().clickByJavascript(String.format(this.MENU_CUST_BTN, pick2));
		return PageFactory.getCustomizationModal(driver);
	}
	
	public MenuCategory orderCustYP2() {
		driver().clickByCSS(this.ADD_TO_ORDER);
		return this;
	}
	
	public CustomizationModal customizeItemFromMenu(String item){
		driver().clickByJavascript(String.format(this.CUST_BTN, item));
		return PageFactory.getCustomizationModal(driver);
	}
	

	public CustomizationModal customizeItemFromCart(String item){
		driver().clickByJavascript(String.format(this.CART_CUST_BTN, item));
		driver().pause(1000);
		return PageFactory.getCustomizationModal(driver);
	}
	
	public MenuCategory verifyDescription(String item) {
		WebElement description = driver().findByJavascript(String.format(this.ITEM_DESC, item));
		Actions action = new Actions(null, null);
		action.moveToElement(description).build().perform();
		return PageFactory.getMenuCategoryPage(driver);
	}
	
	public MenuCategory verifyModificationsCart(String item, String[] ingredients){
		for (int i = 0; i < ingredients.length; i++) {
			WebElement modifications = driver().findByJavascript(String.format(this.INGREDIENT_CHECK, item));
			//for (int x = 0; x < modifications.length; x++) {
				if (modifications != null) {
			}
			//Assert.assertTrue("Modification not applied: " + ingredients[i], (modifications != null));
		//}
		}
		return this;
	}
	
	public MenuCategory chooseReward(String reward) {
		driver().clickByJavascript(String.format(this.REDEEM_REWARD, reward));
		if (checkForRewardsPopup() == true) {
			driver().clickByCSS(this.SELECT_ELIGIBLE_ITEM);
		}
		return this;
	}
	
	public Boolean checkForRewardsPopup() {
		boolean isPresent = false;
		try {
			driver().findByCSS(this.SELECT_ELIGIBLE_REWARD);
			isPresent = true;
		}
		catch (Exception e) {
		}
		return isPresent;
	}
	
	public MenuCategory reorderFirstPastOrder() {
		driver().clickByCSS(this.ORDER_FIRST_PAST_ORDER);
		return this;
	}
	
	public MenuCategory reorderPastOrder(String date, String total) {
		System.out.println("date: " + date + "     total: " + total);
		checkForPastOrder(date, total);
		if (System.getProperty("isSaved").equalsIgnoreCase("true")) {
			driver().clickByJavascript(String.format(this.PAST_ORDER_CHECK, date));
		}
		return this;
	}
	
	public MenuCategory verifyPastOrderDisplays(String date, String total) {
		boolean isNotPresent = checkForPastOrder(date, total);
		Assert.assertTrue("Past Order displays", isNotPresent);
		return this;
	}
	
	public MenuCategory verifyPastOrderDoesNotDisplay(String date, String total) {
		boolean isNotPresent = checkForPastOrder(date, total);
		Assert.assertFalse("Past Order displays", isNotPresent);
		return this;
	}
	
	public Boolean checkForPastOrder(String date, String total) {
		boolean isSaved = false;
		driver().pause(1500);
		try {
			WebElement dateCheck = driver().findByJavascript(String.format(this.PAST_ORDER_CHECK, date));
			WebElement priceCheck = driver().findByJavascript(String.format(this.PAST_ORDER_CHECK, total));
			if (dateCheck.toString().equals(priceCheck.toString())) {
				isSaved = true;
				{System.setProperty("isSaved", "true");}
			}
		}
		catch (Exception e) {
		}
		return isSaved;
	}
	
	public MenuCategory checkCartForItem(String item) {
		boolean isPresent = false;
		try {
			driver().findByJavascript(String.format(this.CART_ITEM_CHECK, item));
			isPresent = true;
		}
		catch (Exception e) {
		}
		Assert.assertTrue("Item was not added to cart: " + item, isPresent);
		return this;
	}
	
	public MenuCategory checkCartForComboItems(String combo, String pick1, String pick2) {
		boolean isPresent = false;
		try {
			driver().findByJavascript(String.format(this.CART_ITEM_CHECK, combo));
			driver().findByJavascript(String.format(this.CART_ITEM_CHECK, pick1));
			driver().findByJavascript(String.format(this.CART_ITEM_CHECK, pick2));
			isPresent = true;
		}
		catch (Exception e) {
		}
		Assert.assertTrue("Combo was not added to cart: " + combo + " " + pick1 + " " + pick2, isPresent);
		return this;
	}
	
	public Boolean checkForCategory(String format, String category) {
		boolean notPresent = true;
		try {
			driver().clickByJavascript(String.format(format, category));
			notPresent = false;
		}
		catch (Exception e) {
		}
		return notPresent;
	}
	
	public MenuCategory verifyMenuItemsNotPresent(String item) {
		boolean notPresent = true;
		String category = System.getProperty("category");
		if (category == "Soups and Mac &amp; Cheese") {
			checkForCategory(this.ORDER_BTN, "Broccoli Cheddar Soup");
			notPresent = false;
		}
		if (category == "You Pick 2") {
			checkForCategory(this.CATEGORY, "Soups and Mac &amp; Cheese");
			notPresent = false;
		}
		Assert.assertTrue("Items display which should not display: " + item, notPresent);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((PAST_ORDER_CHECK == null) ? 0 : PAST_ORDER_CHECK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultMenuCategory other = (DefaultMenuCategory) obj;
		if (PAST_ORDER_CHECK == null) {
			if (other.PAST_ORDER_CHECK != null)
				return false;
		} else if (!PAST_ORDER_CHECK.equals(other.PAST_ORDER_CHECK))
			return false;
		return true;
	}
}