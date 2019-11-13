package com.automationpractice.steps;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.AppProperties;
import com.automationpractice.utilities.CommonStep;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

public class Hooks extends CommonStep {
	
	private static final Logger logger = Logger.getLogger(Hooks.class);
	private WebDriver driver = getDriver();
	
	/**
	 * Before annotation from cucumber runs before each Scenario
	 */
	@Before
	public void setUp () {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
	}
	
	/**
	 * After annotation from cucumber runs after each Scenario
	 */
	@After
	public void tearDown ( Scenario scenario ) {
		if ( scenario.isFailed() ) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			byte [] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
//		closeDriver();
	}
	
	@AfterStep
	public void afterStep ( Scenario scenario ) {
		if ( AppProperties.IS_EACH_STEP_SCREENSHOT ) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			byte [] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
	}
}
