package com.panerabread.auit.tests;

import java.io.IOException;

import javax.imageio.IIOException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.panerabread.auit.pages.CardTypes;
import com.panerabread.auit.pages.concrete.PageFactory;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;
import com.panerabread.auit.webdriverutils.AdvancedWebDriverFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdSmokeValidation {
	
	private AdvancedWebDriver driver = null;
	{System.setProperty("environment","qarc");}
	String username = System.getProperty("username");
		
	@Before
	public void startUp() {
		driver = AdvancedWebDriverFactory.getFirefoxDriver(6);
	}
		
	@After 
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
	@Test
	public void test1Step1() throws IOException {
		PageFactory.getDefaultHomePage(driver).registerNewUserOpt().registerNewUser(null, null, "Yes")
		.manageMyAccount().goToMyCards().storeCreditCardOpt(CardTypes.MAST).updateAccountInfoOpt()
		.updateAccountInfo().signOut();
	}

	@Test
	public void test2Step2() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn(username, "bread3").verifyLogin()
		.updateAccountInfoOpt().updateEmail("chaley.stanfield@panerabread.com");
	}
	
	@Test
	public void test3Steps3_18() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").verifyLogin()
		.goToHomePage().startRPUOrder().signIn(null, null).chooseCafe("29730", "600849").returnToOrderTypeLocation()
		.chooseCafe("63127", "600668").orderForLater(3, "08:00 AM", false).changeCafeAddress().chooseDelivery()
		.enterDeliveryAddress("1400 Butterfield Road, Downers Grove, IL 60515").enterDeliveryInfo("Home", "9126544598")
		.orderForLater(3, "09:00 AM", false).clickCategoryPlacard("Soups and Mac &amp; Cheese").captureScreenshot()
		.clickSidebarCategory("Breakfast").captureScreenshot().clickSidebarCategory("My Past Orders").captureScreenshot()
		.clickSidebarCategory("Beverages").orderItem("Bottled Water", false, null).clickSidebarCategory("You Pick Two")
		.customizeYP2Pick1("Panini &amp; Sandwiches", "Half Frontega Chicken Panini")
		.modifyComboItem("Toppings", new String[] {"Cucumber"}).updateItem()
		.customizeYP2Pick2("Flatbreads", "Mediterranean Chicken Flatbread")
		.modifyComboItem("Condiments", new String[] {"BBQ Ranch", "Basil Pesto"})//.addSpecialInstructions(null, "PROD TEST")
		.updateItem().orderCustYP2().clickSidebarCategory("My Rewards").chooseReward("Free Salad")
		.orderItem("Thai Chicken Salad", false, null).goToCheckout().selectBakeryItems("Chocolate Chipper Cookie")
		.dismissBakeryUpsellModal()
		.deleteItem(true, "You Pick 2", true)
		.deleteItem(false, "Thai Chicken Salad", true)
		.deleteItem(false, "Chocolate Chipper Cookie", true)
		.duplicateItem(false, "Bottled Water")
		.duplicateItem(false, "Bottled Water")
		.duplicateItem(false, "Bottled Water") 
		//.verifyItemPrice("Chocolate Chipper Cookie", 0.99f)
		.payWithCC(CardTypes.MAST, null, "manual", null, true).verifySuccessfulOrder();
	}
	
	@Test
	public void test4Tests9And20() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders").reorderPastOrder(System.getProperty("fulfillmentDate"), System.getProperty("total"));
	}
	
	@Test
	public void test5Steps23_29() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders")
		.verifyPastOrderDoesNotDisplay(System.getProperty("date"), System.getProperty("total")).goToMyCards()
		.deleteCard("Mike Byson", "MAST 0004", "Exp 02/20", true).goToHomePage().startRPUOrder().signIn(null, null)
		.chooseCafe("63028", "601044").orderForLater(5, "11:00 AM", false).clickCategoryPlacard("Salads")
		.orderItem("Thai Chicken Salad", false, null).orderItem("Chicken Caesar Salad", false, null).clickSidebarCategory("Panini &amp; Sandwiches")
		.orderItem("Italian Combo Sandwich", false, null).orderItem("Tuna Salad Sandwich", false, null).clickSidebarCategory("Beverages")
		.orderItem("Frozen Caramel", false, null).orderItem("Lemonade", false, null).orderItem("Cappuccino", false, null).clickSidebarCategory("Bakery")
		.orderItem("Bear Claw", false, null).orderItem("Pecan Roll", false, null).orderItem("Chocolate Chip Muffie", false, null).orderItem("Orange Scone", false, null)
		.goToCheckout().dismissAllModals().verifyItemPrices().verifyCardNotInDropDown("MAST 5426")
		.payWithGCAndCC("6006491611999952725", "manual", false, CardTypes.VISA, null, "manual", null, true);
	}
	
	@Test
	public void test6Step31() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders").checkForPastOrder(System.getProperty("date"), System.getProperty("total"));
	}
	
	@Test
	public void test7Step34() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders")
		.verifyPastOrderDoesNotDisplay(System.getProperty("date"), System.getProperty("total")).goToHomePage()
		.startRPUOrder().signIn(null, null).chooseCafe("63127", "600668").orderForLater(7, "3:00 PM", false)
		.clickCategoryPlacard("Beverages").orderItem("Bottled Water", false, null).goToCheckout()
		.dismissAllModals().verifyCardDisplaysInDropDown("MAST 0004")
		.payWithGC("6006491611999952766", "manual", false);
	}
	
	@Test
	public void test8Step41() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders").checkForPastOrder(System.getProperty("date"), System.getProperty("total"));
	}
	
	
	/*@Test
	public void test1() throws Exception {
		PageFactory.getDefaultHomePage(driver).startDineInOrder().signIn("chaley.tester", "bread3").chooseCafe("29730", 600849)
		.enterTableNumber("23").clickCategoryPlacard("Pastas").orderItem(new String[] {"Chicken Tortellini Alfredo"}).goToCheckout()
		.dismissAllModals().payWithCC(CardTypes.DISC, null, "manual", null, false).getOrderInfo();
		.goToHomePage().startRPUOrder()
		.signIn(null, null).chooseCafe("63127", 600668).orderForASAP()
		.clickSidebarCategory("My Past Orders").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders").checkForPastOrder(System.getProperty("date"), System.getProperty("total"))
		.reorderPastOrder(System.getProperty("date"), System.getProperty("total"));
		
	}
	
	@Test
	public void test2() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").goToBrowseOurMenu()
		.clickSidebarCategory("My Past Orders").reorderPastOrder(System.getProperty("date"), System.getProperty("total"));
	}
	
	
	@Test
	public void test() throws Exception {
		PageFactory.getDefaultHomePage(driver).logIn().signIn("chaley.tester", "bread3").verifyLogin()
		.goToHomePage().startRPUOrder().signIn(null, null).chooseCafe("02215", 202103).prodOrderForLater(3, "08:00 AM")
		.clickSidebarCategory("My Rewards").chooseReward("Free Salad").orderItem("Thai Chicken Salad")
		.clickSidebarCategory("Beverages").orderItem("Bottled Water").goToCheckout().selectBakeryItems("Chocolate Chipper Cookie")
		.dismissBakeryUpsellModal().deleteItem(false, "Thai Chicken Salad", true).verifyItemPrice("Chocolate Chipper Cookie", 0.99f);
	}*/
		
}