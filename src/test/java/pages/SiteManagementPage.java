package pages;

import org.openqa.selenium.By;

public class SiteManagementPage extends GenericPage {

    final By SITE_MANAGEMENT_HEADER = By.cssSelector(".govuk-heading-l");

    public SiteManagementPage() { super(); }


    public boolean pageIsDisplayed() {
        waitForElementToLoad(SITE_MANAGEMENT_HEADER);
        return elementIsDisplayedAndContainsText(SITE_MANAGEMENT_HEADER, siteManagementHeader);
    }
}
