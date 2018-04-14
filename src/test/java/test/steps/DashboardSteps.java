package test.steps;

import cucumber.api.java.en.Then;
import framework.base.BasePage;
import org.testng.Assert;
import test.pages.DashboardPage;

public class DashboardSteps extends BasePage {
    @Then("^I should see ([^\"]*) in menu on Dashboard page$")
    public void iShouldSeeUserNameInMenuOnDashboardPage(String userName) {
        Assert.assertEquals(currentPage.as(DashboardPage.class).getShortName(), userName, "The login read does not match");
    }
}