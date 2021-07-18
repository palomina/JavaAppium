package lib.ui.mobile_web;

import lib.ui.NavigationObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationObject extends NavigationObject {

    static {
        buttonBack = "xpath##//XCUIElementTypeButton[@name='Back']";
        buttonMenu = "id##mw-mf-main-menu-button";
        menuLogin = "xpath##//a[contains(@class, 'menu__item--login')]";
        menuWatchlist = "xpath##//a[contains(@class, 'menu__item--unStar')]";
    }

    public MWNavigationObject(RemoteWebDriver driver) {
        super(driver);
    }
}
