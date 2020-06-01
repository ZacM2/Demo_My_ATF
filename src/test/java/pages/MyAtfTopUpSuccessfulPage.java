package pages;

import org.openqa.selenium.By;

public class MyAtfTopUpSuccessfulPage extends GenericPage {

    final By TOP_UP_SUCCESSFUL_HEADER = By.cssSelector("#main-content > div > h1");
    final By INVOICE_NUMBER = By.cssSelector("#main-content > div > p > strong");



    public boolean pageIsDisplayed() {
        waitForElementToLoad(TOP_UP_SUCCESSFUL_HEADER);
        return elementIsDisplayedAndContainsPartOfText(TOP_UP_SUCCESSFUL_HEADER, topUpSuccessfulHeader);
    }

    public boolean invoiceNumberIsDisplayedCorrectly(){
        return elementIsDisplayedAndContainsPartOfText(INVOICE_NUMBER, invoiceNumberPrefix);
    }

}
