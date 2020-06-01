package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import pages.RemoveDirectDebitPage;
import pages.TopUpAccountPage;

public class RemoveDirectDebitStepDefinitions {

    @Page
    RemoveDirectDebitPage removeDirectDebitPage;

    @Then("^the Remove Direct Debit Page should be displayed$")
    public void theRemoveDirectDebitPageShouldBeDisplayed() {
        removeDirectDebitPage.isDisplayed();
    }

    @When("^I click the confirm and continue link on the Remove Direct Debit Page$")
    public void iClickTheConfirmAndContinueLinkOnTheRemoveDirectDebitPage() {
        removeDirectDebitPage.clickConfirmAndContinue();
    }

}
