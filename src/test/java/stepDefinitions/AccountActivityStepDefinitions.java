package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.AccountActivityPage;

public class AccountActivityStepDefinitions {

    @Page
    AccountActivityPage accountActivityPage;



    @And("^I click on Top Up Account$")
    public void iClickOnTopUpAccount() {
        accountActivityPage.clickTopUpAccount();
    }

    @Then("^the Account Activity Page should be displayed$")
    public void theAccountActivityPageShouldBeDisplayed() {
        Assert.assertTrue(accountActivityPage.accountActivityPageIsDisplayed());
    }

    @And("^there is a message to say the direct debit has been removed$")
    public void thereIsAMessageToSayTheDirectDebitHasBeenRemoved() {
        Assert.assertTrue(accountActivityPage.errorMessageIsDisplayed());

    }
}
