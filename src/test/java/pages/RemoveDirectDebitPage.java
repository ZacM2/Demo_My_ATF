package pages;

import org.openqa.selenium.By;

public class RemoveDirectDebitPage extends GenericPage {

    final By PAGE_HEADING = By.cssSelector(".govuk-heading-l");
    final By CONFIRM_AND_CONTINUE = By.cssSelector("#main-content > button");


    public RemoveDirectDebitPage() { super(); }


    public boolean isDisplayed() {
        return elementIsDisplayedAndContainsText(PAGE_HEADING, headerText);
    }

    public void clickConfirmAndContinue(){
        findAndClick(CONFIRM_AND_CONTINUE);
    }


}
