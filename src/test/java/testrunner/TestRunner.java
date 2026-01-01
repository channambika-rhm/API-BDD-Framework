package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "stepdefinitions",
		snippets = SnippetType.CAMELCASE,
		dryRun = false, //true- Does not run code in real instead checks if each scenario step has matching step definition and gives missing step definition
		tags =  "",//"@smoke or @p1",//"not(@smoke or @p1)"
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class TestRunner {

}
