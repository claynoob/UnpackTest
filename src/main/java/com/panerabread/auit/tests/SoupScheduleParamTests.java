package com.panerabread.auit.tests;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.csv.CSVRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;
import com.panerabread.auit.webdriverutils.CSVReader;

@RunWith(Parameterized.class)
public class SoupScheduleParamTests {
	
	private AdvancedWebDriver driver = null;
	private static String loginLocation = "C://Users//Onshore//Desktop//Data-Driven//SoupItemData.csv";
	{System.setProperty("environment","qarc");}

  @Parameters(name = "{0}")
  public static Collection<Object[]> soupData() throws IOException {
    return CSVReader.getData(loginLocation);
  }

  @Parameter(0)
  public CSVRecord soupInfo;
  
  @Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
	
		
	@After 
	public void tearDown() throws Exception { 
		driver.quit(); 
	}
  
  @Test
  public void test2() throws Exception {
	  PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").verifyLogin()
	  .chooseCafe("63127", "600668");
  }
}
  