package pages;

import org.openqa.selenium.By;

public class ConfirmTopUpPage extends GenericPage {
    final By PAYMENT_AMOUNT = By.id("formattedAmount");
    final By HEADER = By.cssSelector("#titleArea > h2");
    final By CANCEL_LINK = By.cssSelector("#contentArea > a");
    final By CONFIRM_LINK = By.cssSelector("#contentArea > button");
    final By CHANGE_HYPERLINK = By.id("changeAmount");
    final By HELPFUL_TEXT = By.cssSelector("#contentArea > div");


    public ConfirmTopUpPage() { super(); }


    public boolean correctTopUpValueIsDisplayed() {
        return TopUpByCardPage.returnTopUpAmount().contains(getDriver().findElement(PAYMENT_AMOUNT)
                .getText().replaceAll("£", ""));
    }

    public boolean isCancelLinkDisplayed() {
        return elementIsDisplayed(CANCEL_LINK);
    }

    public boolean isConfirmButtonDisplayed() {
        return elementIsDisplayed(CONFIRM_LINK);
    }

    public boolean isHelpfulTextDisplayed() {
        return elementIsDisplayed(HELPFUL_TEXT);
    }

    public boolean isChangeHyperLinkDisplayed() {
        return elementIsDisplayed(CHANGE_HYPERLINK);
    }

    public boolean isHeadingDisplayed() {
        waitForElementToLoad(HEADER);
        return getText(HEADER).equalsIgnoreCase(confirmTopUpAmountHeder);
    }

    public void clickConfirmButton() {
        click(CONFIRM_LINK);
    }

    public void clickCancelButton() {
        click(CANCEL_LINK);
    }

    public boolean previousSumIsPrePopulated() {
        return TopUpByCardPage.returnTopUpAmount().contains(getText(PAYMENT_AMOUNT)
                .replaceAll("£", ""));
    }

    public void clickChangeButton() {
        click(CHANGE_HYPERLINK);
    }
}
