package framework.base;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser extends Base {

    private WebDriver driver;
    public BrowserType type;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl(String url) {
        this.driver.get(url);
    }

    public void maximize() {
        this.driver.manage().window().maximize();
    }

    public void setImplecityTime(int seconds) {
        this.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        this.driver.quit();
    }

    public void deleteCookies() {
        this.driver.manage().deleteAllCookies();
    }
}
