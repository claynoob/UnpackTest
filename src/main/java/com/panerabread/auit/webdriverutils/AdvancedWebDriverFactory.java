package com.panerabread.auit.webdriverutils;

import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvancedWebDriverFactory {
		public static AdvancedWebDriver getFirefoxDriver(int waitTime){
		return new DefaultAdvancedWebDriver(new FirefoxDriver(), waitTime);
	}
}
