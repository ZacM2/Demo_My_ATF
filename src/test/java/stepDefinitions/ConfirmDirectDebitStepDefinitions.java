package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.ConfirmDirectDebitPage;
import pages.TopUpAccountPage;

public class ConfirmDirectDebitStepDefinitions {

    @Page
    ConfirmDirectDebitPage confirmDirectDebitPage;


    @Then("^I am directed to the 'Confirm your direct debit' page$")
    public void iAmDirectedToTheConfirmYourDirectDebitPage() {
        Assert.assertTrue(confirmDirectDebitPage.confirmDirectDebitPageIsDisplayed());

    }

    @And("^The Direct Debit Amount is displayed correctly$")
    public void theDirectDebitAmountIsDisplayedCorrectly() {
        Assert.assertTrue(confirmDirectDebitPage.confirmDirectDebitAmountFieldIsDisplayed());
        Assert.assertTrue("The direct debit amount displayed is incorrect", confirmDirectDebitPage.confirmDirectDebitAmountIsCorrect());
        Assert.assertTrue("No change amount button displayed", confirmDirectDebitPage.changeAmountButtonAvailable());
    }

    @And("^The Direct Debit Date is displayed correctly$")
    public void theDirectDebitDateIsDisplayedCorrectly() {
        Assert.assertTrue(confirmDirectDebitPage.confirmDirectDebitDateFieldIsDisplayed());
        Assert.assertTrue("No change date button displayed", confirmDirectDebitPage.changeDateButtonAvailable());
    }

    @When("^I click the cancel link on the confirm direct debit page$")
    public void iClickTheCancelLinkOnConfirmTopUp() {
        confirmDirectDebitPage.clickCancelButton();
    }

    @When("^I click the change sum button$")
    public void iClickTheChangeSumButton() {
        confirmDirectDebitPage.clickChangeAmount();
    }

    @When("^I click the change date button$")
    public void iClickTheChangeDateButton() {
        confirmDirectDebitPage.clickChangeDate();
    }

    @When("^I click the confirm and continue to set up button$")
    public void iClickTheConfirmAndContinueToSetUpButton() {
        confirmDirectDebitPage.clickConfirmAndContinue();
    }
}
