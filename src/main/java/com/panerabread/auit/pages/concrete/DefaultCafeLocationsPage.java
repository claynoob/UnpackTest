package com.panerabread.auit.pages.concrete;

import org.junit.Assert;

import com.panerabread.auit.pages.CafeLocationsPage;
import com.panerabread.auit.webdriverutils.AdvancedWebDriver;

public class DefaultCafeLocationsPage extends BasePageWithMenuFrame implements CafeLocationsPage {
	
	public final String NO_CAFES="span.no-cafes";

	public DefaultCafeLocationsPage(AdvancedWebDriver driver) {
		super(driver);
	}
	
}
