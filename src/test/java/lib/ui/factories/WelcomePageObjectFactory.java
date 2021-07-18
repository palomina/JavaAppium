package lib.ui.factories;

import lib.Platform;
import lib.ui.WelcomePageObject;
import lib.ui.android.AndroidWelcomePageObject;
import lib.ui.ios.IOSWelcomePageObject;
import lib.ui.mobile_web.MWWelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObjectFactory {
    public static WelcomePageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidWelcomePageObject(driver);
        } else if (Platform.getInstance().isIOS()){
            return new IOSWelcomePageObject(driver);
        } else {
            return new MWWelcomePageObject(driver);
        }
    }
}
