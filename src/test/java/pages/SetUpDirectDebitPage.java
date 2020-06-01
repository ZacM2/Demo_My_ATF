package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.List;


public class SetUpDirectDebitPage extends GenericPage {

    private static String directDebitDate = null;
    private static String randomDouble = returnRandomDouble(50,100);
    private static String minimumValue = returnRandomDouble(0,50);
    final By HEADER = By.cssSelector(".govuk-heading-l");
    final By TEST_FACILITY_DETAILS = By.cssSelector(".govuk-caption-m");
    final By AMOUNT_LABEL = By.cssSelector("#amountLabel");
    final By MINIMUM_TOPUP_AMOUNT = By.cssSelector("#amount-area > p");
    final By PAYMENT_AMOUNT_FIELD = By.id("amount");
    final By REPEAT_PAYMENT_DATES = By.cssSelector("#date-area > fieldset > div > div > label");
    final By REPEAT_PAYMENT_DATES_BUTTONS = By.cssSelector(".govuk-radios__input");
    final By ACCOUNT_ACTIVITY_BREADCRUMB = By.cssSelector("ol > li:nth-child(2) > a");
    final By SUBMIT_BUTTON = By.cssSelector("#main-content > button");
    final By ERROR_SUMMARY_TITLE = By.id("error-summary-title");
    final By ERROR_SUMMARY_BODY = By.className("govuk-error-summary__body");
    final By AMOUNT_ERROR =  By.id("amount-error");
    final By DATE_ERROR = By.id("date-error");
    final By DATE_LABEL = By.id("dateLabel");



    public SetUpDirectDebitPage() { super(); }

    private static DecimalFormat df = new DecimalFormat("0.00");

    public boolean setUpDirectDebitPageIsDisplayed(){
        waitForElementToLoad(HEADER);
        return elementIsDisplayedAndContainsText(HEADER, setUpDirectDebitHeader);
    }

    public boolean testFacilityDetailsIsDisplayed(){
        waitForElementToLoad(TEST_FACILITY_DETAILS);
        return elementIsDisplayed(TEST_FACILITY_DETAILS);
    }

    public boolean paymentAmountTextDisplayed() {
        waitForElementToLoad(AMOUNT_LABEL);
        return elementIsDisplayed(AMOUNT_LABEL);
    }

    public boolean minimumPaymentAmountDisplayed(){
        return elementIsDisplayed(MINIMUM_TOPUP_AMOUNT);
    }


    public boolean paymentDatesAreDisplayed() {
        boolean datesDisplayed = true;
        List<WebElement> paymentDateButtons =  getDriver().findElements(REPEAT_PAYMENT_DATES);
        for (WebElement date : paymentDateButtons){
            if (!date.getText().contains("of each month")){
                datesDisplayed = false;
            }
        } return datesDisplayed;
    }

    public boolean paymentDateButtonsAreClickable() {
        boolean buttonDisplayed = true;
        List<WebElement> paymentDateButtons = getDriver().findElements(REPEAT_PAYMENT_DATES_BUTTONS);
        for (WebElement button : paymentDateButtons){
            button.click();
            if (!button.isEnabled()){
                buttonDisplayed = false;
            }

        } return buttonDisplayed;
    }

    public void enterValueFollowingBusinessRules() {
        type(randomDouble, PAYMENT_AMOUNT_FIELD);
    }

    public void returnToAccountActivitiesPage() {
        click(ACCOUNT_ACTIVITY_BREADCRUMB);
    }

    public void selectRandomDirectDebitDate() {
        waitForElementToLoad(DATE_LABEL);
        int dateIndex = getRandomNumberInRange(0,1);
        List<WebElement> paymentDateButtons = getDriver().findElements(REPEAT_PAYMENT_DATES_BUTTONS);
        WebElement randomElement = paymentDateButtons.get(dateIndex);
        randomElement.click();
        directDebitDate = getDriver().findElements(REPEAT_PAYMENT_DATES).get(dateIndex).getText();
    }

    public void clickContinueButton() {
        waitForElementToLoad(SUBMIT_BUTTON);
        click(SUBMIT_BUTTON);
    }

    public boolean errorMessageTitleDisplayed() {
        waitForElementToLoad(ERROR_SUMMARY_TITLE);
        boolean paymentErrorInformationDisplayed = false;
        if ((elementIsDisplayed(ERROR_SUMMARY_TITLE)) || (getText(ERROR_SUMMARY_TITLE).equalsIgnoreCase(ErrorSummaryTitleText))){
            paymentErrorInformationDisplayed = true;
        } return paymentErrorInformationDisplayed;
    }

