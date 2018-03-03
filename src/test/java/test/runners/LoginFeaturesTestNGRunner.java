package test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/test/java/test/features/Login.feature"},
        glue = {"test/steps"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"})
public class LoginFeaturesTestNGRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Login Feature", dataProvider = "features")
    public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper) {

        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
    }
}