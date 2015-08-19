package com.panerabread.auit.tests;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

@RunWith(Suite.class)
@SuiteClasses({ 
	HomepageRegression.class, 
	RegisteredUserNewUserRegression.class,
	MenuValidation.class,
	AccountManagement.class,
	CafeSearch.class,
	MenuValidationParamTests.class
	})

public class TestSuite {
	
	public static AdvancedWebDriver driver = null;
	
	@BeforeClass
	public static void startUp() {
		{System.setProperty("environment","qarc3");}
	}
	
	/*@Rule
	public TestRule watcher = new TestWatcher() {
	   protected void starting(Description description) {
	      System.out.println("Starting test: " + description.getMethodName());
	   }
	};*/
	
}
