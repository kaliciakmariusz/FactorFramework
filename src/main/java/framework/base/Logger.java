package framework.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import framework.config.Settings;

import java.io.File;

public class Logger {

    private static ExtentTest testLog;
    private ExtentReports report;

    public static ExtentReports getInstance() {

        ExtentReports extent;
        extent = new ExtentReports(System.getProperty("user.dir") + "/" + Settings.LogsPath + "/" + Settings.LogFileName, false);
        extent.addSystemInfo("Selenium Version", "3.8.1").addSystemInfo("Platform", "Windows 10");

        return extent;
    }

    public void createLogFolder() {
        try {
            File dir = new File(System.getProperty("user.dir") + "/" + Settings.LogsPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
        } catch(Exception e) {
            error("Create log folder - fail", e);
        }
    }

    public void startLogger(String scenerioName) {
        report = Logger.getInstance();
        testLog = report.startTest(scenerioName);
    }

    public void stopLogger() {
        report.endTest(testLog);
        report.flush();
    }

    public String addScreenshot(String path) {
        return testLog.addScreenCapture(path);
    }

    public void info(String message) {
        testLog.log(LogStatus.INFO, message);
    }

    public void pass(String message) {
        testLog.log(LogStatus.PASS, message);
    }

    public void fail(String message, String path) {
        testLog.log(LogStatus.FAIL, message, path);
    }

    public void error(String message, Exception e) {
        testLog.log(LogStatus.ERROR, message, e);
    }


}