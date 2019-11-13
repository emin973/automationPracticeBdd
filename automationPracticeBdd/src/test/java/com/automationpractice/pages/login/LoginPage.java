package com.automationpractice.pages.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;


public class LoginPage extends CommonPage {

	private static final int timeOutInSeconds = 15;
	private static final Logger logger = Logger.getLogger(LoginPage.class);
	private DriverHelper driverHelper = getDriverHelper();
	
	private By emailTextBox = By.id("email");
	private By passwordTextBox = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterEmail ( String email ) {
		driverHelper.sendKeys(emailTextBox, email, timeOutInSeconds);
		logger.info("Entered email as " + email);
	}
	
	public void enterPassword ( String password ) {
		driverHelper.sendKeys(passwordTextBox, password, timeOutInSeconds);
		logger.info("Entered password as " + password);
	}
	
	public void clickSignInButton () {
		driverHelper.click(signInButton, timeOutInSeconds);
		logger.info("Clicked on Sign In button");
	}
	
	public String getErrorMessage () {
		return driverHelper.getText(By.cssSelector(".alert-danger"), timeOutInSeconds);
	}
}