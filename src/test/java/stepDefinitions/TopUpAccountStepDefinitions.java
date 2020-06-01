package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.TopUpAccountPage;

public class TopUpAccountStepDefinitions {

    @Page
    TopUpAccountPage topUpAccountPage;

    @When("^I click the Set up a card payment button$")
    public void iClickTheSetUpACardPaymentButton() {
        topUpAccountPage.clickTopUpByCard();
    }

    @When("^I click the Set up a direct debit button$")
    public void iSelectSetUpADirectDebit() {
        topUpAccountPage.clickTopUpByDirectDebit();
    }

    @Then("^I am navigated to the Top Up Account Page$")
    public void iAmNavigatedToTheTopUpAccountPage() {
        Assert.assertTrue("This session did not navigate back to the top up account page", topUpAccountPage.topUpAccountPageIsDisplayed());

    }

    @When("^I click the change direct debit button on the Top up Account Page$")
    public void iClickTheChangeDirectDebitButtonOnTheTopUpAccountPage() {
        topUpAccountPage.clickChangeDirectDebit();
    }

    @When("^I click the cancel direct debit button on the Top up Account Page$")
    public void iClickTheCancelDirectDebitButtonOnTheTopUpAccountPage() {
        topUpAccountPage.clickCancelDirectDebit();
    }

}
