package com.panerabread.auit.pages;

import java.io.IOException;

public interface CheckoutPage extends PageWithMenuFrame {
	OrderConfirmationPage payWithCC(CardTypes type, String number, String storedManual, String nameStoredCC, boolean storeCC);
	OrderConfirmationPage payWithGC(String GCNum, String storedManual, boolean storeGC);
	OrderConfirmationPage payWithGCAndCC(String GCNum, String GCStoredManual,
			boolean storeGC, CardTypes type, String CCNum, String CCStoredManual, String nameStoredCC, boolean storeCC);
	OrderConfirmationPage freeOrderCheckout();
	
	OrderConfirmationPage submit();
		
	CheckoutPage dismissBeverageUpsell();
	CheckoutPage beverageProceedToPayment();	
	CheckoutPage selectBeverages(String beverage);
	
	CheckoutPage dismissBakeryUpsellModal();
	CheckoutPage bakeryProceedToPayment();
	CheckoutPage selectBakeryItems(String bakeryItem);
	
	CheckoutPage dismissRewards();	
	CheckoutPage selectRewards(String reward);
	CheckoutPage addFavoriteItem(String item, String name);
	CheckoutPage addFavoriteOrder(String name);
	CheckoutPage dismissAllModals();
	CheckoutPage deleteItem(Boolean isCombo, String item, Boolean yesDelete);
	CheckoutPage duplicateItem(Boolean isCombo, String item);
	CheckoutPage customizeItem(Boolean isCombo, String item);
	CheckoutPage verifyItemPrice(String item, float expectedPrice);
	
	CheckoutPage verifyCardDisplaysInDropDown(String ccInfo);
	CheckoutPage verifyCardNotInDropDown(String ccInfo);
	CheckoutPage verifyItemPrices() throws IOException;
}
