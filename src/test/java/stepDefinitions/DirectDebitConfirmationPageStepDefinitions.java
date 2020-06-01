package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.DirectDebitConfirmationPage;
import pages.TopUpAccountPage;

public class DirectDebitConfirmationPageStepDefinitions {

    @Page
    DirectDebitConfirmationPage directDebitConfirmationPage;


    @Then("^the direct debit payment confirmation page is displayed$")
    public void theDirectDebitPaymentConfirmationPageIsDisplayed() {
        directDebitConfirmationPage.isDisplayed();
    }

    @When("^I click confirm on the direct debit payment confirmation page$")
    public void iClickConfirmOnTheDirectDebitPaymentConfirmationPage() {
        directDebitConfirmationPage.clickConfirm();
    }

    @Then("^the Direct Debit request received page is displayed$")
    public void theDirectDebitRequestReceivedPageIsDisplayed() {
        Assert.assertTrue(directDebitConfirmationPage.directDebitRequestReceivedMessagedDisplayed());
    }
}
