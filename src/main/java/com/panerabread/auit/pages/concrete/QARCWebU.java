package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.WebU;
import com.panerabread.auit.pages.WebUSignInModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class QARCWebU extends WebUBasePageWithMenuFrame implements WebU {
	public QARCWebU(AdvancedWebDriver driver){
		super(driver);
		driver().get("http://webuweb01-preprod.panerabread.com/en-us/home.html");
	}
	
	private final String SIGN_IN="#global-sign-in";
	
	public WebUSignInModal logIn() {
		driver().clickByCSS(this.SIGN_IN);
		return PageFactory.getWebUSignInModal(driver);
	}

}
