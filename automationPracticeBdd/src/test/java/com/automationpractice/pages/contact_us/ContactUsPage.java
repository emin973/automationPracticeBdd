package com.automationpractice.pages.contact_us;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

/**
 * 
 * @author TechCenture
 *
 */
public class ContactUsPage extends CommonPage {
	
	private static final int timeOutInSeconds = 15;
	private static final Logger logger = Logger.getLogger(ContactUsPage.class);
	
	private WebDriver driver;
	private DriverHelper driverHelper = getDriverHelper();
	
	private By subjectHeadingDropdown = By.id("id_contact");
	private By emailAddressTextBox = By.id("email");
	private By orderReferenceTextBox = By.id("id_order");
	private By attachFileTextBox = By.id("fileUpload");
	private By messageTextBox = By.id("message");
	private By sendButton = By.id("submitMessage");
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		if ( this.driver == null) this.driver = driver;
	}
	
	public void selectSubjectHeading ( String subject ) {
		Select select = new Select(driver.findElement(subjectHeadingDropdown));
		select.selectByVisibleText(subject);
	}
	
	public void enterEmailAddress ( String email ) {
		driverHelper.sendKeys(emailAddressTextBox, email, timeOutInSeconds);
	}
	
	public void enterOrderReference ( String orderReference ) {
		driverHelper.sendKeys(orderReferenceTextBox, orderReference, timeOutInSeconds);
	}
	
	public void attachFile ( String filePath ) {
		driver.findElement(attachFileTextBox).sendKeys(filePath);
//		driverHelper.sendKeys(attachFileTextBox, filePath, timeOutInSeconds);
	}
	
	public void enterMessage ( String message ) {
		driverHelper.sendKeys(messageTextBox, message, timeOutInSeconds);
	}
	
	public void clickSendButton () {
		driverHelper.click(sendButton, timeOutInSeconds);
	}
}
