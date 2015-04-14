package com.panerabread.auit.pages;

public interface CheckoutPage {
	OrderConfirmationPage payWithManualCC(CardTypes type);
	OrderConfirmationPage payWithManualGC(String GCNum);
	OrderConfirmationPage payWithStoredCC(String cardName);
	OrderConfirmationPage payWithStoredGC();
	OrderConfirmationPage freeOrderCheckout();
	
	CheckoutPage populateCheckoutFormManualCC(CheckoutPageConfig config);

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
}
