package com.panerabread.auit.webdriverutils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DefaultAdvancedWebDriver implements WebDriver, AdvancedWebDriver {
	private WebDriver driver;

	private Map<String, String> state;
	
	public DefaultAdvancedWebDriver(WebDriver driver) {
		this.driver = driver;
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#wait(int)
	 */
	public void pause(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findByJavascript(java.lang.String)
	 */
	public WebElement findByJavascript(String script) {
		//System.out.println(script);
		WebElement result = (WebElement) ((JavascriptExecutor) driver).executeScript(script);
		int tries = 0;
		while (result == null && tries < 20) {
			pause(500);
			result = (WebElement) ((JavascriptExecutor) driver).executeScript(script);
			tries++;
		}
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#clickByJavascript(java.lang.String)
	 */
	public void clickByJavascript(String script) {
		findByJavascript(script).click();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#clickByCSS(java.lang.String)
	 */

	public void clickByCSS(String css) {
		WebElement element = findByCSS(css);
		element.click();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findByCSS(java.lang.String)
	 */
	
	public WebElement findByCSS(String css) {
		return getDriver().findElement(By.cssSelector(css));
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findByLinkText(java.lang.String)
	 */
	
	public WebElement findByLinkText(String partialText) {
		return getDriver().findElement(By.partialLinkText(partialText));
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#clickByLinkText(java.lang.String)
	 */
	
	public void clickByLinkText(String partialText) {
		findByLinkText(partialText).click();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#clickByXpath(java.lang.String)
	 */
	
	public void clickByXpath(String xpath) {
		findByXpath(xpath).click();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findByXpath(java.lang.String)
	 */
	
	public WebElement findByXpath(String xpath) {
		return getDriver().findElement(By.xpath(xpath));
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#checkForElement(org.openqa.selenium.By)
	 */
	
	public boolean checkForElement(By locator) {
		try {
			getDriver().findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#dropdownSelectByText(org.openqa.selenium.WebElement, java.lang.String)
	 */
	
	public void dropdownSelectByText(WebElement element, String visibleText) {
		if (visibleText != null) {
			new Select(element).selectByVisibleText(visibleText);
		}
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#close()
	 */
	
	public void close() {
		getDriver().close();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findElement(org.openqa.selenium.By)
	 */
	
	public WebElement findElement(By arg0) {
		return getDriver().findElement(arg0);
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#findElements(org.openqa.selenium.By)
	 */
	
	public List<WebElement> findElements(By arg0) {
		return getDriver().findElements(arg0);
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#get(java.lang.String)
	 */
	
	public void get(String arg0) {
		getDriver().get(arg0);
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#getCurrentUrl()
	 */
	
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#getPageSource()
	 */
	
	public String getPageSource() {
		return getDriver().getPageSource();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#getTitle()
	 */
	
	public String getTitle() {
		return getDriver().getTitle();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#getWindowHandle()
	 */
	
	public String getWindowHandle() {
		return getDriver().getWindowHandle();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#getWindowHandles()
	 */
	
	public Set<String> getWindowHandles() {
		return getDriver().getWindowHandles();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#manage()
	 */
	
	public Options manage() {
		return getDriver().manage();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#navigate()
	 */
	
	public Navigation navigate() {
		return getDriver().navigate();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#quit()
	 */
	
	public void quit() {
		getDriver().quit();
	}

	/* (non-Javadoc)
	 * @see com.panerabread.auit.webdriverutils.AdvancedWebDriver#switchTo()
	 */
	
	public TargetLocator switchTo() {
		return getDriver().switchTo();
	}

	private WebDriver getDriver() {
		return this.driver;
	}

	
	public Map<String, String> getState() {
		if(this.state== null){
			setState(new HashMap<String, String>());
		}
		return this.state;
	}

	private void setState(Map<String, String> hashMap) {
		this.state = hashMap;
	}
	/*public void waitForJQuery(WebDriver driver) {
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
		     public Boolean apply(WebDriver d) {
		     JavascriptExecutor js = (JavascriptExecutor) d;
		     return (Boolean) js.executeScript("return $.active == 0");
		     }
		 });
		 }*/
}
