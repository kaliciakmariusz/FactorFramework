package framework.base;

import framework.config.Settings;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class FrameworkInitialize {

    private WebDriver driver = null;
    private String userDir = null;
    private StringBuilder sB = null;
    private BrowserType browserType = Settings.BrowserType;

    public void initalizeBrowser() {

        this.userDir = System.getProperty("user.dir");
        this.sB = new StringBuilder(userDir);
        this.sB.append("src/main/resources/drivers/");

        if (System.getProperty("os.name").contains("Windows")) {
            this.sB.append("windows/");
            makeWindowsDriver();
        } else {
            this.sB.append("unix/");
            makeUnixDriver();
        }

        DriverContext.setDriver(driver);
        DriverContext.browser = new Browser(driver);
    }

    private void makeWindowsDriver() {
        switch (browserType) {
            case chrome: {
                System.setProperty("webdriver.chrome.driver", this.sB.append("chromedriver.exe").toString());
                driver = new ChromeDriver();
                break;
            }
            case firefox: {
                System.setProperty("webdriver.gecko.driver", this.sB.append("geckodriver.exe").toString());
                driver = new FirefoxDriver();
                break;
            }
            case opera: {
                System.setProperty("webdriver.opera.driver", this.sB.append("operadriver.exe").toString());
                driver = new OperaDriver();
                break;
            }
            case ie: {
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;
            }
            case edge: {
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();
                break;
            }
        }
    }

    private void makeUnixDriver() {
        switch (browserType) {
            case chrome: {
                System.setProperty("webdriver.chrome.driver", this.sB.append("chromedriver").toString());
                driver = new ChromeDriver();
                break;
            }
            case firefox: {
                System.setProperty("webdriver.gecko.driver", this.sB.append("geckodriver").toString());
                driver = new FirefoxDriver();
                break;
            }
            case opera: {
                System.setProperty("webdriver.opera.driver", this.sB.append("operadriver").toString());
                driver = new OperaDriver();
                break;
            }
        }
    }
}