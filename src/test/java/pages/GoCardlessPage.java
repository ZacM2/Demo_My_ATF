package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class GoCardlessPage extends GenericPage {

    final By HEADER = By.className("payment-details__name");
    final By FIRST_NAME_FIELD = By.id("customer_given_name");
    final By LAST_NAME_FIELD = By.id("customer_family_name");
    final By EMAIL_FIELD = By.id("customer_email");
    final By SORT_CODE_FIELD = By.id("customer_bank_accounts_branch_code");
    final By ACCOUNT_NUMBER_FIELD = By.id("customer_bank_accounts_account_number");
    final By POSTCODE_FIELD = By.id("address_lookup");
    final By DROPDOWN_ADDRESS_OPTION = By.cssSelector("button[class*=dropdown__item__button]");
    final By CONFIRM_DIRECT_DEBIT_BUTTON = By.cssSelector("#submit-button");
    final By ADDRESS_SECOND_LINE = By.id("customer_address_line2");





    public GoCardlessPage() { super(); }

    public void isDisplayed() {
        waitForElementToLoad(CONFIRM_DIRECT_DEBIT_BUTTON);
        waitForElementToBeClickable(FIRST_NAME_FIELD);
        Assert.assertTrue("Go Cardless Page was not displayed", getText(HEADER).equals(goCardlessHeader));
    }

    public void enterName() {
        findAndSendText(FIRST_NAME_FIELD, name);
        findAndSendText(LAST_NAME_FIELD, name);
    }

    public void enterEmailAddress() {
        findAndSendText(EMAIL_FIELD, email);
    }

    public void enterPaymentDetails() {
        findAndSendText(SORT_CODE_FIELD, sortCode);
        findAndSendText(ACCOUNT_NUMBER_FIELD, accountNumber);
    }

    public void enterAddressAndSelectFirstOption() {
        findAndSendText(POSTCODE_FIELD, "123");
        getDriver().findElements(DROPDOWN_ADDRESS_OPTION).get(0).click();
        click(ADDRESS_SECOND_LINE);
    }

    public void clickSetUpDirectDebit() {
        click(CONFIRM_DIRECT_DEBIT_BUTTON);
    }
}
