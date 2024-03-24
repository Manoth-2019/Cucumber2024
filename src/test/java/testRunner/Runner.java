package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		
		features = {"C:\\eclips\\Cucumber\\src\\test\\resources\\features\\"},
		dryRun =!true,
		glue = {"stepDefinition","hooks"},
		snippets = io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-TestNG/report.html",
				"json:target/cucumber-TestNG/report.json","junit:target/cucumber-TestNG/report.xml"},
		tags = "@demo"
		
		)


public class Runner extends AbstractTestNGCucumberTests {
	
	
}
