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
public class MenuValidationAfter1000ParamTests {
	
	private AdvancedWebDriver driver = null;
	private static String menuItemLocation = "C://Users//Onshore//Desktop//Data-Driven//TimeSpecificItemData.csv";
	//{System.setProperty("environment","qarc3");}

  @Parameters(name = "{0}")

  public static Collection<Object[]> menuItemData() throws IOException {
	  return CSVReader.getData(menuItemLocation);
  }

  @Parameter(0)
  public CSVRecord menuItemInfo;
  
  @Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
	
	@After 
	public void tearDown() throws Exception { 
		driver.quit(); 
	}
  
  @Test
  public void run() throws Exception {
	  {System.setProperty("menuCat", menuItemInfo.get(2));}
	  PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester","bread3").verifyLogin()
	  .chooseCafe("60515", "600701").orderForLater(1, "10:45 AM", true).clickCategoryPlacard(menuItemInfo.get(1))
	  .orderItem(menuItemInfo.get(3), false, null).goToCheckout().dismissAllModals()
	  .payWithCC(CardTypes.AMEX, null, "manual", null, false).verifySuccessfulOrder();
  }

}
  