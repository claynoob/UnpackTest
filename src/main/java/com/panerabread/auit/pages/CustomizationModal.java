package com.panerabread.auit.pages;

public interface CustomizationModal extends PageWithMenuFrame {
	CustomizationModal modifyItem(String tab, String[] ingredients);
	CustomizationModal chooseSide(String side);
	MenuCategory orderCustomizedItem();
	MenuCategory orderItem();
	CustomizationModal verifyModifications(String[] ingredients);
	CustomizationModal addFavItem(String favName);
	MenuCategory updateItem();	
	CustomizationModal modifyComboItem(String tab, String[] ingredients);
	CustomizationModal addSpecialInstructions(String preparedFor, String instructions);
}
