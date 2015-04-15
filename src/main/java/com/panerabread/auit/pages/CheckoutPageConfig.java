package com.panerabread.auit.pages;

public class CheckoutPageConfig {
	public final String	AMEX_TEST_NUMBER = "340000000000009";
	private String specialInstructions, specialcode, cardHolderName,
			cardNumber, email, phone, expireMonth, expireYear;
	private CardTypes cardType;

	public CheckoutPageConfig(CardTypes ccType, String ccNum) {
		this.setCardHolderName("Steven Seagull");
		this.setCardNumber(ccNum);
		this.setCardType(ccType);
		this.setExpireMonth("02");
		this.setExpireYear("2020");
		this.setEmail("chaley.stanfield@panerabread.com");
		this.setPhone("9122372317");
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

	public String getCardType() {
		if (cardType != null) {
			return cardType.name();
		}
		return null;
	}

	public void setCardType(CardTypes cardType) {
		this.cardType = cardType;
	}
}
