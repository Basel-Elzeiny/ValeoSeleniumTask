package runner;

import base.TestBase;
import io.cucumber.testng.CucumberOptions;

import java.io.IOException;

@CucumberOptions(features = "src/test/java/features/GoogleSearch.feature",glue = {"steps"}
        ,plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase {
    public TestRunner() throws IOException {
    }
}
