package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationObject extends NavigationObject {

    static {
        buttonBack = "xpath##//XCUIElementTypeButton[@name='Back']";
    }

    public IOSNavigationObject(RemoteWebDriver driver) {
        super(driver);
    }
}
