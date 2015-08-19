package com.panerabread.auit.pages;

public class CheckoutPageConfig {
	
	private String specialInstructions, specialcode, cardHolderName, securityCode, billingZip,
			cardNumber, email, phone, expireMonth, expireYear, prodSpecialInstructions;

	public CheckoutPageConfig(CardTypes ccType, String ccNum) {
		this.setCardHolderName("Mike Byson");
		this.setCardNumber(ccNum);
		this.setExpireMonth("02");
		this.setExpireYear("2020");
		this.setEmail("chaley.stanfield@panerabread.com");
		this.setPhone("9122372317");
		this.setProdSpecialInstructions("TEST ORDER DO NOT MAKE - PLEASE CANCEL");
		this.setSecurityCode("723");
		this.setBillingZip("63127");
	}
	
	public String getProdSpecialInstructions() {
		return prodSpecialInstructions;
	}

	public void setProdSpecialInstructions(String prodSpecialInstructions) {
		this.prodSpecialInstructions = prodSpecialInstructions;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public String getSpecialcode() {
		return specialcode;
	}

	public void setSpecialcode(String specialcode) {
		this.specialcode = specialcode;
	}
	
	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String code) {
		this.securityCode = code;
	}
	
	public String getBillingZip() {
		return billingZip;
	}

	public void setBillingZip(String zip) {
		this.billingZip = zip;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(String string) {
		this.expireMonth = string;
	}

	public String getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(String string) {
		this.expireYear = string;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
