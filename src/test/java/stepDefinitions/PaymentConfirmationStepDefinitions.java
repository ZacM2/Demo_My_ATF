package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.PaymentConfirmationPage;
import pages.TopUpAccountPage;
import pages.TopUpByCardPage;

public class PaymentConfirmationStepDefinitions {

    @Page
    PaymentConfirmationPage paymentConfirmationPage;


    @Then("^the payment confirmation page should be displayed$")
    public void thePaymentConfirmationPageShouldBeDisplayed() {
        Assert.assertTrue("The payment confirmation was not displayed", paymentConfirmationPage.pageIsDisplayed());
        Assert.assertTrue("The payment amount displayed on the payment confirmation page was incorrect",
                paymentConfirmationPage.paymentAmountEqualsTopUpValue(TopUpByCardPage.returnTopUpAmount()));
    }

    @When("^I click Make Payment$")
    public void iClickMakePayment() {
        paymentConfirmationPage.clickMakePayment();

    }
}
