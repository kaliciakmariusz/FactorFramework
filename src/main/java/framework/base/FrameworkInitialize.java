package framework.base;

import framework.config.Settings;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

@Slf4j
public class FrameworkInitialize {

    private WebDriver driver = null;
    private String userDir = null;
    private StringBuilder sB = null;
    private BrowserType browserType = Settings.BrowserType;

    public void initalizeBrowser() {

        this.userDir = System.getProperty("user.dir");
        this.sB = new StringBuilder(userDir);
        this.sB.append("\\src\\main\\resources\\drivers\\");

        if (System.getProperty("os.name").contains("Windows")) {
            this.sB.append("windows\\");
            makeWindowsDriver();
        } else {
            this.sB.append("unix\\");
            makeUnixDriver();
        }

        DriverContext.setDriver(driver);
        DriverContext.browser = new Browser(driver);
        log.debug("Framework starts driver: {}", sB.toString());
    }

    private void makeWindowsDriver() {
        switch (browserType) {
            case chrome: {
                this.sB.append("chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", this.sB.toString());
                driver = new ChromeDriver();
                break;
            }
            case chrome_headless: {
                this.sB.append("chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", this.sB.toString());

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("window-size=1920,1080");

                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case firefox: {
                this.sB.append("geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", this.sB.toString());
                driver = new FirefoxDriver();
                break;
            }
            case opera: {
                this.sB.append("operadriver.exe");
                System.setProperty("webdriver.opera.driver", this.sB.toString());
                driver = new OperaDriver();
                break;
            }
            case ie: {
                this.sB.append("InternetExplorer.exe");
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;
            }
            case edge: {
                this.sB.append("MicrosoftEdge.exe");
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();
                break;
            }
        }
    }

    private void makeUnixDriver() {
        switch (browserType) {
            case chrome: {
                this.sB.append("chromedriver");
                System.setProperty("webdriver.chrome.driver", this.sB.toString());
                driver = new ChromeDriver();
                break;
            }
            case chrome_headless: {
                this.sB.append("chromedriver");
                System.setProperty("webdriver.chrome.driver", this.sB.toString());

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("window-size=1920,1080");

                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case firefox: {
                this.sB.append("geckodriver");
                System.setProperty("webdriver.gecko.driver", this.sB.toString());
                driver = new FirefoxDriver();
                break;
            }
            case opera: {
                this.sB.append("operadriver");
                System.setProperty("webdriver.opera.driver", this.sB.toString());
                driver = new OperaDriver();
                break;
            }
        }
    }
}