@login
Feature: Login

  #	some text regarding you feature file
  #Gherkin Syntax
  #	given
  # Steps key words
  # Given, When, And, But, Then
  @smokeTest
  Scenario: User login validation
    Given User navigates to home page
    When User clicks on sign in link
    And User inputs email and password
    And User clicks sign in button
    Then User is on account page

  @negative
  Scenario: User login validation with invalid credentials
    Given User navigates to home page
    When User clicks on sign in link
    And User inputs "invalid" email and "invalid" password
    And User clicks sign in button
    Then User should see error message "Invalid email addresss."

  @negative @multipleExamples
  Scenario Outline: User login validation with invalid credentials
    Given User navigates to home page
    When User clicks on sign in link
    And User inputs "<email>" email and "<password>" password
    And User clicks sign in button
    Then User should see error message "<error message>"

    Examples: invalid credentials
      | email                 | password | error message          |
      | invalid               | invalid  | Invalid email address. |
      | abc213@mailinator.com | invalid  | Authentication failed  |
      | invalid               | abc1234  | Invalid email address. |
      
      
  @negative @wip
  Scenario: User login validation with invalid credentials
    Given User navigates to home page
    When User clicks on sign in link
		Then User inputs email, password and clicks sign in button and validate error message
    	| email                 | password | error message          |
      | invalid               | invalid  | Invalid email address. |
      | abc213@mailinator.com | invalid  | Authentication failed  |
      | invalid               | abc1234  | Invalid email address. |
    
    
    
    