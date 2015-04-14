package com.panerabread.auit.webdriverutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvancedWebDriverFactory {
		public static AdvancedWebDriver getFirefoxDriver(int waitTime){
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		return new DefaultAdvancedWebDriver(new FirefoxDriver());
	}

}
