package com.panerabread.auit.pages;

public interface OrderTypeLocationPage extends PageWithMenuFrame {
	OrderTimePage chooseCafe(String search, String cafeId);
	OrderTimePage enterDeliveryAddress(String address);
	OrderTypeLocationPage chooseRPU();
	OrderTypeLocationPage chooseDelivery();
	OrderTypeLocationPage chooseDineIn();
}
