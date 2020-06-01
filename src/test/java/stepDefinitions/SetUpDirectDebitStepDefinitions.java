package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.SetUpDirectDebitPage;
import pages.TopUpAccountPage;

public class SetUpDirectDebitStepDefinitions {

    @Page
    SetUpDirectDebitPage setUpDirectDebitPage;

    @Then("^the 'Set up a direct debit' page should be displayed$")
    public void theSetUpADirectDebitPageShouldBeDisplayed() {
        Assert.assertTrue(setUpDirectDebitPage.setUpDirectDebitPageIsDisplayed());

    }

    @And("^the page shows the heading, sub heading and helpful information$")
    public void thePageShowsTheHeadingSubHeadingAndHelpfulInformation() {
        Assert.assertTrue("The Test Facility Details Screen failed to display", setUpDirectDebitPage.testFacilityDetailsIsDisplayed());
    }

    @And("^that page shows the field and text allowing me to specify the sum I want to top up$")
    public void thatPageShowsTheFieldAndTextAllowingMeToSpecifyTheSumIWantToTopUp() {
        Assert.assertTrue("The Payment Text failed to display", setUpDirectDebitPage.paymentAmountTextDisplayed());
        Assert.assertTrue("The minimum payment amount failed to display", setUpDirectDebitPage.minimumPaymentAmountDisplayed());
    }

    @And("^that page shows the fields and text allowing me to specify the date I want to top up$")
    public void thatPageShowsTheFieldsAndTextAllowingMeToSpecifyTheDateIWantToTopUp() {
        Assert.assertTrue("The Payment Date Fields failed to display", setUpDirectDebitPage.paymentDatesAreDisplayed());
        Assert.assertTrue("The Payment Date Buttons are not clickable", setUpDirectDebitPage.paymentDateButtonsAreClickable());
    }

    @And("^my previous amount selection is pre-populated$")
    public void myPreviousAmountSelectionIsPrePopulated() {
        setUpDirectDebitPage.confirmDirectDebitAmountIsCorrect();
    }

    @And("^my previous date selection is pre-populated$")
    public void myPreviousDateSelectionIsPrePopulated() {
        Assert.assertTrue("The checked date is not the same as the date selected earlier",
                setUpDirectDebitPage.confirmDirectDebitDateIsCorrect());
    }

    @And("^I click the 'continue' button on the set up a direct debit page$")
    public void iClickTheContinueButtonOnTheSetUpADirectDebitPage() {
        setUpDirectDebitPage.clickContinueButton();
    }

    @Then("^I am presented with a no dates specified error message$")
    public void iAmPresentedWithANoDatesSpecifiedErrorMessage() {
        Assert.assertTrue("Error Title was not displayed", setUpDirectDebitPage.errorMessageTitleDisplayed());
        Assert.assertTrue("No date specified error text was not shown", setUpDirectDebitPage.noDateSpecifiedErrorBodyTextShown());
    }

    @And("^I have input a top up amount that is within business rules$")
    public void iHaveInputATopUpAmountThatIsWithinBusinessRules() {
        setUpDirectDebitPage.enterValueFollowingBusinessRules();
    }

    @And("^I have selected a random direct debit date$")
    public void iHaveSelectedARandomDirectDebitDate() {
        setUpDirectDebitPage.selectRandomDirectDebitDate();
    }

    @Then("^I am presented with a no sum specified error message$")
    public void iAmPresentedWithANoSumSpecifiedErrorMessage() {
        Assert.assertTrue("Error Title was not displayed", setUpDirectDebitPage.errorMessageTitleDisplayed());
        Assert.assertTrue("Payment Error Body Text was not displayed", setUpDirectDebitPage.noPaymentAmountErrorBodyTextShown());
    }

    @And("^I have input a top up amount that is less than the minimum amount$")
    public void iHaveInputATopUpAmountThatIsLessThanTheMinimumAmount() {
        setUpDirectDebitPage.enterValueBelowMinimumAmount();
    }

    @Then("^I am presented with a below minimum top up value error message$")
    public void iAmPresentedWithABelowMinimumTopUpValueErrorMessage() {
        Assert.assertTrue("Error Title was not displayed", setUpDirectDebitPage.errorMessageTitleDisplayed());
        Assert.assertTrue("Minimum Top Up Body Text was not displayed", setUpDirectDebitPage.minimumTopUpErrorBodyTextShown());
    }

    @Then("^I am presented with a no selections made error message$")
    public void iAmPresentedWithANoSelectionsMadeErrorMessage() {
        Assert.assertTrue("Error Title was not displayed", setUpDirectDebitPage.errorMessageTitleDisplayed());
        Assert.assertTrue("No selection made text not displayed", setUpDirectDebitPage.noSelectionMadeErrorBodyTextShown());
    }
}
