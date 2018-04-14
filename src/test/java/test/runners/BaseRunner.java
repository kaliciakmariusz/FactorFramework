package test.runners;

import cucumber.api.testng.TestNGCucumberRunner;
import framework.base.BrowserType;
import framework.config.ConfigReader;
import framework.config.Settings;
import org.testng.annotations.*;

public class BaseRunner {

    protected TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite
    public void beforeSuite() {
        ConfigReader.populateSettings();
        setBrowserTypeFromConsole();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

    }

    @AfterSuite
    public void afterSuite() {
        testNGCucumberRunner.finish();
    }

    private void setBrowserTypeFromConsole() {
        if (System.getProperty("BrowserName") != null) {
            Settings.BrowserType = BrowserType.valueOf(System.getProperty("BrowserName").toLowerCase());
        }
    }
}