package pages;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.By;
import util.TypeLoader;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class SignInPage extends GenericPage {
    final By USERNAME_FIELD = By.id("Username");
    final By PASSWORD_FIELD = By.id("Password");
    final By SIGN_IN = By.id("submit-signin-local");
    final By ACCEPT_COOKIES = By.cssSelector("#acceptCookies");



//    String URL = "https://myatftest.powerappsportals.com/";
//    String userName2 = "TesterZ1";
//    String userName = "ZacMohamoud";
//    String password = "Password1";


    public SignInPage() {
        super();
    }

    public void goTo(){
        visit(URL);
    }

    public void enterUsername(String username){
        type(username,USERNAME_FIELD);
    }

    public void acceptCookies(){
        waitForElementToLoad(ACCEPT_COOKIES);
        click(ACCEPT_COOKIES);
    }


    public void enterPassword(String password){
        waitForElementToLoad(PASSWORD_FIELD);
        type(password,PASSWORD_FIELD);
    }

    public void clickSignIn(){
        click(SIGN_IN);
    }

    public void signInAsGenericUser(){
        getDriver().manage().window().maximize();
        visit(URL);
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        Properties properties = null;
        String username = "";
        String password = "";
        if (!variables.getProperty("webdriver.driver").equals("provided")) {
            String FILE_PATH = "conf/environment.properties";
            properties = new Properties();
            try {
                properties.load(Objects.requireNonNull(EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH)));
            } catch (IOException e) {
                System.out.println("Could not load properties from file");
            }
            username = properties.getProperty("app.username");
            password = properties.getProperty("app.password");
        }
        else {
            username = TypeLoader.getAppUsername();
            password = TypeLoader.getAppPassword();
            setDefaultBaseUrl(System.getProperty("baseUrl"));
        }
//        acceptCookies();
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }

//    public void signInAsGenericUser(){
//        getDriver().manage().window().maximize();
//    }

}
