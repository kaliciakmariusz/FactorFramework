package test.steps;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.base.DriverContext;
import framework.base.FrameworkInitialize;
import framework.config.Settings;
import framework.tools.ScreenshotTool;
import framework.tools.TimeTool;

public class TestInitialize extends FrameworkInitialize {

    @Before
    public void initializeTest() {

        initalizeBrowser();

        //DriverContext.browser.maximize();

        DriverContext.browser.setImplecityTime(Settings.BrowserImplicitlyTime);

        DriverContext.browser.deleteCookies();

        DriverContext.browser.goToUrl(Settings.URLsite);
    }

    @After
    public void downTest(Scenario scenario) {

        if (scenario.isFailed()) {
            String screenshotName = (scenario.getName() + TimeTool.getCurrentTime() + ".png").replace(" ", "_");
            try {
                Reporter.addScreenCaptureFromPath(ScreenshotTool.takeScreenshotEntirePage(screenshotName));
            } catch (Exception e) {

            }
        }

        DriverContext.browser.closeBrowser();
    }
}