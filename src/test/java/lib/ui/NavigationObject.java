package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class NavigationObject extends MainPageObject {

    protected static String
            buttonBack,
            buttonMenu,
            menuLogin,
            menuWatchlist;

    public NavigationObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void back() {
        this.waitElementAndClick(
                getLocator(buttonBack),
                "Can't click to the button `Back`",
                20
        );
    }

    public void openMenu() {
        this.waitElementAndClick(
                getLocator(buttonMenu),
                "Can't open menu",
                20
        );
    }

    public void clickAuthButton() {
        this.openMenu();
        this.tryElementClick(
                getLocator(menuLogin),
                "Cannot find auth button",
                20
        );
    }

    public void clickWatchlistButton() {
        this.openMenu();
        this.tryElementClick(
                getLocator(menuWatchlist),
                "Cannot find watchlist button",
                20
        );
    }

}
