package pages;

import org.openqa.selenium.By;

public class PaymentConfirmationPage extends GenericPage {

    final By CONFIRMATION_PAGE_HEADER = By.id("scp_confirmationPage_header");
    final By CONFIRMATION_PAGE_SUBMIT_BUTTON = By.id("scp_confirmationPage_buttons_payment_button");
    final By CONFIRMATION_PAGE_BACK_BUTTON = By.id("scp_confirmationPage_buttons_back_button");
    final By PAYMENT_AMOUNT = By.cssSelector("#scp_purchase_details_total > tr > td.scp_amount");



    public boolean pageIsDisplayed() {
        waitForElementToLoad(CONFIRMATION_PAGE_HEADER);
        return elementIsDisplayedAndContainsText(CONFIRMATION_PAGE_HEADER, cardPaymentConfirmationPageHeader);
    }

    public boolean paymentAmountEqualsTopUpValue(String returnTopUpAmount) {
        return getText(PAYMENT_AMOUNT).replaceAll("£", "").equals(returnTopUpAmount);
    }

    public void clickMakePayment() {
        findAndClick(CONFIRMATION_PAGE_SUBMIT_BUTTON);
    }
}
