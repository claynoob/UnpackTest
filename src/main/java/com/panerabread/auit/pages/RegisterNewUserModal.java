package com.panerabread.auit.pages;

public interface RegisterNewUserModal extends PageWithMenuFrame {
	RegisterNewUserModal regNewUser(RegisterNewUserConfig config);
	RegisterNewUserModal registerNewUser(String loyaltyNum, String regNum, String opt);
	OrderTypeLocationPage startOrdering();
	MyAccountPages manageMyAccount();
	}