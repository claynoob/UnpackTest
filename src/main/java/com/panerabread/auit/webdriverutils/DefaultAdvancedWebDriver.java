package com.panerabread.auit.webdriverutils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

public class DefaultAdvancedWebDriver implements WebDriver, AdvancedWebDriver {
	private WebDriver driver;

	private Map<String, String> state;
	
	/*public DefaultAdvancedWebDriver(WebDriver driver) {
		this(driver);
	}*/
	
	public DefaultAdvancedWebDriver(WebDriver driver, int implicitWait){
		this.driver = driver;
		getDriver().manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
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
	
	public Collection<Object[]> countByJavascript(String script) {
		//System.out.println(script);
		Collection<Object[]> result = (Collection<Object[]>) ((JavascriptExecutor) driver).executeScript(script);
		int tries = 0;
		while (result == null && tries < 20) {
			pause(500);
			result = (Collection<Object[]>) ((JavascriptExecutor) driver).executeScript(script);
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
	
	public boolean checkPageTitle(String title) {
		boolean pageTitle = false;
		if (getTitle().contentEquals(title)) {
			pageTitle = true;
		}
		return pageTitle;
	}
	
	public boolean checkPageURL(String url) {
		boolean pageURL = false;
		if (getCurrentUrl().contentEquals(url)) {
			pageURL = true;
		}
		return pageURL;
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
	
	public String getLaterDate(int daysOut) {
		DecimalFormat mFormat= new DecimalFormat("0");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, daysOut);
		int dd = c.get(Calendar.DATE);
		int mm = c.get(Calendar.MONTH)+1;
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String year = sdf.format(Calendar.getInstance().getTime());
		DecimalFormat mFormat2= new DecimalFormat("00");
		String m = mFormat2.format(Double.valueOf(mm));
		String d = mFormat2.format(Double.valueOf(dd));
		String fulfillDate = m + "." + d + "." + year;
		String month = mFormat.format(Double.valueOf(mm));
		String day = mFormat.format(Double.valueOf(dd));
		String today = month+'/'+ day;
		{System.setProperty("fulfillmentDate", fulfillDate);}
		return today;
	}
	
	public String getDayOfWeek(String myDate) throws ParseException {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(myDate);
		//System.out.println(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		String sDate = new SimpleDateFormat("EE").format(dayOfWeek);
		System.out.println("Day of Week: " + sDate);
		return sDate;
	}
	
	public String getDate() {
		Calendar c = Calendar.getInstance();
		int dd = c.get(Calendar.DATE);
		int mm = c.get(Calendar.MONTH)+1;
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String year = sdf.format(Calendar.getInstance().getTime());
		DecimalFormat mFormat= new DecimalFormat("00");
		String month = mFormat.format(Double.valueOf(mm));
		String day = mFormat.format(Double.valueOf(dd));
		String today = month+'.'+day+'.'+year;
		return today;
	}
	
	public String getTime() {
		Calendar c = Calendar.getInstance();
		int hh = c.get(Calendar.HOUR_OF_DAY);
		int mm = c.get(Calendar.MINUTE);
		int ss = c.get(Calendar.SECOND);
		DecimalFormat mFormat= new DecimalFormat("00");
		String hour = mFormat.format(Double.valueOf(hh));
		String minutes = mFormat.format(Double.valueOf(mm));
		String seconds = mFormat.format(Double.valueOf(ss));
		String time = hour + ':' + minutes + ':' + seconds;
		return time;
	}
	
	public String getDateTime() {
		String dateTime = getDate() + "_" + getTime();
		return dateTime;
	}
	
	public String getDateTimeNumbers() {
		String dateTime = getDateTime().replaceAll(":", "");
		return dateTime;
	}
	

	public void captureScreenshot() throws IOException {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		String location = "C://Users//Onshore//Desktop//AutomationScreenshots";
		FileUtils.copyFileToDirectory(screenshot, new File(location));
		System.out.println("Screenshot captured");
	}
		
}
