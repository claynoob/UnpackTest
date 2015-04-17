package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.pages.OrderTimePage;
import com.panerabread.auit.pages.PageWithMenuFrame;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultOrderTimePage extends BasePage implements OrderTimePage {

	private final String NOW_RADIO_BTN = "#now",
			LATER_RADIO_BTN = "#later",
			TABLE_NUM = "#number",
			DEL_PHONE_NUM_FIELD = "#phoneNumber",
			START_ORDERING = ".btn-primary",
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
	public PageWithMenuFrame orderForLater(){
		driver().clickByCSS(this.LATER_RADIO_BTN);
		//Need to add ways to choose date and time
		return PageFactory.getLandingPage(driver());
	};
	public PageWithMenuFrame enterTableNumber(String tblNum){
		driver().findByCSS(TABLE_NUM).sendKeys(tblNum);
		driver().clickByCSS(START_ORDERING);
		return PageFactory.getLandingPage(driver());
	};
	
	public OrderTimePage enterPhoneNumber(String phoneNum){
		driver().findByCSS(DEL_PHONE_NUM_FIELD).sendKeys(phoneNum);
		driver().clickByCSS(this.CONTINUE);
		return PageFactory.getOrderTimePage(driver());
	};
	
	public OrderTimePage chooseDelAddressType(String addressType){
		driver().findByCSS(this.ADDRESS_TYPE).sendKeys(addressType);
		return PageFactory.getOrderTimePage(driver());
	}

}
