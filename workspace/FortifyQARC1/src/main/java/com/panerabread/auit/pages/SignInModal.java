package com.panerabread.auit.pages;

public interface SignInModal {
	public OrderTypeLocationPage orderAsGuest();
	public OrderTypeLocationPage signInWithPhone(String phone, String password, String accountFirstName);
	public OrderTypeLocationPage signIn(String user, String password);
}
