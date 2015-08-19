package com.panerabread.auit.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class AccountManagement {

	private AdvancedWebDriver driver = null;
	//{System.setProperty("environment","qarc");}
	
	
	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
	
		
	@After 
	public void tearDown() throws Exception { 
		driver.quit(); 
	}
		
	@Test
	public void found7244() {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToMyPhoneNumbers()
		.addNewPhone()
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/account/my_phone_numbers");
	}
	
	@Test
	public void found7230() {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToMyPhoneNumbers()
		.addNewPhone().deletePhone()
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/account/my_phone_numbers");
	}
	
	@Test
	public void found7228() {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToMyPhoneNumbers()
		.addNewPhone().setDefaultPhoneNum()
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/account/my_phone_numbers");
	}
	
	@Test
	public void found7233() throws IOException {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToMyPhoneNumbers()
		.addNewPhone().editPhoneOpt();
	}
}
