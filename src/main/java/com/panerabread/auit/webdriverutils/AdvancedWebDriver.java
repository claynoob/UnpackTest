package com.panerabread.auit.webdriverutils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;

public interface AdvancedWebDriver {

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#wait(int)
	 */
	public abstract void pause(int milliseconds);
	
	public abstract boolean checkPageTitle(String title);
	
	public boolean checkPageURL(String url);
		
	public abstract Map<String, String> getState();
	
	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findByJavascript(java.lang.String)
	 */
	public abstract WebElement findByJavascript(String script);
	
	public abstract Collection<Object[]> countByJavascript(String script);

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#clickByJavascript(java.lang.String)
	 */
	public abstract void clickByJavascript(String script);

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#clickByCSS(java.lang.String)
	 */
	public abstract void clickByCSS(String css);

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findByCSS(java.lang.String)
	 */
	public abstract WebElement findByCSS(String css);

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findByLinkText(java.lang.String)
	 */
	public abstract WebElement findByLinkText(String partialText);

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#clickByLinkText(java.lang.String)
	 */
	public abstract void clickByLinkText(String partialText);

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#clickByXpath(java.lang.String)
	 */
	public abstract void clickByXpath(String xpath);

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findByXpath(java.lang.String)
	 */
	public abstract WebElement findByXpath(String xpath);

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#checkForElement(org.openqa.selenium.By)
	 */
	public abstract boolean checkForElement(By locator);

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#dropdownSelectByText(org.openqa.selenium.WebElement, java.lang.String)
	 */
	public abstract void dropdownSelectByText(WebElement element,
			String visibleText);

	public abstract void close();

	public abstract WebElement findElement(By arg0);

	public abstract List<WebElement> findElements(By arg0);

	public abstract void get(String arg0);

	public abstract String getCurrentUrl();

	public abstract String getPageSource();

	public abstract String getTitle();

	public abstract String getWindowHandle();

	public abstract Set<String> getWindowHandles();

	public abstract Options manage();

	public abstract Navigation navigate();

	public abstract void quit();

	public abstract TargetLocator switchTo();	
	
	String getDate();
	
	String getTime();
	
	String getDateTime();

	String getDateTimeNumbers();
	
	String getLaterDate(int daysOut);
	
	String getDayOfWeek(String myDate) throws ParseException;
	
	void captureScreenshot() throws IOException;
}