package lib.ui.mobile_web;

import lib.ui.ListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWListPageObject extends ListPageObject {

    static {
        buttonViewList = "xpath##//XCUIElementTypeButton[@name='Saved']";
        buttonClosePopup = "xpath##//XCUIElementTypeButton[@name='Close']";
        itemArticle_TPL = "xpath##//li[contains(@class, 'with-watchstar')]//h3[contains(text(), '{ARTICLE_NAME}')]";
        buttonDeleteArticle = "xpath##//a[contains(@class,'watch-this-article')]";
        buttonDeleteArticle_TPL = "xpath##//li[contains(@class, 'with-watchstar') and @title='{ARTICLE_NAME}']//a[contains(@class,'watch-this-article')]";
    }

    public MWListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
