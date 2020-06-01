package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopUpAccountPage extends GenericPage {

    final By TOP_UP_BY_CARD = By.cssSelector("#main-content > form > button");
    final By TOP_UP_BY_DIRECT_DEBIT = By.cssSelector("#ddDetails > form > button");
    final By TOP_UP_BUTTON = By.cssSelector(".govuk-button");
    final By TOP_UP_ACCOUNT_HEADING = By.id("jump-link");
    final By CHANGE_DIRECT_DEBIT = By.cssSelector("a[href*=DirectDebitChange]");
    final By REMOVE_DIRECT_DEBIT = By.cssSelector("a[href*=RemoveDirectDebit]");

    public TopUpAccountPage() { super(); }

    public void clickTopUpByCard(){
        waitForElementToLoad(TOP_UP_BY_CARD);
        getDriver().findElement(TOP_UP_BY_CARD).click();
    }

    public void clickTopUpByDirectDebit(){
        waitForElementToLoad(TOP_UP_BY_DIRECT_DEBIT);
        click(TOP_UP_BY_DIRECT_DEBIT);
    }


    public boolean topUpAccountPageIsDisplayed() {
        waitForElementToLoad(TOP_UP_ACCOUNT_HEADING);
        return getDriver().findElement(TOP_UP_ACCOUNT_HEADING).getText().equals(topUpAccountHeader);
    }

    public void clickChangeDirectDebit() {
        waitForElementToLoad(CHANGE_DIRECT_DEBIT);
        getDriver().findElement(CHANGE_DIRECT_DEBIT).click();
    }

    public void clickCancelDirectDebit() {
        waitForElementToLoad(REMOVE_DIRECT_DEBIT);
        getDriver().findElement(REMOVE_DIRECT_DEBIT).click();
    }
}
