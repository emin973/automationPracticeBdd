package com.automationpractice.steps.contact_us;

import com.automationpractice.pages.contact_us.ContactUsPage;
import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonStep;
import com.automationpractice.utilities.TestDataGenerator;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUsSteps extends CommonStep {

	private ContactUsPage contactUsPage;
	
	public ContactUsSteps() {
		if ( contactUsPage == null ) 
			contactUsPage = new ContactUsPage(getDriver());
	}
	
	@When("User populates Contact Us form")
	public void user_populates_Contact_Us_form() {
		contactUsPage.selectSubjectHeading("Customer service");
		
		String firstName = TestDataGenerator.getRandomFirstName();
		String lastName = TestDataGenerator.getRandomLastName();
		contactUsPage.enterEmailAddress(TestDataGenerator.getRandomEmail(firstName, lastName));
		
		contactUsPage.enterOrderReference("randonText");
		contactUsPage.attachFile(System.getProperty("user.dir") + "/src/test/resources/files/Locators_table.pdf");
		contactUsPage.enterMessage(TestDataGenerator.getRandomText(301));
	}

	@When("User clicks on Send button")
	public void user_clicks_on_Send_button() {
		contactUsPage.clickSendButton();
	}

	@Then("User should view success message")
	public void user_should_view_success_message() {
		Common.failTest("testing failure");
		System.out.println("done");
	}
}