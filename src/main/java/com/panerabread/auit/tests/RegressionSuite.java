package com.panerabread.auit.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

@RunWith(Suite.class)
@SuiteClasses({ HomepageRegression.class, 
	RegisteredUserNewUserRegression.class, 
	MenuValidation.class, 
	AccountManagement.class,
	CafeSearch.class,
	MenuValidationParamTests.class})
public class RegressionSuite {

	public static AdvancedWebDriver driver = null;
	{System.setProperty("environment","qarc");}

	@BeforeClass
	public static void startUp() {
		{System.setProperty("environment","qarc");}
	}
		
	@AfterClass 
	public static void tearDown() throws Exception { 
		driver.quit(); 
	}
}
