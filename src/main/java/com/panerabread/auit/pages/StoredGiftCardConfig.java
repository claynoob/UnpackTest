package com.panerabread.auit.pages;

public class StoredGiftCardConfig {
	
	private String nickname, number;
	
	public StoredGiftCardConfig(String today){
		this.setNickname("Chaels" + today);
		this.setCardNumber("6006491611999952758");
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getCardNumber() {
		return number;
	}
	
	public void setCardNumber(String number) {
		this.number = number;
	}

}
