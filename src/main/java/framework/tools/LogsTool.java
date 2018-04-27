package framework.tools;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import framework.base.DriverContext;
import framework.config.Settings;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

@Slf4j
public class LogsTool {

    public static void setExtentReportsSettings() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        Settings.LogsPath = "output/" + Settings.StartTestsTime + "/";
        extentProperties.setReportPath(Settings.LogsPath + Settings.LogFileName);
        log.debug("Extentreport will be saved to: {}", Settings.LogsPath + Settings.LogFileName);
    }

    public static void setExtentReportsInfo() {

        Capabilities caps = ((RemoteWebDriver) DriverContext.driver).getCapabilities();
        final String extentConfigPath = "src/main/resources/config/extent-config.xml";

        try {
            Reporter.loadXMLConfig(new File(extentConfigPath));
            log.debug("The ExtentReports configuration file has been read from: {}", extentConfigPath);
        } catch (Exception e) {
            log.error("Failure to read extent-config.xml: {}", e);
        }

        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", String.format("%s (%s)", System.getProperty("os.name"), System.getProperty("os.arch")));
        Reporter.setSystemInfo("os version", System.getProperty("os version"));
        Reporter.setSystemInfo("java version", System.getProperty("java.version"));
        Reporter.setSystemInfo("browser", String.format("%s (%s)", caps.getBrowserName(), caps.getVersion()));
    }
}
