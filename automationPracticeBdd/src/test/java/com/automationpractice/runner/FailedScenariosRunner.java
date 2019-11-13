package com.automationpractice.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions (
			plugin = {
				"html:target/cucumber_report",
				"json:target/cucumber_report/cucumber.json"
//				"rerun:target/failed_scenarios/rerun.txt"
			},
			features = {"@target/rerun.txt"},
			glue = {"com.automationpractice.steps"}
		)
public class FailedScenariosRunner {}