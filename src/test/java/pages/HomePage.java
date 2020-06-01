package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends GenericPage {

    final By GOV_UK_HEADER_CONTENT = By.cssSelector(".govuk-header__content");
    final By MANAGE_ATF_HEADER = By.cssSelector(".govuk-heading-l");
    final By ACCOUNT_ACTIVITY = By.cssSelector("a[href=AccountActivity]");
    final By SITE_MANAGEMENT = By.cssSelector("a[href=SiteManagement]");
    final By SIGN_OUT_BUTTON = By.cssSelector("a[href*=Logoff]");

    //    HEADER
    final By GOV_UK_MAIN_HEADER = By.cssSelector("body > header > div > div.govuk-header__content > a");
    final By GOV_UK_LOGO = By.cssSelector(".govuk-header__logotype-crown");
    final By GOV_UK_LOGO_TEXT = By.cssSelector(".govuk-header__logotype-text");
    final By HEADER_USER_NAME = By.cssSelector("a[href*=PersonalDetails]");

    //    FOOTER
    final By ACCESSIBILITY_LINK = By.cssSelector("a[href*=Accessibility]");
    final By COOKIES = By.cssSelector("a[href*=Cookies]");
    final By TERMS_AND_CONDITIONS = By.cssSelector("a[href*=Terms]");
    final By FOOTER_LOGO = By.cssSelector("body > footer > div > div > div:nth-child(2) > a");
    final By FOOTER = By.className("govuk-footer");



    String URL = "https://myatftest.powerappsportals.com/";


    public HomePage() {
        super();
    }

    public void goTo(){
        visit(URL);
    }

    public void waitUntilPageIsLoaded(){
        waitForElementToLoad(GOV_UK_HEADER_CONTENT);
    }

    public void manageAtfPageDisplayed() {
        Assert.assertTrue("Manage you ATF Title not displayed", elementIsDisplayed(MANAGE_ATF_HEADER));
    }

    public void navigateToAccountActivity() {
        waitForElementToLoad(ACCOUNT_ACTIVITY);
        click(ACCOUNT_ACTIVITY);
    }

    public void navigateToSiteManagement() {
        waitForElementToLoad(SITE_MANAGEMENT);
        click(SITE_MANAGEMENT);
    }

    public void signOut() {
        click(SIGN_OUT_BUTTON);
    }

    public boolean manageYourAtfHeaderDisplayed() {
        return elementIsDisplayedAndContainsText(GOV_UK_MAIN_HEADER, govUkMainHeaderText);
    }

    public boolean govUkLogoIsDisplayed() {
        return elementIsDisplayed(GOV_UK_LOGO);
    }

    public boolean govUkTextIsDisplayed() {
        return elementIsDisplayedAndContainsText(GOV_UK_LOGO_TEXT, govUkLogoText);
    }

    public boolean userNameLinkIsDisplayed() {
        return removeSpaces(returnElementText(HEADER_USER_NAME)).equals(userName);
    }

    public boolean signOutLinkIsDisplayed() {
        return elementIsDisplayedAndContainsText(SIGN_OUT_BUTTON, signOutButtonText);
    }

    public void clickToGoHome() {
        click(GOV_UK_MAIN_HEADER);
    }

    public boolean accessibilityStatementIsDisplayed(){
        return elementIsDisplayed(ACCESSIBILITY_LINK);
    }

    public boolean cookiesLinkIsDisplayed(){
        return elementIsDisplayed(COOKIES);
    }

    public boolean termsAndConditionsIsDisplayed(){
        return elementIsDisplayed(TERMS_AND_CONDITIONS);
    }

    public boolean footerIsDisplayed() {
        return elementIsDisplayed(FOOTER);
    }

    public boolean footerLogoIsDisplayed() {
        return elementIsDisplayed(FOOTER_LOGO);
    }
}
