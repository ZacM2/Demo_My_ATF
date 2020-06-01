package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import pages.GoCardlessPage;
import pages.TopUpAccountPage;

public class GoCardlessPageStepDefinitions {

    @Page
    GoCardlessPage goCardlessPage;


    @Then("^I am directed to the Go Cardless portal to finalise my direct debit set up$")
    public void iAmDirectedToTheGoCardlessPortalToFinaliseMyDirectDebitSetUp() {
        goCardlessPage.isDisplayed();
    }

    @When("^I enter my go cardless payment details$")
    public void iEnterMyGoCardlessPaymentDetails() {
        goCardlessPage.enterName();
        goCardlessPage.enterEmailAddress();
        goCardlessPage.enterPaymentDetails();
        goCardlessPage.enterAddressAndSelectFirstOption();
        goCardlessPage.clickSetUpDirectDebit();
    }


}