    public boolean noPaymentAmountErrorBodyTextShown() {
        waitForElementToLoad(ERROR_SUMMARY_TITLE);
        boolean paymentErrorBodyTextDisplayed = false;
        if ((elementIsDisplayed(ERROR_SUMMARY_BODY)) ||
                (getText(ERROR_SUMMARY_BODY).equalsIgnoreCase(noSumSpecifiedErrorSummaryBodyText)) ||
                (getText(AMOUNT_ERROR).equals(noSumSpecifiedErrorSummaryBodyText))){
            paymentErrorBodyTextDisplayed = true;
        } return paymentErrorBodyTextDisplayed;
    }

    public boolean minimumTopUpErrorBodyTextShown() {
        waitForElementToLoad(ERROR_SUMMARY_TITLE);
        boolean minimumTopUpErrorInformationDisplayed = false;
        if ((elementIsDisplayed(ERROR_SUMMARY_BODY)) ||
                (getText(ERROR_SUMMARY_BODY).equalsIgnoreCase(minimalValueErrorSummaryBodyText)) ||
                (getText(AMOUNT_ERROR).equals(minimalValueErrorSummaryBodyText))){
            minimumTopUpErrorInformationDisplayed = true;
        } return minimumTopUpErrorInformationDisplayed;
    }

    public boolean noDateSpecifiedErrorBodyTextShown() {
        waitForElementToLoad(ERROR_SUMMARY_TITLE);
        boolean noDateErrorInformationDisplayed = false;
        if ((elementIsDisplayed(ERROR_SUMMARY_BODY)) ||
                (getText(ERROR_SUMMARY_BODY).equalsIgnoreCase(noDateErrorSummaryBodyText)) ||
                (getText(DATE_LABEL).equals(noDateErrorSummaryBodyText))){
            noDateErrorInformationDisplayed = true;
        } return noDateErrorInformationDisplayed;
    }

    public void enterValueBelowMinimumAmount() {
        type(minimumValue, PAYMENT_AMOUNT_FIELD);
    }

    public static String returnPriceEntered(){
        String doubleValue = randomDouble;
        return doubleValue;
    }

    public boolean noSelectionMadeErrorBodyTextShown() {
        waitForElementToLoad(ERROR_SUMMARY_TITLE);
        boolean noSelectionMadeErrorInformationDisplayed = false;
        if ((elementIsDisplayed(ERROR_SUMMARY_BODY)) ||
                (getDriver().findElement(DATE_ERROR).getText().equals(noDateErrorSummaryBodyText))||
                (getDriver().findElement(AMOUNT_ERROR).getText().equals(noSumSpecifiedErrorSummaryBodyText))
        ){
            noSelectionMadeErrorInformationDisplayed = true;
        } return noSelectionMadeErrorInformationDisplayed;
    }

    private boolean isChecked;
    private WebElement e;

    public void selectFifthOfMonth() {
        WebElement button = getDriver().findElements(REPEAT_PAYMENT_DATES_BUTTONS).get(0);
        button.click();
        directDebitDate = getDriver().findElements(REPEAT_PAYMENT_DATES).get(0).getText();
    }

    public static String returnDirectDebitDate(){
        return directDebitDate;
    }

    public void selectTwentiethOfMonth() {
        WebElement button = getDriver().findElements(REPEAT_PAYMENT_DATES_BUTTONS).get(1);
        button.click();
        directDebitDate = getDriver().findElements(REPEAT_PAYMENT_DATES).get(1).getText();
    }

    public boolean confirmDirectDebitAmountIsCorrect() {
        return SetUpDirectDebitPage.returnPriceEntered().contains(getDriver().findElement(PAYMENT_AMOUNT_FIELD).getText().replaceAll("£", "")
        );
    }

    public boolean confirmDirectDebitDateIsCorrect() {
        boolean dateCheckedIsCorrect = false;
        if (SetUpDirectDebitPage.returnDirectDebitDate().equals("5th of each month")){
            dateCheckedIsCorrect = getDriver().findElements(REPEAT_PAYMENT_DATES_BUTTONS).get(0).getAttribute("checked").equals("true");
        } else if (SetUpDirectDebitPage.returnDirectDebitDate().equals("20th of each month")){
            dateCheckedIsCorrect = getDriver().findElements(REPEAT_PAYMENT_DATES_BUTTONS).get(1).getAttribute("checked").equals("true");
        } return dateCheckedIsCorrect;
    }
}
