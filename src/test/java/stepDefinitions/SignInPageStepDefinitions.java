package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.annotation.Page;
import pages.SignInPage;
import pages.TopUpAccountPage;

public class SignInPageStepDefinitions {

    @Page
    SignInPage signInPage;

    @Given("^I sign in as a generic user$")
    public void iSignInAsAGenericUser() {
        signInPage.signInAsGenericUser();
    }

}
