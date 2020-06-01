package pages;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.exec.environment.EnvironmentUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class CustomerPaymentManagementSystemPage extends GenericPage {

    final By TEST_MESSAGE = By.className("scp_test_environment_warning");
    final By CANCEL_LINK = By.className("scp_framework_cancelLink");
    final By PAGE_HEADER = By.className("govuk-heading-l");
    final By TRY_AGAIN_BUTTON = By.cssSelector("#main-content > form > button");
    final By CARD_NUMBER_FIELD = By.id("scp_cardPage_cardNumber_input");
    final By EXPIRY_DATE_FIELD_1 = By.id("scp_cardPage_expiryDate_input");
    final By EXPIRY_DATE_FIELD_2 = By.id("scp_cardPage_expiryDate_input2");
    final By SECURITY_CODE = By.id("scp_cardPage_csc_input");
    final By SUBMIT_PAYMENT_BUTTON = By.id("scp_cardPage_buttonsNoBack_continue_button");
    final By CARDHOLDER_NAME = By.id("scp_additionalInformationPage_cardholderName_input");
    final By EMAIL_ADDRESS_FIELD = By.id("scp_additionalInformationPage_email_input");
    final By EMAIL_ADDRESS_CONFIRMATION = By.id("scp_additionalInformationPage_emailConfirmation_input");
    final By ADDITIONAL_INFO_CONTINUE_BUTTON = By.id("scp_additionalInformationPage_buttons_continue_button");




    public CustomerPaymentManagementSystemPage() { super(); }

    public void isDisplayed() {
        waitForElementToLoad(TEST_MESSAGE);
        Assert.assertTrue("Go CPMS page was not displayed", getDriver().getTitle().equals(cpmsConfirmationHeader));
    }

    public void cancelPayment() {
        getDriver().findElement(CANCEL_LINK).click();
    }

    public void paymentUnsuccessfulScreenIsDisplayed() {
        waitForElementToBeClickable(TRY_AGAIN_BUTTON);
        getText(PAGE_HEADER).equals(unsuccessfulPaymentError);
    }

    public void enterCpmsPaymentDetails() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        Properties properties = null;
        String cardNumber = "";
        String expiryDate1 = "";
        String expiryDate2 = "";
        String securityCode = "";
        if (!variables.getProperty("webdriver.driver").equals("provided")) {
            String FILE_PATH = "conf/environment.properties";
            properties = new Properties();
            try {
                properties.load(Objects.requireNonNull(EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH)));
            } catch (IOException e) {
                System.out.println("Could not load properties from file");
            }
            cardNumber = properties.getProperty("app.cardNumber");
            expiryDate1 = properties.getProperty("app.expiryDate1");
            expiryDate2 = properties.getProperty("app.expiryDate2");
            securityCode = properties.getProperty("app.securityCode");
        }
        findAndSendText(CARD_NUMBER_FIELD, cardNumber);
        findAndSendText(EXPIRY_DATE_FIELD_1, expiryDate1);
        findAndSendText(EXPIRY_DATE_FIELD_2, expiryDate2);
        findAndSendText(SECURITY_CODE, securityCode);
    }

    public void clickCpmsSubmit(){
        findAndClick(SUBMIT_PAYMENT_BUTTON);
    }

    public void enterCpmsAdditionalDetails() {
        findAndSendText(CARDHOLDER_NAME, userName);
        findAndSendText(EMAIL_ADDRESS_FIELD, email);
        findAndSendText(EMAIL_ADDRESS_CONFIRMATION,email);
    }

    public void clickContinueAdditionalDetails(){
        findAndClick(ADDITIONAL_INFO_CONTINUE_BUTTON);
    }
}
