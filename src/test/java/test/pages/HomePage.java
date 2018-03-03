package test.pages;

import framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // top menu
    @FindBy(xpath = "//span[contains(text(),'Zaloguj się')]")
    private WebElement btnLogin;

    // coppyright
    @FindBy(xpath = "//div[contains(text(),'© 2018 Fakturownia')]")
    private WebElement txtCoppyright;

    public LoginPage clickLogin() {
        btnLogin.click();
        return getInstance(LoginPage.class);
    }

    public boolean isCoppyright() {
        return txtCoppyright.isDisplayed();
    }
}
