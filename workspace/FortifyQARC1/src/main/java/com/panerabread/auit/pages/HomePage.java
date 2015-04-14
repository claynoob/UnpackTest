package com.panerabread.auit.pages;

public interface HomePage {
	public SignInModal startRPUOrder();
	public SignInModal startDineInOrder();
	public SignInModal startDeliveryOrder();
	public void registerNewUser(String firstName, String lastName, String phoneNum, String email, String address, 
			String city, String state, String zip, String username, String password, String passwordConfirm, 
			String month, String date, String year);
	}