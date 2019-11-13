package com.automationpractice.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author TechCenture
 * 
 */
final class DriverFactory {
	
	private static Logger logger = Logger.getLogger(DriverFactory.class);
	private static WebDriver driver;
	
	static WebDriver getDriver () {
		System.out.println(driver);
		if ( driver == null ) driver = getActiveDriver();
		return driver;
//		return driver == null ? getActiveDriver() : driver;
	}
	
	static void closeDriver () {
		if ( driver != null ) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}
	
	private synchronized static WebDriver getActiveDriver () {
		String browserType = AppProperties.BROWSER_TYPE;
		switch ( browserType ) {
			case "chrome":
				driver = getChromeDriver();
				break;
			case "chrome-headless":
				driver = getHeadlessChromeDriver();
				break;
			case "firefox":
				driver = getFirefoxDriver();
				break;
			default: System.out.println("Browser type " + browserType + " invalid");
				break;
		}
		logger.info("Driver type set to " + browserType);
		return driver;
	}
	
	private static ChromeDriver getChromeDriver () {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
		crChromeOptions.addArguments("--start-maximized");
		return new ChromeDriver(crChromeOptions);
	}
	
	private static ChromeDriver getHeadlessChromeDriver () {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
		crChromeOptions.addArguments("--start-maximized");
		crChromeOptions.addArguments("--headless");
		return new ChromeDriver(crChromeOptions);
	}
	
	private static FirefoxDriver getFirefoxDriver () {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
}