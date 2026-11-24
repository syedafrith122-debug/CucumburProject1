package org.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdefinition.GenrateReports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Feature",glue = "org.stepdefinition",
monochrome = true,dryRun = false,snippets = SnippetType.CAMELCASE,plugin = 
{"html:target/cucumber-reports/plumdeluxe.html"
		,"junit:target/cucumber-reports/plumdeluxe.xml",
		"json:target/cucumber-reports/plumdeluxe.json"})
public class TestRunner  extends GenrateReports{
	@AfterClass
	public static void reportCreate() {
		jvmScript("target/cucumber-reports/plumdeluxe.json");

	}

	

}
