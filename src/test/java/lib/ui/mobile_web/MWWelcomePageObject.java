package lib.ui.mobile_web;

import lib.ui.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWWelcomePageObject extends WelcomePageObject {
    static {
        buttonSkip = "xpath##//button[@id='searchIcon']";

    }
    public MWWelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
