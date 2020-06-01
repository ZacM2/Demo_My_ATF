package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.HomePage;
import pages.TopUpAccountPage;

public class HomePageStepDefinitions {

    @Page
    HomePage homePage;


    @And("^I click Account Activity$")
    public void iClickAccountActivity() {
        homePage.navigateToAccountActivity();

    }


    @And("^I click Site Management$")
    public void iClickSiteManagement() {
        homePage.navigateToSiteManagement();
    }

    @Then("^the Manage Your ATF Homepage should be displayed$")
    public void theManageYourATFHomepageShouldBeDisplayed() {
        homePage.manageAtfPageDisplayed();
    }

    @And("^the page has a consistent GOV\\.UK header$")
    public void thePageHasAConsistentGOVUKHeader() {
        Assert.assertTrue("The Manager Your ATF Gov UK text was not displayed on the header", homePage.manageYourAtfHeaderDisplayed());
        Assert.assertTrue("The Gov UK Logo was not displayed on the header", homePage.govUkLogoIsDisplayed());
        Assert.assertTrue("The Gov UK Text was not displayed on the header", homePage.govUkTextIsDisplayed());
        Assert.assertTrue("The user name was not displayed on the header", homePage.userNameLinkIsDisplayed());
        Assert.assertTrue("The sign out link was not displayed on the page", homePage.signOutLinkIsDisplayed());
    }

    @And("^the page has a consistent GOV\\.UK footer$")
    public void thePageHasAConsistentGOVUKFooter() {
        Assert.assertTrue("Footer was not displayed", homePage.footerIsDisplayed());
        Assert.assertTrue("Footer Logo was not displayed", homePage.footerLogoIsDisplayed());
        Assert.assertTrue("Accessibility Statement link was not visible in the footer", homePage.accessibilityStatementIsDisplayed());
        Assert.assertTrue("Cookies link was not visible in the footer", homePage.cookiesLinkIsDisplayed());
        Assert.assertTrue("Terms and Conditions link was not visible in the footer", homePage.termsAndConditionsIsDisplayed());
    }

    @When("^I navigate back to the homepage$")
    public void iNavigateBackToTheHomepage() {
        homePage.clickToGoHome();
    }
}
