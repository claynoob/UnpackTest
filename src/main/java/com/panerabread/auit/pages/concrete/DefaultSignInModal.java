package com.panerabread.auit.pages.concrete;

import com.panerabread.auit.pages.SignInModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultSignInModal extends BasePageWithMenuFrame implements SignInModal {
	
	public DefaultSignInModal(AdvancedWebDriver driver) {
		super(driver);
	}
	
	/*private final String SIGN_IN_MODAL="#login-modal", ORDER_WITHOUT_SIGNIN = "button.btn-primary", USERNAME="#user",
			PASSWORD="#password", SIGNIN="input.btn", PHONE_MODAL=".modal-sm > div:nth-child(1)",
			SELECT_USER_PHONE_MODAL="return (function b(){ return (function a(userId){var selectedUser = null; Array.prototype.slice.call(document.querySelectorAll('label')).forEach(function(user) {if(user.innerHTML.indexOf(userId) > 0) {selectedUser = user;}}); return selectedUser;}) ('%s').parentElement.getElementsByClassName('check')[0]})();";
	
	@FindBy
	(how=How.CSS, using="#user")
	WebElement userNameInput;

	public DefaultSignInModal(AdvancedWebDriver driver) {
		super(driver);
	}
	
	public OrderTypeLocationPage DataSignIn() throws Exception {
		//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
		String sUserName = ExcelUtils.getCellData(1, 1);
		String sPassword = ExcelUtils.getCellData(1, 2);
		driver().findByCSS(this.USERNAME).sendKeys(sUserName);
		driver().findByCSS(this.PASSWORD).sendKeys(sPassword);
		driver().clickByCSS(this.SIGNIN);
		verifyLogin();
	    return PageFactory.getOrderTypeLocationPage(driver());
    }
	
	public OrderTypeLocationPage orderAsGuest() {
		driver().clickByCSS(this.ORDER_WITHOUT_SIGNIN);
		return PageFactory.getOrderTypeLocationPage(driver());
	}

	public OrderTypeLocationPage signInWithPhone(String phone, String password, String accountFirstName) {
		if (checkForSignInModal() == true) {
		driver().findByCSS(this.USERNAME).sendKeys(phone);
		driver().findByCSS(this.PASSWORD).sendKeys(password);
		driver().clickByCSS(this.SIGNIN);
		driver().pause(1000);
		if(driver().checkForElement(By.cssSelector(this.PHONE_MODAL))){
			driver().clickByJavascript(String.format(this.SELECT_USER_PHONE_MODAL,  accountFirstName));
			driver().clickByCSS(".col-xs-offset-10 > button:nth-child(1)");
		}
		driver().getState().put("signedIn", Boolean.toString(true));
		}
		driver().pause(1000);
		return PageFactory.getOrderTypeLocationPage(driver());
	}
	
	public OrderTypeLocationPage signIn(String user, String password) {
		if (checkForSignInModal() == true) {
		driver().findByCSS(this.USERNAME).sendKeys(user);
		driver().findByCSS(this.PASSWORD).sendKeys(password);
		driver().clickByCSS(this.SIGNIN);
		driver().getState().put("signedIn", Boolean.toString(true));
		}
		driver().pause(1000);
		return PageFactory.getOrderTypeLocationPage(driver());
	}	
	
	public Boolean checkForSignInModal() {
		boolean isPresent = driver().checkForElement(By.cssSelector(this.SIGN_IN_MODAL));
		return isPresent;
	}*/
}
