package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSListPageObject extends ListPageObject {

    static {
        buttonViewList = "xpath##//XCUIElementTypeButton[@name='Saved']";
        buttonClosePopup = "xpath##//XCUIElementTypeButton[@name='Close']";
        itemArticle_TPL = "xpath##//XCUIElementTypeCell//XCUIElementTypeStaticText[1][contains(@name, '{ARTICLE_NAME}')]";
        buttonDeleteArticle = "xpath##//XCUIElementTypeButton[@name='swipe action delete']";
    }

    public IOSListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
