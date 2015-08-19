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
public class ComboParamTests {
	
	private AdvancedWebDriver driver = null;
	{System.setProperty("environment","qarc");}
	private static String menuItemLocation = "C://Users//Onshore//Desktop//Data-Driven//YP2ComboData.csv";

  @Parameters(name = "{0}")

  public static Collection<Object[]> menuItemData() throws IOException {
	  Collection<Object[]> test = CSVReader.getData(menuItemLocation);
	  return test;
  }

  @Parameter
  public CSVRecord menuItemInfo;
  
  @Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
	
	@After 
	public void tearDown() throws Exception { 
		//driver.quit(); 
	}
  
  @Test
  public void test() throws Exception {
	  System.out.println("Category: " + menuItemInfo.get(0) + " Pick 1: " + menuItemInfo.get(1) + " Pick 2: " + menuItemInfo.get(2));
	  PageFactory.getDefaultHomePage(driver).startRPUOrder().orderAsGuest()
	  .chooseCafe("60515", "600701").orderForLater(1, "10:20 AM", false).clickCategoryPlacard(menuItemInfo.get(0))
	  .comboOrder(menuItemInfo.get(1), menuItemInfo.get(2))
	  .goToCheckout()//.dismissAllModals().payWithCC(CardTypes.DISC, null, "manual", null, false)
	  ;
	  driver.quit();
	  }
}
  