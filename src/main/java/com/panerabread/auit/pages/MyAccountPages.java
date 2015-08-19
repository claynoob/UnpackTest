package com.panerabread.auit.pages;

import java.io.IOException;

public interface MyAccountPages extends PageWithMenuFrame {
	MyAccountPages addNewAddress(String type, String address, String name, 
			String city, String state, String zip, String phone, String instructions);
	MyAccountPages addNewPhone();
	MyAccountPages addNewCafe(String search, int cafeNumber);
	MyAccountPages storeCreditCardOpt(CardTypes type);
	MyAccountPages storeGiftCardOpt();
	MyAccountPages editEmailPreferences(String emailPreferences, String rewardsAndAlerts,
			String updatesAndSpecialOffers, String localNews, String inPersonOnlineEvents, 
			String communicationsWithOtherMembers, String shareYourThoughts);
	MyAccountPages addFavoriteCafe(String search, int cafeId);
	MyAccountPages updateAccountInfo() throws IOException;
	MyAccountPages removeDateAcctInfo();
	MyAccountPages updateEmail(String email);
	Boolean checkForPhone(String name, String number);
	MyAccountPages deletePhone();
	MyAccountPages setDefaultPhoneNum();
	MyAccountPages editPhoneOpt() throws IOException;
	MyAccountPages deleteCard(String nickname, String ccInfo, String expDate, Boolean deleteConfirm);
	MyAccountPages deleteTestCards();
}