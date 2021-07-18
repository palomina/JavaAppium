package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public abstract class SearchPageObject extends MainPageObject {

    protected static final String TEXT_IN_INPUT = "Search Wikipedia";

    protected static String
        fieldsSearch,
        inputSearch,
        panelSearchResult,
        itemSearchResult,
        itemSearchResultDesc,
        panelSearchEmptyResult,
        buttonClearSearch,
        buttonCancelSearch,
        itemSearchResult_TPL,
        itemSearchResultByTitleAndDescription_TPL,
        itemSearchResultButtonStar;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }


    /** TEMPLATES **/
    protected String getSearchResultItem(int index) {
        return itemSearchResult_TPL.replace("{INDEX}", String.valueOf(index));
    }

    protected String getSearchResultItemByTitleAndDescription(String title, String description) {
        return itemSearchResultByTitleAndDescription_TPL
                .replace("{TITLE}", title)
                .replace("{DESCRIPTION}", description);
    }
    /** TEMPLATES **/

    public void initSearchInput() {
        this.waitElementPresent(
                getLocator(fieldsSearch),
                "Can't click on search panel",
                30
        );

        this.waitElementAndClick(
                getLocator(fieldsSearch),
                "Can't click on search panel",
                30
        );

        this.waitElementPresent(
                getLocator(inputSearch),
                "SearchInput is not presented",
                30
        );

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid())   {
        this.assertElementHasText(
                getLocator(inputSearch),
                TEXT_IN_INPUT,
                "Unexpected text"
        );}
        else {
            this.assertElementHasAttribute(
                    getLocator(inputSearch),
                    "placeholder",
                    TEXT_IN_INPUT,
                    "There is no attribute 'placeholder' for inputSearch");

        }
    }

    public void searchByInputText(String word) {
        this.waitElementAndSendKeys(
                getLocator(inputSearch),
                word,
                "Can't set the search word",
                20
        );
    }

    public void checkIsResultsPresents() {
        this.waitElementPresent(
                getLocator(panelSearchResult),
                "Panel of search result is not found",
                20
        );

        this.waitElementPresent(
                getLocator(itemSearchResult),
                "Items of search result are not found",
                20
        );

        this.assertCountElements(
                getLocator(itemSearchResult),
                "Unexpected text"
        );
    }

    public void clearResults() {
        this.waitElementAndClick(
                getLocator(buttonClearSearch),
                "Button `Clear` is not found",
                20
        );

        this.waitElementPresent(
                getLocator(panelSearchEmptyResult),
                "Panel of empty result is not found",
                20
        );
    }
    public void cancelSearch() {
        this.waitElementAndClick(
                getLocator(buttonCancelSearch),
                "Button `Clear` is not found",
                20
        );
    }

    public void checkTextResults(String word) {
        this.assertElementsHasText(
                getLocator(itemSearchResult),
                word,
                "Unexpected text"
        );
    }

    public String getArticleNameByIndex(int index) {
        this.waitElementPresent(
                getLocator(getSearchResultItem(index)),
                "The first item of search result is not found",
                20
        );

        return this.waitElementAndGetText(
                getLocator(getSearchResultItem(index)),
                "The first item of search result is not found",
                20
        );
    }

    public void chooseArticleByIndex(int index) {
        this.waitElementAndClick(
                getLocator(getSearchResultItem(index)),
                "Can't click to the article",
                20
        );
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        this.waitElementPresent(
                getLocator(getSearchResultItemByTitleAndDescription(title, description)),
                "Can't see the article with title '"+title+"' and description '"+description+"'",
                20
        );
    }

    public void deselectStaredElements() {
        if (this.isElementPresent(getLocator(itemSearchResultButtonStar))) {
            this.waitElementPresent(
                    getLocator(itemSearchResultButtonStar),
                    "Cannot find stared elements",
                    20
            );

            List<WebElement> elements = driver.findElements(getLocator(itemSearchResultButtonStar));
            for (WebElement el : elements) {
                el.click();
            }
        }
    }
}
