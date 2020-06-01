package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import pages.CustomerPaymentManagementSystemPage;
import pages.TopUpAccountPage;

public class CustomerPaymentManagementSystemStepDefinitions {

    @Page
    CustomerPaymentManagementSystemPage customerPaymentManagementSystemPage;


    @Then("^I am directed to the CPMS site to make a card payment$")
    public void iAmDirectedToTheCPMSSiteToMakeACardPayment() {
        customerPaymentManagementSystemPage.isDisplayed();
    }

    @When("^I cancel the payment on the CPMS page$")
    public void iCancelThePaymentOnTheCPMSPage() {
        customerPaymentManagementSystemPage.cancelPayment();
    }

    @Then("^I am directed to a payment was unsuccessful screen$")
    public void iAmDirectedToAPaymentWasUnsuccessfulScreen() {
        customerPaymentManagementSystemPage.paymentUnsuccessfulScreenIsDisplayed();
    }

    @When("^I enter my card details on the CPMS page$")
    public void iEnterMyCardDetailsOnTheCPMSPage() {
        customerPaymentManagementSystemPage.enterCpmsPaymentDetails();
        customerPaymentManagementSystemPage.clickCpmsSubmit();
    }

    @And("^I enter my CPMS additional information$")
    public void iEnterMyCPMSAdditionalInformation() {
        customerPaymentManagementSystemPage.enterCpmsAdditionalDetails();
        customerPaymentManagementSystemPage.clickContinueAdditionalDetails();
    }
}
