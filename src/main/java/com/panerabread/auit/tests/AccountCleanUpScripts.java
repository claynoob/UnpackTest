package com.panerabread.auit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class AccountCleanUpScripts {
	
	private AdvancedWebDriver driver = null;
	{System.setProperty("environment","qarc3");}
	
	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
		
	@After 
	public void tearDown() throws Exception { 
		driver.quit(); 
	}
	
	@Test
	public void deleteTestCCs() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToMyCards().deleteTestCards();
	}

}