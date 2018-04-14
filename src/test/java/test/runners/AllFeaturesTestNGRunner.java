package test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/test/java/test/features/"},
        glue = {"test/steps"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"})
public class AllFeaturesTestNGRunner extends BaseRunner{

    @Test(groups = "cucumber", description = "Runs Cucumber All Feature", dataProvider = "features")
    public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper) {

        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }
}