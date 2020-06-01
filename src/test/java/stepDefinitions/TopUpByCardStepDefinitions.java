package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.TopUpAccountPage;
import pages.TopUpByCardPage;

public class TopUpByCardStepDefinitions {

    @Page
    TopUpByCardPage topUpByCardPage;

    @When("^I click the Cancel link$")
    public void iClickTheCancelLink() {
        topUpByCardPage.clickCancel();

    }

    @When("^I click the Continue link$")
    public void iClickTheContinueLink() {
        topUpByCardPage.clickContinue();
    }

    @Then("^the 'Top up by Card' page is displayed$")
    public void theTopUpByCardPageIsDisplayed() {
        topUpByCardPage.pageIsDisplayed();
    }

    @And("^the Continue and Cancel links are present$")
    public void theContinueAndCancelLinksArePresent() {
        topUpByCardPage.continueLinkIsDisplayed();
        topUpByCardPage.cancelLinkIsDisplayed();
    }

    @And("^I enter a top amount according to business rules$")
    public void iEnterATopAmountAccordingToBusinessRules() {
        topUpByCardPage.enterTopAmountToBusinessRules();
    }

    @And("^I enter a top amount below minimal value$")
    public void iEnterATopAmountBelowMinimalValue() {
        topUpByCardPage.enterTopUpAmountBelowMinimalValue();
    }


    @Then("^a \"([^\"]*)\" error message is shown$")
    public void aErrorMessageIsShown(String errorType){
        Assert.assertTrue(errorType + "title was not displayed correctly", topUpByCardPage.errorTitleIsDisplayed());
        Assert.assertTrue(errorType + "error message was not displayed correctly", topUpByCardPage.errorMessageIsDisplayed(errorType));
    }



}
