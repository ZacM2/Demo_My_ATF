package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.ConfirmTopUpPage;
import pages.TopUpAccountPage;

public class ConfirmTopUpStepDefinitions {

    @Page
    ConfirmTopUpPage confirmTopUpPage;


    @Then("^the Confirm your top up amount page is displayed$")
    public void theConfirmYourTopUpAmountPageIsDisplayed() {
        Assert.assertTrue("The heading was not displayed",confirmTopUpPage.isHeadingDisplayed());
        Assert.assertTrue("The change hyperlink was not displayed",confirmTopUpPage.isChangeHyperLinkDisplayed());
        Assert.assertTrue("The helpful text was not displayed",confirmTopUpPage.isHelpfulTextDisplayed());
        Assert.assertTrue("The confirm button was not displayed",confirmTopUpPage.isConfirmButtonDisplayed());
        Assert.assertTrue("The cancel link was not displayed",confirmTopUpPage.isCancelLinkDisplayed());
        Assert.assertTrue("The top up value was not displayed correctly",confirmTopUpPage.correctTopUpValueIsDisplayed());
    }

    @When("^I click the 'confirm and continue to set up' button for card top up$")
    public void iClickTheConfirmAndContinueToSetUpButtonForCardTopUp() {
        confirmTopUpPage.clickConfirmButton();
    }

    @When("^I click the cancel button on the confirm your top up page$")
    public void iClickTheCancelButtonOnTheConfirmYourTopUpPage() {
        confirmTopUpPage.clickCancelButton();
    }



}
