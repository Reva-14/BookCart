package net.bookcart.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

	@RunWith(Cucumber.class)

	@CucumberOptions(features = "C:\\Users\\91917\\eclipse-workspace1\\bookcart\\src\\test\\resources\\feature",
						 glue = "net.bookcart.stepDefinition",
						 dryRun = !true,
		                 monochrome = true,
		                 snippets = SnippetType.CAMELCASE,
		                 plugin = {"pretty","html:target/html", "json:target/Reports.json"}
		                 )
	public class TestRunner {	
		
		}

