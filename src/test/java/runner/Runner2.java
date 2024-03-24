package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\eclips\\Cucumber\\src\\test\\resources\\features"},
glue = {"stepDefinition"},
tags = "@test",
plugin = {"pretty","html:target/cucumber-junit/report.html","json:target/cucumber-junit/report.json","junit:target/cucumber-junit/report.xml"}


		
		)

public class Runner2 {

}
