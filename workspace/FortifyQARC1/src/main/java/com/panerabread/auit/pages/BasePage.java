package com.panerabread.auit.pages;

import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class BasePage {

	protected AdvancedWebDriver driver;

	
	public BasePage(AdvancedWebDriver driver) {
		setDriver(driver);
	}

	public AdvancedWebDriver driver() {
		return driver;
	}

	private void setDriver(AdvancedWebDriver driver) {
		this.driver = driver;
	}
		
}