package com.automationpractice.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.automationpractice.utilities.CommonStep;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
			plugin = {
					"html:target/cucumber_report"
			},
			glue = {
					"com.automationpractice.steps"
			},
			features = {
					"src/test/resources/features/warm_up/warm_up.feature",
			},
			tags = {
					"@htmlFormSubmission"
			}
//			dryRun = true
		)
public class WarmUpTaskRunner extends CommonStep {
	@AfterClass
	public static void after () {
		closeDriver();
	}
}