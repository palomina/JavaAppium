package lib.ui.factories;

import lib.Platform;
import lib.ui.ListPageObject;
import lib.ui.android.AndroidListPageObject;
import lib.ui.ios.IOSListPageObject;
import lib.ui.mobile_web.MWListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ListPageObjectFactory {
    public static ListPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidListPageObject(driver);
        } else  if (Platform.getInstance().isIOS()){
            return new IOSListPageObject(driver);
        } else {
            return new MWListPageObject(driver);
        }
    }
}
