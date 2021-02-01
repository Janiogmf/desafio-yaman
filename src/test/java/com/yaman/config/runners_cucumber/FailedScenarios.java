package com.yaman.config.runners_cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, 
                 monochrome = true,
                 features = "@target/cucumber-reports/rerun.txt", // Cucumber cenarios com falha
                 glue = { "com.yaman.steps_definitions", "com.yaman.config.hooks" },
		         plugin = { "pretty", "json:target/cucumber-reports/cucumberRerun.json" }
		        )
public class FailedScenarios {

}
