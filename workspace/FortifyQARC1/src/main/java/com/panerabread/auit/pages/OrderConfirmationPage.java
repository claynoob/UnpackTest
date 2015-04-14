package com.panerabread.auit.pages;

public interface OrderConfirmationPage {
	public OrderConfirmationPage verifyTotal(float expectedTotal);
	public OrderConfirmationPage verifySubtotal(float expectedSubotal);
	public OrderConfirmationPage verifyTax(float expectedTax);
	public HomePage signOut();
}
