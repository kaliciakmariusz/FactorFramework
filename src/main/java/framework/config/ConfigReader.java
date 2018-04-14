package framework.config;

import framework.base.BrowserType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

        }

        Settings.AUTConnectionString = p.getProperty("AUTConnectionString");
        Settings.URLsite = p.getProperty("URLsite");
        Settings.LogsPath = p.getProperty("LogsPath");
        Settings.DriverType = p.getProperty("DriverType");
        Settings.ExcelPath = p.getProperty("ExcelPath");
        Settings.ExcelScenariosFile = p.getProperty("ExcelScenariosFile");
        Settings.ExcelDataFile = p.getProperty("ExcelDataFile");
        Settings.BrowserType = BrowserType.valueOf(p.getProperty("BrowserType"));
        Settings.BrowserImplicitlyTime = Integer.valueOf(p.getProperty("BrowserImplicitlyTime"));
        Settings.ScreenshootFolderName = p.getProperty("ScreenshootFolderName");
        Settings.LogFileName = p.getProperty("LogFileName");
    }
}

