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

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;
import com.panerabread.auit.webdriverutils.CSVReader;

@RunWith(Parameterized.class)
public class CafeSelectionParamTests {
	
	private AdvancedWebDriver driver = null;
	private static String cafeSelectionLocation = "C://Users//Onshore//Desktop//Data-Driven//CafeSelection.csv";
	{System.setProperty("environment","qarc");}

  @Parameters(name = "{0}")

  public static Collection<Object[]> cafeData() throws IOException {
	  return CSVReader.getData(cafeSelectionLocation);
  }

  @Parameter(0)
  public CSVRecord cafeInfo;
  
  @Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
	
	@After 
	public void tearDown() throws Exception { 
		driver.quit(); 
	}
  
  @Test
  public void test() throws Exception {
	  PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester","bread3").verifyLogin()
	  .chooseCafe(cafeInfo.get(0), cafeInfo.get(1)).orderForLater(1, "10:15 AM", false);
  }
}
  