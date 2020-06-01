package pages;

import org.openqa.selenium.By;

public class ChangeDirectDebitPage extends GenericPage {

    final By HEADER = By.cssSelector(".govuk-heading-l");
    final By CONFIRM_BUTTON = By.cssSelector("#main-content > button");
    final By CONTINUE_BUTTON = By.cssSelector("#changeDDArea > button");

    public ChangeDirectDebitPage() { super(); }


    public void changeYourDirectDebitPageIsDisplayed() {
        waitForElementToLoad(HEADER);
        elementIsDisplayedAndContainsText(HEADER, changeDirectDebitHeader);
    }


    public void clickConfirm() {
        findAndClick(CONFIRM_BUTTON);
    }

    public void clickContinue() {
        waitForElementToLoad(CONTINUE_BUTTON);
        click(CONTINUE_BUTTON);
    }
}
