package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
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

    @Step("Click button back")
    public void back() {
        this.waitElementAndClick(
                getLocator(buttonBack),
                "Can't click to the button `Back`",
                20
        );
    }

    @Step("Open menu")
    public void openMenu() {
        this.waitElementAndClick(
                getLocator(buttonMenu),
                "Can't open menu",
                20
        );
    }

    @Step("Click auth button")
    public void clickAuthButton() {
        this.openMenu();
        screenshot(this.takeScreenshot("click_auth"));
        this.tryElementClick(
                getLocator(menuLogin),
                "Cannot find auth button",
                20
        );
    }

    @Step("Click watchlist button")
    public void clickWatchlistButton() {
        this.openMenu();
        screenshot(this.takeScreenshot("click_watchlist"));
        this.tryElementClick(
                getLocator(menuWatchlist),
                "Cannot find watchlist button",
                20
        );
    }

}
