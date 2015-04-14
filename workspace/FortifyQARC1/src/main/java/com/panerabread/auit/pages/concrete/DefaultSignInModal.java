package com.panerabread.auit.pages.concrete;

/*import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;*/

import org.openqa.selenium.By;

import com.panerabread.auit.pages.BasePage;
import com.panerabread.auit.pages.OrderTypeLocationPage;
import com.panerabread.auit.pages.SignInModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultSignInModal extends BasePage implements SignInModal {
	
	private final String ORDER_WITHOUT_SIGNIN = "button.btn-primary", USERNAME="#user",
			PASSWORD="#password", SIGNIN="input.btn", PHONE_MODAL=".modal-sm > div:nth-child(1)",
			SELECT_USER_PHONE_MODAL="return (function b(){ return (function a(userId){var selectedUser = null; Array.prototype.slice.call(document.querySelectorAll('.ng-binding')).forEach(function(user) {if(user.innerHTML.indexOf(userId) > 0) {selectedUser = user;}}); return selectedUser;}) ('Emma').parentElement.getElementsByClassName('check')[0]})();";
	/*@FindBy
	(how=How.CSS, using="#user")
	WebElement userNameInput;*/

	public DefaultSignInModal(AdvancedWebDriver driver) {
		super(driver);
	}

	public OrderTypeLocationPage orderAsGuest() {
		driver().clickByCSS(this.ORDER_WITHOUT_SIGNIN);
		return PageFactory.getOrderTypeLocationPage(driver());
	}

	public OrderTypeLocationPage signInWithPhone(String phone, String password, String accountFirstName) {
		driver().findByCSS(this.USERNAME).sendKeys(phone);
		driver().findByCSS(this.PASSWORD).sendKeys(password);
		driver().clickByCSS(this.SIGNIN);
		driver().pause(1000);
		if(driver().checkForElement(By.cssSelector(this.PHONE_MODAL))){
			driver().clickByJavascript(String.format(this.SELECT_USER_PHONE_MODAL,  accountFirstName));
			driver().clickByCSS(".col-xs-offset-10 > button:nth-child(1)");
		}
		driver().getState().put("signedIn", Boolean.toString(true));
		return PageFactory.getOrderTypeLocationPage(driver());
	}
	
	public OrderTypeLocationPage signIn(String user, String password) {
		driver().findByCSS(this.USERNAME).sendKeys(user);
		driver().findByCSS(this.PASSWORD).sendKeys(password);
		driver().clickByCSS(this.SIGNIN);
		driver().getState().put("signedIn", Boolean.toString(true));
		return PageFactory.getOrderTypeLocationPage(driver());
	}	
}
