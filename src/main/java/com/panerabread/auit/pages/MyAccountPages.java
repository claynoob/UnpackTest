package com.panerabread.auit.pages;

import com.panerabread.auit.pages.concrete.DefaultMyAccountPages;

public interface MyAccountPages extends PageWithMenuFrame {
	MyAccountPages addNewAddress(String type, String address, String name, String suite, String city, String state,
			String zip, String phone, String instructions);
	MyAccountPages addNewPhone(String name, String number);
	MyAccountPages addNewCafe(String search, int cafeNumber);
	DefaultMyAccountPages storeCreditCard(String nickname, String cardholderName, String type, 
			String number, String expMonth, String expYear);
	DefaultMyAccountPages storeGiftCard(String nickname, String cardNumber);
	DefaultMyAccountPages editEmailPreferences(String emailPreferences, String rewardsAndAlerts,
			String updatesAndSpecialOffers, String localNews, String inPersonOnlineEvents, 
			String communicationsWithOtherMembers, String shareYourThoughts);
}