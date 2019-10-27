package com.automationpractice.login;

import org.openqa.selenium.By;

import com.automationpractice.utilities.AppProperties;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps {

	private int timeOutInSeconds = 15;

	@And("^User navigates to home page$")
	public void userNavigatesToHomePage() {
	}

	@When("User clicks on sign in link")
	public void user_clicks_on_sign_in_link() {
	}

	@And("User inputs email and password")
	public void user_inputs_email_and_password() {
	}

	@When("User clicks sign in button")
	public void user_clicks_sign_in_button() {
	}

	@When("User is on account page")
	public void user_is_on_account_page() {
		Assert.assertEquals("MY ACCOUNT", "");
	}
}