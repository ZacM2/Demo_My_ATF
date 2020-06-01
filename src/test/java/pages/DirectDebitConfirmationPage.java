package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class DirectDebitConfirmationPage extends GenericPage {

    final By CONFIRM_PAYMENT = By.id("submit-button");
    final By FOOTER_LINK = By.id("footer-link");
    final By REQUEST_MESSAGE = By.cssSelector("#main-content > div > div > div > h1");

    public void isDisplayed() {
        waitForElementToLoad(FOOTER_LINK);
        Assert.assertTrue("Payment Confirmation was not displayed", elementIsDisplayed(FOOTER_LINK));
    }


    public void clickConfirm() {
        waitForElementToBeClickable(FOOTER_LINK);
        if (elementIsDisplayed(CONFIRM_PAYMENT)){
            getDriver().findElement(CONFIRM_PAYMENT).click();
        } else System.out.println("link not found");

    }

    public boolean directDebitRequestReceivedMessagedDisplayed() {
        return getText(REQUEST_MESSAGE).equalsIgnoreCase(directDebitRequestReceived);
    }
}
