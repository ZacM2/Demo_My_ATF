package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.GenericPage;
import pages.HomePage;

public class GenericPageStepDefinitions {

    @Page
    GenericPage genericPage;

    @After
    @When("^I clear the browser session$")
    public void clearSession() {
        genericPage.logOut();
    }


}
