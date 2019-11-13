  
package com.automationpractice.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.automationpractice.utilities.CommonStep;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions (
			plugin = {
				"html:target/cucumber_report",
				"json:target/cucumber_report/cucumber.json",
				"rerun:target/rerun.txt"
			},
			features = {"src/test/resources/features"},
			glue = {"com.automationpractice.steps"},
			tags = {
					"@login", "@wip"//, "~@contactUs" //tilde to skip scenarios/features 
					},
			monochrome = true
//			, dryRun = true
			/*
			 * dryRun = true --> get step implementations 
			 * for unimplemented steps in feature file
			 */
		)
public class Runner extends CommonStep {
	@AfterClass
	public static void after () {
		closeDriver();
	}
}