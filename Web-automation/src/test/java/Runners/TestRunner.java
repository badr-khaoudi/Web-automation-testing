package Runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@ExtendedCucumberOptions(retryCount = 3,
detailedReport = true,
detailedAggregatedReport = true,
overviewReport = true,
//coverageReport = true,
jsonUsageReport = "target/cucumber-usage.json",
usageReport = true,
toPDF = true,
excludeCoverageTags = {"@flaky" },
includeCoverageTags = {"@passed" },
outputFolder = "test-output")
@CucumberOptions(features="src/test/resources/Features"
,glue= {"StepDefinitions"}
,plugin= {
		"html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml","html:test-output"}
,dryRun = false,
monochrome=true,
tags = {"@SmokeTest"}
)
public class TestRunner {

	
}
