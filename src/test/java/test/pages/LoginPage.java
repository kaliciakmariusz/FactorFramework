package test.pages;

import framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // fields
    @FindBy(id = "user_session_login")
    private WebElement txtLogin;

    @FindBy(id = "user_session_password")
    private WebElement txtPassword;

    // buttons
    @FindBy(css = "input[value=Zaloguj]")
    private WebElement btnLogin;

    // errors
    @FindBy(css = "div[class=formError]")
    private WebElement formError;

    public String getTxtLogin() {
        return txtLogin.getAttribute("value");
    }

    public String getFormError(){
        return formError.getText();
    }

    public boolean isFormError() {
        return formError.isDisplayed();
    }

    public void enterLogin(String login) {
        txtLogin.clear();
        txtLogin.sendKeys(login);
    }

    public void enterPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public DashboardPage clickLogin() {
        btnLogin.submit();
        return getInstance(DashboardPage.class);
    }

    public void loginUser(String userName, String password) {
        enterLogin(userName);
        enterPassword(password);
    }

}
