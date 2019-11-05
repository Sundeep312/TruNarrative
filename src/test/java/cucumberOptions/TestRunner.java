package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//to run with cucumber testrunner(Junit)
//@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/java/feature",
		glue="stepdefinition")

//to run with testNG xml file inheriting AbstractTestNGCucumberTests class
public class TestRunner extends AbstractTestNGCucumberTests{

}
