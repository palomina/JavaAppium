package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationObject extends NavigationObject {

    static {
        buttonBack = "xpath##//android.widget.ImageButton[@content-desc='Navigate up']";
    }

    public AndroidNavigationObject(RemoteWebDriver driver) {
        super(driver);
    }
}
