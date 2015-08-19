package com.panerabread.auit.pages;

public interface HomePage extends PageWithMenuFrame {
	public SignInModal startRPUOrder();
	public SignInModal startDineInOrder();
	public SignInModal startDeliveryOrder();
	public RegisterNewUserModal registerNewUserOpt();
	}