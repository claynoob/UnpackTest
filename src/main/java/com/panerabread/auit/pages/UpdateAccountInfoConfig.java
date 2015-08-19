package com.panerabread.auit.pages;

public class UpdateAccountInfoConfig {
	
	private String firstName, lastName, phone, email, address, city, state, zip, 
	newPhoneName, newPhoneNum, storedPhoneNum, storedPhoneName;
	
	public UpdateAccountInfoConfig(String today) {
		this.setFirstName("UpdateTest");
		this.setLastName("UpdateTest");
		this.setPhone("9125576930");
		this.setEmail("chaley.stanfield" + today + "@gmail.com");
		this.setAddress("130 Lowes Boulevard");
		this.setCity("Lexington");
		this.setState("NC");
		this.setZip("27292");
		this.setNewPhoneName("test" + today);
		this.setNewPhoneNum("9126544575");
		this.setStoredPhoneName("chaley_test" + today);
		this.setStoredPhoneNum("9126937030");
	}
		
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStoredPhoneName() {
		return storedPhoneName;
	}
	
	public void setStoredPhoneName(String storedPhoneName) {
		this.storedPhoneName = storedPhoneName;
	}

	public String getStoredPhoneNum() {
		return storedPhoneNum;
	}
	
	public void setStoredPhoneNum(String storedPhoneNum) {
		this.storedPhoneNum = storedPhoneNum;
	}

	public String getNewPhoneName() {
		return newPhoneName;
	}
	
	public void setNewPhoneName(String newPhoneName) {
		this.newPhoneName = newPhoneName;
		{System.setProperty("phoneName", newPhoneName);}
	}

	public String getNewPhoneNum() {
		return newPhoneNum;
	}
	
	public void setNewPhoneNum(String newPhoneNum) {
		this.newPhoneNum = newPhoneNum;
		{System.setProperty("phoneNum", newPhoneNum);}
	}

}
