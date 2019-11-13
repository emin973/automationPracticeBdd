package com.automationpractice.steps.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import org.openqa.selenium.WebDriver;

import com.automationpractice.pages.login.LoginPage;
import com.automationpractice.pages.my_account.MyAccountPage;
import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonStep;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonStep {
	
	private WebDriver driver = getDriver();
	private LoginPage loginPage = new LoginPage(driver);
	private MyAccountPage myAccountPage = new MyAccountPage(driver);

	@Given("User navigates to home page")
	public void user_navigates_to_home_page() {
		
	}

	@And("User inputs email and password")
	public void user_inputs_email_and_password() {
		String email = "abc213@mailinator.com";
		String password = "abc1234";
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
	}

	@When("User clicks sign in button")
	public void user_clicks_sign_in_button() {
		loginPage.clickSignInButton();
	}

	@When("User is on account page")
	public void user_is_on_account_page() {
		String actualHeader = myAccountPage.getHeader();
		assertEquals("MY ACCOUNT", actualHeader);
	}
	
	@When("User inputs {string} email and {string} password")
	public void user_inputs_and(String email, String password) {
	    loginPage.enterEmail(email);
	    loginPage.enterPassword(password);
	}

	@Then("User should see error message {string}")
	public void user_should_see_error_message(String errorMessage) {
	   String actualErrorMessage = loginPage.getErrorMessage();
	   assertTrue("Error message: Actual - " + actualErrorMessage + ", Expected - " + errorMessage,
			   actualErrorMessage.contains(errorMessage));
	}
	
	@When("User inputs email, password and clicks sign in button and validate error message")
	public void user_inputs_email_password_and_clicks_sign_in_button_and_validate_error_message( DataTable dataTable ) {
		List<Map<String, String>> listOfRows = dataTable.asMaps(String.class, String.class);
		
		for ( int row = 0; row < listOfRows.size(); row++ ) {
			String email = listOfRows.get(row).get("email");
			
			user_inputs_and(email, listOfRows.get(row).get("password"));
			user_clicks_sign_in_button();
			user_should_see_error_message(listOfRows.get(row).get("error message"));
			
			Common.sleep(2);
		}
	}
}
