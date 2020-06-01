package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fluentlenium.core.annotation.Page;
import pages.ChangeDirectDebitPage;
import pages.TopUpAccountPage;

public class ChangeDirectDebitStepDefinitions {

    @Page
    ChangeDirectDebitPage changeDirectDebitPage;


    @And("^I am navigated to the change your direct debit page$")
    public void iAmNavigatedToTheChangeYourDirectDebitPage() {
        changeDirectDebitPage.changeYourDirectDebitPageIsDisplayed();
    }

    @And("^I click the confirm and change direct debit button$")
    public void iClickTheConfirmAndChangeDirectDebitButton() {
        changeDirectDebitPage.clickConfirm();
    }

    @And("^I click the 'continue' button on the change your direct debit page$")
    public void iClickTheContinueButtonOnTheChangeYourDirectDebitPage() {
        changeDirectDebitPage.clickContinue();
    }
}
