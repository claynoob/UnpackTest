package com.panerabread.auit.pages;

import com.panerabread.auit.pages.concrete.DefaultMyAccountPages;

public interface OrderTypeLocationPage {
	OrderTimePage chooseCafe(String search, int cafeId);
	OrderTimePage enterDeliveryAddress(String address);
	void updateAccountInfo(String first, String last, String address, String city, String state, String zip, 
			String phone, String email);
	void updatePassword(String currentPassword, String newPassword, String confirmPassword);
	DefaultMyAccountPages addAddress();
	DefaultMyAccountPages addPhone();
	DefaultMyAccountPages addFavoriteCafe();
	DefaultMyAccountPages addCard();
	DefaultMyAccountPages updateEmailPreferences();
}
