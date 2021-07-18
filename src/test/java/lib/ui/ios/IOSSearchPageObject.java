package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        fieldsSearch = "id##Search Wikipedia";
        inputSearch = "id##Search Wikipedia";
        panelSearchResult = "xpath##//XCUIElementTypeCollectionView";
        itemSearchResult = "xpath##//XCUIElementTypeCell//XCUIElementTypeStaticText[1]";
        itemSearchResultDesc = "xpath##//XCUIElementTypeCell//XCUIElementTypeStaticText[2]";

        buttonClearSearch = "xpath##//XCUIElementTypeButton[@name='Clear text']";
        buttonCancelSearch = "xpath##//XCUIElementTypeStaticText[@name='Cancel']";
        panelSearchEmptyResult = "xpath##//XCUIElementTypeCollectionView";

        itemSearchResult_TPL = "xpath##//XCUIElementTypeCell//XCUIElementTypeStaticText[1]";
        itemSearchResultByTitleAndDescription_TPL = "xpath##//XCUIElementTypeCell//XCUIElementTypeStaticText[1][contains(@name, '{TITLE}')]/following-sibling::XCUIElementTypeStaticText[contains(@name, '{DESCRIPTION}')]";
    }

    public IOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
