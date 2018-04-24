package framework.base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Browser extends Base {

    private WebDriver driver;
    public BrowserType type;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl(String url) {
        this.driver.get(url);
        log.debug("goToUrl({})", url);
    }

    public void maximize() {
        this.driver.manage().window().maximize();
        log.debug("Browser maximize window");
    }

    public void setImplecityTime(int seconds) {
        this.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        log.debug("setImplecityTime({})", seconds);
    }

    public void closeBrowser() {
        this.driver.quit();
        log.debug("Browser closed");
    }

    public void deleteCookies() {
        this.driver.manage().deleteAllCookies();
        log.debug("Browser delete cookies");
    }

    public String getCurrentURL() {
        return this.driver.getCurrentUrl();
    }
}
