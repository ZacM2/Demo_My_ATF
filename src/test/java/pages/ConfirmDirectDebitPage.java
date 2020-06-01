package pages;

import org.openqa.selenium.By;

public class ConfirmDirectDebitPage extends GenericPage {

    public SetUpDirectDebitPage setUpDirectDebitPage;


    final By HEADER = By.className("govuk-heading-l");
    final By DIRECT_DEBIT_AMOUNT = By.id("formattedAmount");
    final By DIRECT_DEBIT_DATE = By.id("formattedDate");
    final By PAYMENT_CHANGE_BUTTON = By.cssSelector("tr:nth-child(1) > td:nth-child(3) > a");
    final By DATE_CHANGE_BUTTON = By.cssSelector("tr:nth-child(2) > td:nth-child(3) > a");
    final By CANCEL_DIRECT_DEBIT_BUTTON = By.cssSelector("#main-content > a");
    final By CONFIRM_AND_CONTINUE_BUTTON = By.cssSelector("#main-content > button");




    public ConfirmDirectDebitPage() { super(); }


    public boolean confirmDirectDebitPageIsDisplayed() {
        waitForElementToLoad(HEADER);
        return elementIsDisplayedAndContainsText(HEADER, confirmDirectDebitHeader);
    }

    public boolean confirmDirectDebitAmountFieldIsDisplayed() {
        waitForElementToLoad(DIRECT_DEBIT_AMOUNT);
        return elementIsDisplayed(DIRECT_DEBIT_AMOUNT);
    }

    public boolean confirmDirectDebitAmountIsCorrect() {
        return SetUpDirectDebitPage.returnPriceEntered().contains(returnElementText(DIRECT_DEBIT_AMOUNT).replaceAll("£", "")
        );
    }

    public boolean confirmDirectDebitDateFieldIsDisplayed() {
        waitForElementToLoad(DIRECT_DEBIT_DATE);
        return elementIsDisplayed(DIRECT_DEBIT_DATE);
    }

    public boolean changeAmountButtonAvailable() {
        return elementIsDisplayed(PAYMENT_CHANGE_BUTTON);
    }

    public boolean changeDateButtonAvailable() {
        return elementIsDisplayed(DATE_CHANGE_BUTTON);
    }

    public void clickCancelButton() {
        click(CANCEL_DIRECT_DEBIT_BUTTON);
    }

    public void clickChangeAmount(){
        waitForElementToLoad(PAYMENT_CHANGE_BUTTON);
        click(PAYMENT_CHANGE_BUTTON);
    }

    public void clickChangeDate(){
        waitForElementToLoad(DATE_CHANGE_BUTTON);
        click(DATE_CHANGE_BUTTON);
    }

    public void clickConfirmAndContinue() {
        click(CONFIRM_AND_CONTINUE_BUTTON);
    }
}
