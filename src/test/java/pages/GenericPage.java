package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Random;

import static java.time.Duration.ofMillis;

public class GenericPage extends PageObject {

    static final String SPINNER = "div.spinner-container";
    static final String HEADER_ERROR = "div.govuk-error-summary";
    static final String HEADER_SPECIFIC_ERRORS = "div.govuk-error-summary>span.govuk-error-message";
    static final String SIGNOUT_CONFIRMATION_SCREEN = "vtm-logout-modal";

    public static String govHeader = "GOV.UK";
    public static String removedDirectDebitErrorText = "Your direct debit has been removed";
    public static String confirmDirectDebitHeader = "Confirm your direct debit";
    public static String confirmTopUpAmountHeder = "confirm your top up amount";
    public static String cpmsConfirmationHeader = "Customer Payment Management System";
    public static String unsuccessfulPaymentError = "Your payment was unsuccessful";
    public static String directDebitRequestReceived = "Direct debit set up request received";
    public static String setUpDirectDebitHeader = "Set up a direct debit";
    public static String name = "test";
    public static String email = "test@test.com";
    public static String sortCode = "232323";
    public static String accountNumber = "23232323";
    public static String headerText = "Remove direct debit";
    public static final String ErrorSummaryTitleText = "There is a problem";
    public static final String noSumSpecifiedErrorSummaryBodyText = "Enter a payment amount";
    public static final String minimalValueErrorSummaryBodyText = "Enter an amount more than £50";
    public static final String noDateErrorSummaryBodyText = "Select a payment date";
    public static String URL = "https://myatftest.powerappsportals.com/";
    public static String userName = "ZacMohamoud";
    public static String topUpAccountHeader = "Top up account";
    public static String topUpByCardHeader = "Top up by card";
    public static String errorTitle = "There is a problem";
    public static String noSumErrorMessage = "Enter a top up amount";
    public static String belowMinimumValueErrorMessage = "Enter an amount more than £50";
    public static String changeDirectDebitHeader = "Change direct debit";
    public static String govUkMainHeaderText = "Manage your Authorised Testing Facility";
    public static String govUkLogoText = "GOV.UK";
    public static String signOutButtonText = "Sign out";
    public static String goCardlessHeader = "Set up a Direct Debit with BJSS";
    public static String siteManagementHeader = "Site management";
    public static String cardPaymentConfirmationPageHeader = "Payment Confirmation Page";
    public static String topUpSuccessfulHeader = "Top up successful";
    public static String invoiceNumberPrefix = "CVS";

