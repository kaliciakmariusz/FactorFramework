package test.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.base.DriverContext;
import framework.base.FrameworkInitialize;
import framework.config.ConfigReader;
import framework.config.Settings;
import framework.tools.ScreenshotTool;

import java.io.IOException;

public class TestInitialize extends FrameworkInitialize {

    @Before
    public void initializeTest(Scenario scenario) {

        //initializeTest Config
        ConfigReader.populateSettings();

        //Logging
        startLogger(scenario.getName());
        info("Framework was initialized for scenario: " + scenario.getName());

        initalizeBrowser(Settings.BrowserType);
        info("Browser was initialized: " + Settings.BrowserType);

        //DriverContext.browser.maximize();
        //info("Browser window was maximalized");

        DriverContext.browser.setImplecityTime(Settings.BrowserImplicitlyTime);
        info("Browser implecity time was set: " + Settings.BrowserImplicitlyTime + "s");

        DriverContext.browser.deleteCookies();
        info("Browser cookies files was deleted");

        DriverContext.browser.goToUrl(Settings.URLsite);
        info("Navigated to URL: " + Settings.URLsite);
    }

    @After
    public void downTest(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            String path = ScreenshotTool.takeScreenshotEntirePage(scenario.getName());
            String imagePath = addScreenshot(path);
            fail(scenario.getName(), imagePath);
        } else {
            pass(scenario.getName() + " PASS");
        }

        DriverContext.browser.closeBrowser();

        stopLogger();
    }
}
