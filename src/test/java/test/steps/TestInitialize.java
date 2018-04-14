package test.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.base.DriverContext;
import framework.base.FrameworkInitialize;
import framework.config.ConfigReader;
import framework.config.Settings;

import java.io.IOException;

public class TestInitialize extends FrameworkInitialize {

    @Before
    public void initializeTest(Scenario scenario) {

        initalizeBrowser();

        DriverContext.browser.maximize();

        DriverContext.browser.setImplecityTime(Settings.BrowserImplicitlyTime);

        DriverContext.browser.deleteCookies();

        DriverContext.browser.goToUrl(Settings.URLsite);
    }

    @After
    public void downTest(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {

        } else {
        }

        DriverContext.browser.closeBrowser();
    }
}
