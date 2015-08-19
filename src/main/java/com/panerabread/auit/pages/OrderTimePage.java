package com.panerabread.auit.pages;

public interface OrderTimePage extends PageWithMenuFrame {
	PageWithMenuFrame orderForASAP();
	PageWithMenuFrame enterTableNumber(String tableNum);
	OrderTimePage enterDeliveryInfo(String addressType, String phone);
	PageWithMenuFrame orderForLater(int daysOut, String time, Boolean override);
	OrderTypeLocationPage returnToOrderTypeLocation();
}
