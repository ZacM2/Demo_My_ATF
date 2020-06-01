package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.SiteManagementPage;
import pages.TopUpAccountPage;

public class SiteManagementStepDefinitions {

    @Page
    SiteManagementPage siteManagementPage;

    @Then("^the Site Management Page should be displayed$")
    public void theSiteManagementPageShouldBeDisplayed() {
        Assert.assertTrue("The Site Management Page was not displayed", siteManagementPage.pageIsDisplayed());
    }

}
