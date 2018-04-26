package framework.config;

import framework.base.BrowserType;
import framework.tools.TimeTool;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ConfigReader {

    public static void populateSettings() {
        ConfigReader reader = new ConfigReader();
        reader.readProperty();
    }

    private void readProperty() {

        Properties p = new Properties();
        String propFileName = "config/config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        try {
            p.load(inputStream);
        } catch (IOException e) {
            log.error("Failure to read configuration file: {}", e);
        }

        Settings.URLsite = p.getProperty("URLsite");
        Settings.LogsPath = p.getProperty("LogsPath");
        Settings.DriverType = p.getProperty("DriverType");
        Settings.BrowserType = BrowserType.valueOf(p.getProperty("BrowserType"));
        Settings.BrowserImplicitlyTime = Integer.valueOf(p.getProperty("BrowserImplicitlyTime"));
        Settings.ScreenshootFolderName = p.getProperty("ScreenshootFolderName");
        Settings.LogFileName = p.getProperty("LogFileName");
        Settings.StartTestsTime = TimeTool.getCurrentTime();
    }
}

