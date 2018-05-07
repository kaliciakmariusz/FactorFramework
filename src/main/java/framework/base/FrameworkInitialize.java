package framework.base;

import framework.config.Settings;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
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
    private String targetDriverPath = null;
    private BrowserType browserType = Settings.BrowserType;

    public void initalizeBrowser() {

        this.userDir = System.getProperty("user.dir");
        this.sB = new StringBuilder(userDir);
        this.sB.append("/src/main/resources/drivers/");

        if (System.getProperty("os.name").contains("Windows")) {
            sB.append("windows/");
            makeWindowsDriver();
        } else {
            sB.append("unix/");
            makeUnixDriver();
        }

        DriverContext.setDriver(driver);
        DriverContext.browser = new Browser(driver);
        log.debug("Framework starts driver: {}", targetDriverPath);
    }

    private void makeWindowsDriver() {

        switch (browserType) {
            case chrome: {
                sB.append("chromedriver.exe");

                targetDriverPath = FilenameUtils.separatorsToSystem(sB.toString());

                System.setProperty("webdriver.chrome.driver", targetDriverPath);

                driver = new ChromeDriver();
                break;
            }
            case chrome_headless: {
                sB.append("chromedriver.exe");

                targetDriverPath = FilenameUtils.separatorsToSystem(sB.toString());

                System.setProperty("webdriver.chrome.driver", targetDriverPath);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("window-size=1920,1080");

                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case firefox: {
                sB.append("geckodriver.exe");

                targetDriverPath = FilenameUtils.separatorsToSystem(sB.toString());

                System.setProperty("webdriver.gecko.driver", targetDriverPath);

                driver = new FirefoxDriver();
                break;
            }
            case opera: {
                sB.append("operadriver.exe");

                targetDriverPath = FilenameUtils.separatorsToSystem(sB.toString());

                System.setProperty("webdriver.opera.driver", targetDriverPath);

                driver = new OperaDriver();
                break;
            }
            case ie: {
                sB.append("InternetExplorer.exe");
                InternetExplorerDriverManager.getInstance().setup();

                driver = new InternetExplorerDriver();
                break;
            }
            case edge: {
                sB.append("MicrosoftEdge.exe");
                EdgeDriverManager.getInstance().setup();

                driver = new EdgeDriver();
                break;
            }
        }
    }

    private void makeUnixDriver() {
        
        switch (browserType) {
            case chrome: {
                sB.append("chromedriver");

                targetDriverPath = FilenameUtils.separatorsToSystem(sB.toString());

                System.setProperty("webdriver.chrome.driver", targetDriverPath);

                driver = new ChromeDriver();
                break;
            }
            case chrome_headless: {
                sB.append("chromedriver");

                targetDriverPath = FilenameUtils.separatorsToSystem(sB.toString());

                System.setProperty("webdriver.chrome.driver", targetDriverPath);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("window-size=1920,1080");

                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case firefox: {
                sB.append("geckodriver");

                targetDriverPath = FilenameUtils.separatorsToSystem(sB.toString());

                System.setProperty("webdriver.gecko.driver", targetDriverPath);

                driver = new FirefoxDriver();
                break;
            }
            case opera: {
                sB.append("operadriver");

                targetDriverPath = FilenameUtils.separatorsToSystem(sB.toString());

                System.setProperty("webdriver.opera.driver", targetDriverPath);

                driver = new OperaDriver();
                break;
            }
        }
    }
}