package com.panerabread.auit.tests;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

@RunWith(Suite.class)
@SuiteClasses({ ProdSmokeValidation.class })
public class ProdSuite {
	
	public static AdvancedWebDriver driver = null;
	
	@BeforeClass
	public static void startUp() {
		{System.setProperty("environment","qarc");}
	}

}
