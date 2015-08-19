package com.panerabread.auit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class CafeSearch {
	
	private AdvancedWebDriver driver = null;
	{System.setProperty("environment","qarc");}

	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
		
	@After 
	public void tearDown() throws Exception { 
		driver.quit(); 
	}

	@Test
	public void found7128Registered() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForASAP().goToCafeLocations().verifyNoCafeResults();
	}
	
	@Test
	public void found7128Anon() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().orderAsGuest().chooseCafe("63127", "600668")
		.orderForASAP().goToCafeLocations().verifyNoCafeResults();
	}
	
	@Test
	public void found7127Registered() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("Lily_Coton", "bread3").chooseCafe("60515", "600701")
		.enterTableNumber("23").goToCafeLocations().verifyNoCafeResults();
	}
	
	@Test
	public void found7127Anon() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().orderAsGuest().chooseCafe("60515", "600701")
		.enterTableNumber("23").goToCafeLocations().verifyNoCafeResults();
	}

	@Test
	public void found7136Registered() {
		PageFactory.getDefaultHomePage(driver).startDeliveryOrder().signIn("sodapoppin", "bread3")
		.enterDeliveryAddress("2125 S Hurstbourne Pkwy, Louisville, KY 40220").enterDeliveryInfo("Home", "9126544598")
		.orderForLater(2, "09:30 AM", false).goToCafeLocations().verifyNoCafeResults();
	}
	
	@Test
	public void found7136Anon() {
		PageFactory.getDefaultHomePage(driver).startDeliveryOrder().orderAsGuest()
		.enterDeliveryAddress("2125 S Hurstbourne Pkwy, Louisville, KY 40220").enterDeliveryInfo("Home", "9126544598")
		.orderForLater(2, "09:30 AM", false).goToCafeLocations().verifyNoCafeResults();
	}
	
	@Test
	public void found7158Registered() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("chaley.tester", "bread3").chooseCafe("29730", "600849")
		.enterTableNumber("2").goToHomePage().startRPUOrder().verifyNoCafeResults();
	}
	
	@Test
	public void found7158Anon() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().orderAsGuest().chooseCafe("29730", "600849")
		.enterTableNumber("2").goToHomePage().startRPUOrder().verifyNoCafeResults();
	}
	
	@Test
	public void found7157Registered() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("60515", "600701")
		.orderForASAP().goToHomePage().startDineInOrder().verifyNoCafeResults();
	}
	
	@Test
	public void found7157Anon() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().orderAsGuest().chooseCafe("60515", "600701")
		.orderForASAP().goToHomePage().startDineInOrder().verifyNoCafeResults();
	}
	
	@Test
	public void found7156Registered() {
		PageFactory.getDefaultHomePage(driver).startDeliveryOrder().signIn("sodapoppin", "bread3")
		.enterDeliveryAddress("2125 S Hurstbourne Pkwy, Louisville, KY").enterDeliveryInfo("Work", "9122372317")
		.orderForASAP().goToHomePage().startRPUOrder().verifyNoCafeResults();
	}
	
	@Test
	public void found7156Anon() {
		PageFactory.getDefaultHomePage(driver).startDeliveryOrder().orderAsGuest()
		.enterDeliveryAddress("2125 S Hurstbourne Pkwy, Louisville, KY").enterDeliveryInfo("Work", "9122372317")
		.orderForASAP().goToHomePage().startRPUOrder().verifyNoCafeResults();
	}

	@Test
	public void found7195RPURegistered() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("Stanley_Collie", "bread3")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/orderProcess/").verifyNoCafeResults();
	}
	
	@Test
	public void found7195RPUAnon() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().orderAsGuest()
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/orderProcess/").verifyNoCafeResults();
	}

	@Test
	public void found6192() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("Owl_Roker", "bread3")
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/orderProcess/").verifyNoCafeResults();
	}
	
	@Test
	public void found6191() {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().orderAsGuest()
		.verifyPageURL("https://delivery1-qarc.panerabread.com/#!/orderProcess/").verifyNoCafeResults();
	}

}
