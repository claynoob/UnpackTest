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
public class AdHocParamTests {
	
	private AdvancedWebDriver driver = null;
	//private static String param1Location = "C://Users//Onshore//Desktop//Data-Driven//CafeSelection.csv";
	private static String param2Location = "C://Users//Onshore//Desktop//Data-Driven//PhysicalLoyaltyNumData.csv";
	{System.setProperty("environment","qarc");}

  @Parameters(name = "{0}")

  /*public static Collection<Object[]> cafeData() throws IOException {
	  return CSVReader.getData(param1Location);  
  }*/

  public static Collection<Object[]> loginData() throws IOException {
	  return CSVReader.getData(param2Location);
  }

  @Parameter
  //public CSVRecord param1Info;
  public CSVRecord param2Info;
  
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
	  System.out.println("Testing number: " + param2Info.get(1));
	  PageFactory.getDefaultHomePage(driver).registerNewUserOpt().registerNewUser(param2Info.get(1), param2Info.get(2), null);
  }
}
  