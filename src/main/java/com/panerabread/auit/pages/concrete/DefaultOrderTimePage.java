package com.panerabread.auit.pages.concrete;

import java.sql.Time;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Random;

import com.panerabread.auit.pages.OrderTimePage;
import com.panerabread.auit.pages.OrderTypeLocationPage;
import com.panerabread.auit.pages.PageWithMenuFrame;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultOrderTimePage extends BasePageWithMenuFrame implements OrderTimePage {

	private final String NOW_RADIO_BTN = "#now",
			LATER_RADIO_BTN = "#later",
			LATER_OPTION="return (function b(){ return (function a(ingredientId){ var foundIngredient= null; Array.prototype.slice.call(document.querySelectorAll('li')).forEach(function(ingredientPlacard) {if(ingredientPlacard.innerHTML.indexOf(ingredientId) > 0) {foundIngredient= ingredientPlacard;}}); return foundIngredient;})('%s')})();",
			TABLE_NUM = "#number", PREVIOUS="#nav-buttons > div:nth-child(1) > button:nth-child(1)",
			DEL_PHONE_NUM_FIELD = "#phoneNumber",
			START_ORDERING = "button.btn-primary",
			ADDRESS_TYPE="select.form-control",
			CONTINUE="input.btn";

	public DefaultOrderTimePage(AdvancedWebDriver driver) {
		super(driver);
	}

	public PageWithMenuFrame orderForASAP() {
		driver().clickByCSS(this.NOW_RADIO_BTN);
		driver().clickByCSS(this.START_ORDERING);
		return PageFactory.getLandingPage(driver());
	}
	
	public OrderTypeLocationPage returnToOrderTypeLocation() {
		driver().clickByCSS(this.PREVIOUS);
		return PageFactory.getOrderTypeLocationPage(driver());
	}
	
	public PageWithMenuFrame orderForLater(String date, String time, Boolean override){
		driver().clickByCSS(this.LATER_RADIO_BTN);
		if (override != true) {
			time = getTime(System.getProperty("menuCat"));
			System.out.println(time);
		}
		driver().clickByJavascript(String.format(this.LATER_OPTION, date));
		getDay(date);
		driver().clickByJavascript(String.format(this.LATER_OPTION, time));
		driver().clickByCSS(this.START_ORDERING);
		return PageFactory.getLandingPage(driver());
	};
	
	public PageWithMenuFrame getDay(String date) {
		String orderDate = driver().findByJavascript(String.format(this.LATER_OPTION, date)).getText();
		String[] dateInfo = orderDate.split(" ");
		String day = dateInfo[1];
		{System.setProperty("orderDay", day);}
		return this;
	}
	
	public String getTime(String menuCategory) {
		int hour = 0;
		int min = 0;
		System.out.println("Menu Category: " + menuCategory);
		if (menuCategory.equals("")) {
			hour = getRandomHour(21-6, 6);
			min = getRandomMinute(59, 0);
		}
		else {
			if (menuCategory.equalsIgnoreCase("Breakfast")) {
				hour = getRandomHour(10, 0);
				min = getRandomMinute(30, 0);
			}
			if (menuCategory.equalsIgnoreCase("Broth Bowls")) {
				hour = getRandomHour(21-10, 10);
				min = getRandomMinute(59-30, 30);
				
			}
			if (menuCategory.equalsIgnoreCase("Soups")) {
				hour = getRandomHour(21-10, 10);
				min = getRandomMinute(59-30, 30);
				
			}
		}
		DecimalFormat mFormat2= new DecimalFormat("00");
		String hh = mFormat2.format(Double.valueOf(hour));
		String mm = mFormat2.format(Double.valueOf(min));
		String time = hh + ":" + mm + " " + System.getProperty("dayTime");
		return time;
	}
	
	public int getRandomTime(int num) {
		Random r = new Random();
		int i = r.nextInt(num);
		System.out.println(num);
		System.out.println(i);
		return i;
	}
	
	public int getRandomMinute(int num, int num2) {
		String orderType = System.getProperty("orderType");
		Random r = new Random();
		int i = r.nextInt(num) + num2;
		int newNum = 0;
		if (orderType.equalsIgnoreCase("RPU")) {
			newNum = 5*(Math.round(i/5));
		}
		if(orderType.equalsIgnoreCase("Delivery")) {
			newNum = 15*(Math.round(i/15));
		}
		System.out.println(num);
		System.out.println(newNum);
		return newNum;
	}
	
	public int getRandomHour(int num, int num2) {
		Random r = new Random();
		{System.setProperty("dayTime", "AM");}
		int i = r.nextInt(num) + num2;
		System.out.println("Hour: " + i);
		if (i >= 12) {
			{System.setProperty("dayTime", "PM");}
		}
		if (i > 12) {
			i = i-12;
		}
		System.out.println(num);
		System.out.println(i);
		return i;
	}
	
	public PageWithMenuFrame orderForLater(int daysOut, String time, Boolean override) {
		String date = driver().getLaterDate(daysOut);
		if (date.startsWith("0")) {
			date.substring(2);
		}
		orderForLater(date, time, override);
		return PageFactory.getLandingPage(driver());
	}
	
	public OrderTimePage enterDeliveryInfo(String addressType, String phone) {
		chooseDelAddressType(addressType);
		enterPhoneNumber(phone);
		return this;
	}
	
	public PageWithMenuFrame enterTableNumber(String tblNum){
		driver().findByCSS(TABLE_NUM).sendKeys(tblNum);
		driver().clickByCSS(START_ORDERING);
		return PageFactory.getLandingPage(driver());
	};
	
	public OrderTimePage enterPhoneNumber(String phoneNum){
		driver().findByCSS(DEL_PHONE_NUM_FIELD).sendKeys(phoneNum);
		driver().clickByCSS(this.CONTINUE);
		return this;
	};
	
	public OrderTimePage chooseDelAddressType(String addressType){
		driver().findByCSS(this.ADDRESS_TYPE).sendKeys(addressType);
		return this;
	}

}
