package pages;

import org.openqa.selenium.By;

public class AccountActivityPage extends GenericPage {

    final By ACCOUNT_ACTIVITY_TITLE = By.cssSelector(".govuk-heading-l");
    final By TOP_UP_ACCOUNT = By.cssSelector("a[href*=TopUp]");
    final By ERROR_SUMMARY = By.id("error-summary-title");
    final By GOV_UK_HEADER = By.className("govuk-header__logotype-text");



    public AccountActivityPage() { super(); }

    public boolean accountActivityPageIsDisplayed(){
        waitForElementToLoad(ACCOUNT_ACTIVITY_TITLE);
        return elementIsDisplayed(ACCOUNT_ACTIVITY_TITLE);
    }

    public boolean govUkHeaderDisplayed(){
        return elementIsDisplayedAndContainsText(GOV_UK_HEADER,govHeader);
    }



    public void clickTopUpAccount(){
        waitForElementToLoad(TOP_UP_ACCOUNT);
        findAndClick(TOP_UP_ACCOUNT);
    }

    public boolean errorMessageIsDisplayed(){
        return elementIsDisplayedAndContainsText(ERROR_SUMMARY, removedDirectDebitErrorText);
    }

}
