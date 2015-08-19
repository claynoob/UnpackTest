package com.panerabread.auit.pages;

import java.io.IOException;

public interface OrderConfirmationPage extends PageWithMenuFrame {
	OrderConfirmationPage verifyTotal(float expectedTotal);
	OrderConfirmationPage verifySubtotal(float expectedSubotal);
	OrderConfirmationPage verifyTax(float expectedTax);
	OrderConfirmationPage verifySuccessfulOrder() throws IOException;
	OrderConfirmationPage getOrderInfo() throws IOException;
	}