    public void checkTextInElementWithCssSelector(String cssSelector, String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(cssSelector), text));

    }

    public void checkTextInElementWithXpath(String xpath, String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
    }

    public void checkTextIsPresentInPage(String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("body"), text));
    }

    public void checkTextIsNotPresentInPage(String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.not(ExpectedConditions.
                textToBePresentInElementLocated(By.cssSelector("body"), text)));
    }

    public void waitForPageToLoad() {
        new WebDriverWait(getDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }

    public void click(By locator) {
        find(locator).click();
    }

    public String returnElementText(By locator){
        return getDriver().findElement(locator).getText();
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void visit(String url) {
        getDriver().get(url);
    }

    public String removeSpaces(String input){
        String output;
        output = input.replaceAll(" ", "");
        return output;
    }

    public boolean elementIsDisplayedAndContainsPartOfText(By locator, String text) {
        return getDriver().findElement(locator).getText().contains(text);
    }

    public void findAndSendText(By locator, String text){
        getDriver().findElement(locator).sendKeys(text);
    }

    public void logOut() {
            getDriver().get("https://myatftest.powerappsportals.com/Account/Login/Logoff");
    }

    public boolean elementIsDisplayed (By locator){
        return getDriver().findElement(locator).isDisplayed();
    }

    public boolean elementIsDisplayedAndContainsText(By locator, String text) {
        return getDriver().findElement(locator).getText().equals(text);
    }

    public void findAndClick(By locator){
        waitForElementToLoad(locator);
        getDriver().findElement(locator).click();
    }

    public void type(String inputText, By locator) { find(locator).sendKeys(inputText); }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    public void waitForElementToLoad(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement findElementByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

    public static String returnRandomDouble(int minValue, int maxValue){
        Random r = new Random();
        double randomValue = minValue + (maxValue - minValue) * r.nextDouble();
        return String.valueOf(randomValue);
    }

    protected WebElement findElementByXpath(String xpath) {
        System.out.println("Finding element: " + xpath);
        return getDriver().findElement(By.xpath(xpath));
    }
    protected List<WebElement> findElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected WebElement findElementByText(String text) {
        System.out.println("Finding element with text: " + text);
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
    }

    protected WebElement findElementByCss(String css) {
        System.out.println("Finding element: " + css);
        return getDriver().findElement(By.cssSelector(css));
    }

    protected void scrollToAndClickByCss(String css) {
        System.out.println("Finding element: " + css);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementByCss(css));
        actions.perform();
        getDriver().findElement(By.cssSelector(css)).click();
    }

    protected void scrollToAndClickByXpath(String xpath) {
        System.out.println("Finding element: " + xpath);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementByXpath(xpath));
        actions.perform();
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public void selectCheckbox(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")));
        if (!(getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).isSelected())) {
            getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).click();
        }
    }

    public void deselectCheckbox(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")));
        if (getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).isSelected()) {
            getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).click();
        }
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void clearSessionStorage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.sessionStorage.clear()");
    }

    public void elementWithIdShouldBePresent(String id) {
        waitForRenderedElementsToBePresent(By.id(id));
    }

    public void navigateAwayFromVtmAndGoBack() {
        String homePageUrl = null;
        if (getDriver().getCurrentUrl().contains("localhost")) {
            homePageUrl = getDriver().getCurrentUrl();
        }
        else {
            int pos = StringUtils.ordinalIndexOf(getDriver().getCurrentUrl(), "/", 4);
            if (pos != -1) {
                homePageUrl = getDriver().getCurrentUrl().substring(0, pos) + "/index.html";
            }
            else {
                homePageUrl = getDriver().getCurrentUrl() + "index.html";
            }
        }
        getDriver().get("https://www.gov.uk/government/organisations/driver-and-vehicle-standards-agency");
        waitForTextToAppear("Driver and Vehicle Standards Agency");
        getDriver().get(homePageUrl);
    }

    public void checkTextIsPresentInHyperlink(String text) {
        Assert.assertNotNull("Hyperlink with text was not found!", getDriver().findElement(By.xpath(
                "//a[contains(text(),'" + text + "')] | //a/span[contains(text(),'" + text + "')]")));
    }

    public void checkTextIsPresentInButton(String text) {
        Assert.assertNotNull("Button with text was not found!", getDriver().findElement(By.xpath(
                "//button[contains(text(),'" + text + "')]")));
    }

    public void clickButton(String text) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(text(),'" + text + "')]")));
        findElementByXpath("//button[contains(text(),'" + text + "')]").click();
        try {
            FluentWait spinnerWait = globalFluentWait(1, 200);
            spinnerWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
            waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        }
        catch (TimeoutException e) {
            System.out.println("Spinner did not appear");
        }
        waitForAngularRequestsToFinish();
    }

    public void clickLink(String text) {
        String locator = "//a[contains(text(),'" + text + "')] | //a/span[contains(text(),'" + text + "')]";
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        findElementByXpath(locator).click();
        try {
            FluentWait spinnerWait = globalFluentWait(1, 200);
            spinnerWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SPINNER)));
            waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        }
        catch (TimeoutException e) {
            System.out.println("Spinner did not appear");
        }
    }


    void selectOptionFromDropdown(WebElement element, String searchCriteria) {
        new Select(element).selectByValue(searchCriteria);
    }

    public void headerErrorContains(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(HEADER_ERROR), text));
    }

    public void headerErrorNotContains(String text) {
        waitForRenderedElementsToDisappear(By.cssSelector(SPINNER));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_ERROR)));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(HEADER_SPECIFIC_ERRORS)));
        Assert.assertFalse(findElementByCss(HEADER_SPECIFIC_ERRORS).getText().contains(text));
    }

    public void goBackToPreviousPage() {
        getDriver().navigate().back();
    }

    public void checkPageUrl(String url) {
        Assert.assertEquals(url, getDriver().getCurrentUrl());
    }

    public void checkSignOutScreenNotPresent() {
        Assert.assertEquals(0, getDriver().findElements(By.cssSelector(SIGNOUT_CONFIRMATION_SCREEN)).size());
    }

    void inputText(WebElement field, String text) {
        if (text.contentEquals("")) {
            int limit = field.getAttribute("value").length();
            for (int i = 0; i < limit; i++) {
                field.sendKeys(Keys.BACK_SPACE);
            }
        } else {
            field.clear();
            field.sendKeys(text);
        }
    }

    FluentWait globalFluentWait(int timeOutSeconds, int pollingEveryMilliseconds) {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeOutSeconds))
                .pollingEvery(ofMillis(pollingEveryMilliseconds))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        return wait;
    }
}
