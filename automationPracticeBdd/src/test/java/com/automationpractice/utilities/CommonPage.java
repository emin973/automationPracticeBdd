package com.automationpractice.utilities;

import org.openqa.selenium.WebDriver;

/**
 * Parent of all page object classes
 * 
 * @author TechCenture
 *
 */
public class CommonPage {

	private DriverHelper driverHelper;

	protected CommonPage(WebDriver driver) {
		if (driverHelper == null)
			driverHelper = new DriverHelper(driver);
	}

	protected DriverHelper getDriverHelper() {
		return driverHelper;
	}
}