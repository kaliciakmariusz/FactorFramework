package test.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.base.BasePage;
import framework.base.DriverContext;
import org.testng.Assert;
import test.pages.LoginPage;

public class LoginSteps extends BasePage {

    @When("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUserNameAndCorrectPassword(String userName, String password) {

        currentPage.as(LoginPage.class).loginUser(userName, password);
        Assert.assertEquals(currentPage.as(LoginPage.class).getTxtLogin(), userName, "The login entered does not match the one read");
    }

    @And("^I click button \"([^\"]*)\"$")
    public void iClickButton(String buttonName) {
        switch (buttonName) {
            case "Zaloguj":
                currentPage = currentPage.as(LoginPage.class).clickLogin();
                break;
        }
    }

    @Then("^I should see ([^\"]*) on Login page$")
    public void iShouldSeeContentsErrorOnLoginPage(String contentsError) {
        currentPage = getInstance(LoginPage.class);
        Assert.assertTrue(DriverContext.driver.getCurrentUrl().contains("/login"), "The Login page was change");
        Assert.assertTrue(currentPage.as(LoginPage.class).isFormError(), "The form error is not displayed");
        Assert.assertEquals(currentPage.as(LoginPage.class).getFormError(), contentsError, "The error content read out does not match the defined one");
    }
}