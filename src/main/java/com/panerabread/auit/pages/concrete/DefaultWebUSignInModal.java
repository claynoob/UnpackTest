package com.panerabread.auit.pages.concrete;

/*import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;*/

import com.panerabread.auit.pages.WebUSignInModal;
import com.panerabread.auit.pages.WebUWelcomeModal;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultWebUSignInModal extends WebUBasePageWithMenuFrame implements WebUSignInModal {
	
	private final String USERNAME="#user_email", PASSWORD="#user_password", SIGNIN="#join-now-primary";
	
	/*@FindBy
	(how=How.CSS, using="#user")
	WebElement userNameInput;*/

	public DefaultWebUSignInModal(AdvancedWebDriver driver) {
		super(driver);
	}
	
	public WebUWelcomeModal signIn(String user, String password) {
		driver().findByCSS(this.USERNAME).sendKeys(user);
		driver().findByCSS(this.PASSWORD).sendKeys(password);
		driver().clickByCSS(this.SIGNIN);
		driver().getState().put("signedIn", Boolean.toString(true));
		return PageFactory.getWebUWelcomeModal(driver);
	}
}
