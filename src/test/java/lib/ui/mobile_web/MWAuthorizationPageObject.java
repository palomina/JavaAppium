package lib.ui.mobile_web;

import lib.ui.AuthorizationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWAuthorizationPageObject extends AuthorizationPageObject {

    static {
        inputLogin = "xpath##//input[@name='wpName']";
        inputPassword = "xpath##//input[@name='wpPassword']";
        buttonLogin = "xpath##//button[@id='wpLoginAttempt']";
    }

    public MWAuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void enterLoginData(String login, String password) {
        this.waitElementAndSendKeys(
                getLocator(inputLogin),
                login,
                "Cannot find and put a login to login input",
                20
        );
        this.waitElementAndSendKeys(
                getLocator(inputPassword),
                password,
                "Cannot find and put a login to login input",
                20
        );
    }

    public void submitForm() {
        this.waitElementAndClick(
                getLocator(buttonLogin),
                "Cannot find and click submit auth button",
                20
        );
    }
}
