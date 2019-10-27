Feature: Login
# some text regarding you feature file


#Gherkin Syntax

Scenario: User login validation
	Given user navigates to home page
	When User clicks on sign in
	And User inputs email and password
	And User clicks on sign in button
	Then User is on account page
	And New feature validation
	#Steps key words
	#Given, When, And, But, Then