package test.pages;

import framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    // top menu
    @FindBy(css = "span[class=make_short]")
    private WebElement userDropDown;

    public String getShortName() {
        return userDropDown.getText();
    }

    public boolean isUserDropDown() {
        return userDropDown.isDisplayed();
    }
}
