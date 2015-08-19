package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.pages.SignInModal;
import com.panerabread.auit.pages.WebUPageWithMenuFrame;
import com.panerabread.auit.pages.WebUSignInModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public abstract class WebUBasePageWithMenuFrame extends BasePage implements WebUPageWithMenuFrame {
	
	public WebUBasePageWithMenuFrame(AdvancedWebDriver driver) {
		super(driver);
	}
	
	private final String SIGN_IN="";
	
	public WebUSignInModal logIn() {
		driver().clickByCSS(this.SIGN_IN);
		return PageFactory.getWebUSignInModal(driver);
	}
}
