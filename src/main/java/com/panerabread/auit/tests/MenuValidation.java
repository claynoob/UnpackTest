package com.panerabread.auit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

public class MenuValidation {
	
	private AdvancedWebDriver driver = null;
	{System.setProperty("environment","qarc3");}
	
	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(5);
	}
	
		
	@After 
	public void tearDown() throws Exception { 
		//driver.quit(); 
	}
	
	@Test
	public void found9569() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForLater(2, "10:15 AM", false).clickCategoryPlacard("Broth Bowl Meal")
		.orderCombo("Soba Noodle Bowl with Chicken", "Half Asian Sesame Chicken Salad").goToCheckout().dismissAllModals()
		.payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
	
	@Test
	public void found9577() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForASAP().clickSidebarCategory("Pasta Meal")
		.orderCombo("Pesto Sacchettini", "Tomato Mozzarella").goToCheckout().dismissAllModals()
		.payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
	
	@Test
	public void found6790() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForASAP().clickSidebarCategory("Two Flatbreads")
		.orderCombo("Tomato Mozzarella Flatbread", "Mediterranean Chicken Flatbread").goToCheckout().dismissAllModals()
		.payWithCC(CardTypes.MAST, null, "manual", null, false); 
	}
	
	@Test
	public void found6814Salad() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForASAP().clickSidebarCategory("Salads")
		.orderItem("Thai Chicken Salad", true, "half").goToCheckout().dismissAllModals()
		.payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
	
	@Test
	public void found6814Sandwich() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForASAP().clickSidebarCategory("Panini &amp; Sandwiches")
		.orderItem("Tuna Salad Sandwich", true, "half").goToCheckout().dismissAllModals()
		.payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
	
	@Test
	public void found6814Panini() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForASAP().clickSidebarCategory("Panini &amp; Sandwiches")
		.orderItem("Smokehouse Turkey Panini", true, "half").goToCheckout().dismissAllModals()
		.payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
	
	@Test
	public void found6795() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
		.chooseCafe("63127", "600668").orderForASAP().clickCategoryPlacard("Bakery").orderItem("Plain Bagel", false, null)
		.goToCheckout().dismissAllModals().payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
	
	@Test
	public void found7088() {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("fortifyqaauto@gmail.com", "bread3")
		.chooseCafe("63127", "600668").orderForASAP().clickCategoryPlacard("Bakery").orderItem("Half Dozen Bagels", false, null)
		.goToCheckout().dismissAllModals().payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
		
	@Test
	public void found7120() throws Exception {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForLater(2, "10:15 AM", false).clickCategoryPlacard("Bakery").orderItem("Whole Grain", true, "Miche")
		.goToCheckout().dismissAllModals().payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
	
	@Test
	public void found7118() throws Exception {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForLater(2, "10:15 AM", false).clickCategoryPlacard("Bakery").orderItem("Asiago Cheese", true, "Demi")
		.goToCheckout().dismissAllModals().payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
	
	@Test
	public void found6793() throws Exception {
		PageFactory.getDefaultHomePage(driver).startRPUOrder().signIn("chaley.tester", "bread3").chooseCafe("63127", "600668")
		.orderForLater(2, "10:15 AM", false).clickCategoryPlacard("Bakery").orderItem("Asiago Cheese", true, "Loaf")
		.goToCheckout().dismissAllModals().payWithCC(CardTypes.MAST, null, "manual", null, false);
	}
}