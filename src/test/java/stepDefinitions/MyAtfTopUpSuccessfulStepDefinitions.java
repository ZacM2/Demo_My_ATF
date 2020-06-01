package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fluentlenium.core.annotation.Page;
import pages.MyAtfTopUpSuccessfulPage;
import pages.TopUpAccountPage;

public class MyAtfTopUpSuccessfulStepDefinitions {

    @Page
    MyAtfTopUpSuccessfulPage myAtfTopUpSuccessfulPage;


    @Then("^the Successful Top Up Screen should be displayed$")
    public void theSuccessfulTopUpScreenShouldBeDisplayed() {
        myAtfTopUpSuccessfulPage.pageIsDisplayed();
        myAtfTopUpSuccessfulPage.invoiceNumberIsDisplayedCorrectly();
    }


}
