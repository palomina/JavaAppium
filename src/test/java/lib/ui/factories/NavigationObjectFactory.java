package lib.ui.factories;

import lib.Platform;
import lib.ui.NavigationObject;
import lib.ui.android.AndroidNavigationObject;
import lib.ui.ios.IOSNavigationObject;
import lib.ui.mobile_web.MWNavigationObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationObjectFactory {
    public static NavigationObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSNavigationObject(driver);
        } else {
            return new MWNavigationObject(driver);
        }
    }
}
