package com.panerabread.auit.pages;

public interface OrderTimePage {
	public PageWithMenuFrame orderForASAP();
	public PageWithMenuFrame orderForLater();
	public PageWithMenuFrame enterTableNumber(String tableNum);
	public OrderTimePage enterPhoneNumber(String phoneNum);
	public OrderTimePage chooseDelAddressType(String addressType);
}
