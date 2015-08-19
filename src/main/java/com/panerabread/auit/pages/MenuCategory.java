package com.panerabread.auit.pages;

public interface MenuCategory extends PageWithMenuFrame {
	MenuCategory orderItem(String string, boolean variantOpt, String variantSize);
	MenuCategory orderYP2Combo(String pick1Category, String pick1, String pick2Category, String pick2);
	MenuCategory orderCombo(String pick1, String pick2);
	CustomizationModal customizeItemFromMenu(String item);
	MenuCategory verifyModificationsCart(String item, String[] ingredients);
	CustomizationModal customizeItemFromCart(String item);
	CustomizationModal customizeYP2Pick1(String pick1Category, String pick1);
	CustomizationModal customizeYP2Pick2(String pick2Category, String pick2);
	MenuCategory orderCustYP2();
	MenuCategory chooseReward(String reward);
	MenuCategory reorderFirstPastOrder();
	MenuCategory reorderPastOrder(String date, String total);
	Boolean checkForPastOrder(String date, String total);
	MenuCategory verifyPastOrderDisplays(String date, String total);
	MenuCategory verifyPastOrderDoesNotDisplay(String date, String total);
	MenuCategory comboOrder(String cat1, String cat2);
	MenuCategory verifyItemNotDisplayed(String name);
}
