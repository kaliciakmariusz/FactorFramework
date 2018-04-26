package test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/test/java/test/features/Login.feature"},
        glue = {"test/steps"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"})
public class LoginFeaturesTestNGRunner extends BaseRunner {

    @Test(groups = "cucumber", description = "Runs Cucumber Login Feature", dataProvider = "features")
    public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper) {

        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

}