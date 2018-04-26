package test.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import framework.base.BasePage;
import framework.base.DriverContext;
import org.testng.Assert;
import test.pages.HomePage;

public class HomeSteps extends BasePage {

    @Given("^I make sure the application has been opened on Home page$")
    public void iMakeSureTheApplicationHasBeenOpenedOnHomePage() {

        currentPage = getInstance(HomePage.class);
        Assert.assertTrue(currentPage.as(HomePage.class).isCoppyright(), "The Home page is not loaded");
    }

    @And("^I click on \"([^\"]*)\" in menu on Home page$")
    public void iClickOnInMenuOnHomePage(String buttonName) {
        switch (buttonName) {
            case "Zaloguj się":
                currentPage = currentPage.as(HomePage.class).clickLogin();
                Assert.assertTrue(DriverContext.driver.getCurrentUrl().contains("/login"), "The Login page is not loaded");
                break;
        }
    }
}