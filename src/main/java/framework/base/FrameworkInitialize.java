package framework.base;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class FrameworkInitialize {

    public void initalizeBrowser(BrowserType browserType) {
        WebDriver driver = null;
        switch (browserType) {
            case Chrome: {
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            }
            case FireFox: {
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            }
            case IE: {
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;
            }
            case Opera: {
                OperaDriverManager.getInstance().setup();
                driver = new OperaDriver();
                break;
            }
            case Edge: {
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();
                break;
            }
        }
        DriverContext.setDriver(driver);
        DriverContext.browser = new Browser(driver);
    }
}