package pages;

import org.openqa.selenium.By;

public class TopUpByCardPage extends GenericPage {

    private static String randomDouble = returnRandomDouble(50,100);
    private static String minimumValue = returnRandomDouble(0,50);
    final By ERROR_TITLE = By.id("error-summary-title");
    final By ERROR_MESSAGE = By.cssSelector("#notificationArea > div > div > ul > li > a");
    final By CANCEL_BUTTON = By.cssSelector("#main-content > a");
    final By CONTINUE_BUTTON = By.cssSelector("#main-content > button");
    final By HEADER = By.cssSelector("#main-content > h2");
    final By TOP_UP_AMOUNT_FIELD = By.id("amount");


    public TopUpByCardPage() { super(); }


    public void clickCancel() {
        waitForElementToLoad(CANCEL_BUTTON);
        getDriver().findElement(CANCEL_BUTTON).click();
    }

    public boolean pageIsDisplayed() {
        waitForElementToLoad(HEADER);
        return getDriver().findElement(HEADER).getText().equals(headerText);
    }

    public boolean continueLinkIsDisplayed() {
        return getDriver().findElement(CONTINUE_BUTTON).isDisplayed();
    }

    public boolean cancelLinkIsDisplayed() {
        return getDriver().findElement(CANCEL_BUTTON).isDisplayed();
    }

    public void clickContinue() {
        waitForElementToLoad(CONTINUE_BUTTON);
        getDriver().findElement(CONTINUE_BUTTON).click();
    }

    public void enterTopAmountToBusinessRules() {
        waitForElementToLoad(TOP_UP_AMOUNT_FIELD);
        type(randomDouble, TOP_UP_AMOUNT_FIELD);
    }

    public static String returnTopUpAmount(){
        String topUpValue = randomDouble.substring(0,5);
        return topUpValue;
    }

    public boolean errorTitleIsDisplayed() {
        return getDriver().findElement(ERROR_TITLE).getText().equals(errorTitle);
    }

    public boolean errorMessageIsDisplayed(String errorType){
        boolean errorMessageDisplayed = false;
        if (errorType.equals("top up amount missing")) {
            errorMessageDisplayed = getDriver().findElement(ERROR_MESSAGE).getText().equals(noSumErrorMessage);
        } else if (errorType.equals("below minimum value")){
            errorMessageDisplayed = getDriver().findElement(ERROR_MESSAGE).getText().equals(belowMinimumValueErrorMessage);
        } return errorMessageDisplayed;
    }

    public void enterTopUpAmountBelowMinimalValue() {
        type(minimumValue, TOP_UP_AMOUNT_FIELD);
    }

    public boolean previousSumIsPrePopulated() {
        return TopUpByCardPage.returnTopUpAmount().contains(getDriver().findElement(TOP_UP_AMOUNT_FIELD).getText()
                .replaceAll("£", ""));
    }
}
