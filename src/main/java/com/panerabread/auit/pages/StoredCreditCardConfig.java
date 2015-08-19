package com.panerabread.auit.pages;

public class StoredCreditCardConfig {
	
	private String nickname, cardholderName, number, expMonth, expYear, securityCode, billingZip;
	
	
	public StoredCreditCardConfig(String today, CardTypes ccType, String ccNum){
		this.setNickname("Chaels" + today);
		this.setCardholderName("ChaleyAuto" + today);
		this.setCardNumber(ccNum);
		this.setExpMonth("03");
		this.setExpYear("2016");
		this.setSecurityCode("723");
		this.setBillingZip("63127");
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getCardholderName() {
		return cardholderName;
	}
	
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
	
	public String getCardNumber() {
		return number;
	}
	
	public void setCardNumber(String number) {
		this.number = number;
	}
	
	public String getExpMonth() {
		return expMonth;
	}
	
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	
	public String getExpYear() {
		return expYear;
	}
	
	public void setExpYear(String expYear) {
		this.expYear = expYear;
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
}
