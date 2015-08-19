package com.panerabread.auit.pages;

public class RegisterNewUserConfig {
			
	private String firstName, lastName, phone, email, address, city, state, zip, 
	username, password, passwordConfirm, loyaltyNum, regNum, month, date, year, emailOpt;
	
	public RegisterNewUserConfig(String today, String loyaltyNumber, String registrationNumber, String emailOptIn) {
		this.setFirstName("FortifyAuto" + today);
		this.setLastName("Stanfield" + today);
		this.setPhone("9122372905");
		this.setEmail("chaleystanfield" + today + "@gmail.com");
		this.setAddress("203 Mallard Dr");
		this.setCity("Glennville");
		this.setState("GA");
		this.setZip("30427");
		this.setUsername("FortifyAuto_" + today);
		this.setPassword("bread3");
		this.setPasswordConfirm("bread3");
		this.setLoyaltyNum(loyaltyNumber);
		this.setRegistrationNum(registrationNumber);
		this.setMonth("July");
		this.setDate("23");
		this.setYear("1993");
		this.setEmailOpt(emailOptIn);
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
		{System.setProperty("username", username);}
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
		
	public String getLoyaltyNum() {
		if (loyaltyNum != null) {
			return loyaltyNum;
		}
		return null;
	}
	
	public void setLoyaltyNum(String loyaltyNum) {
		this.loyaltyNum = loyaltyNum;
	}
	
	public String getRegistrationNum() {
		return regNum;
	}
	
	public void setRegistrationNum(String regNum) {
		this.regNum = regNum;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
		
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getEmailOpt() {
		return emailOpt;
	}
	
	public void setEmailOpt(String emailOpt) {
		this.emailOpt = emailOpt;
	}
	
}
