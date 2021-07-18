package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        fieldsSearch = "xpath##//form[@class='search-box']//input[@name='search']";
        inputSearch = "xpath##//form[@class='search-box']//input[@name='search']";
        panelSearchResult = "css##div.results";
        itemSearchResult = "xpath##//ul[@class='page-list thumbs actionable']//li//h3//strong";
        itemSearchResultDesc = "css##div.wikidata-description";

        buttonClearSearch = "xpath##//button[contains(@class, 'clear')]";
        buttonCancelSearch = "xpath##//button[contains(@class, 'cancel')]";
        panelSearchEmptyResult = "xpath##//p[contains(@class, 'without-results') and contains(text(), 'No page with this title.')]";

        itemSearchResult_TPL = "xpath##//ul[@class='page-list thumbs actionable']//li[{INDEX}]//h3//strong";
        itemSearchResultByTitleAndDescription_TPL = "xpath##//ul[@class='page-list thumbs actionable']//li//h3[//strong[contains(text(), '{TITLE}')]]/following-sibling::div[@class='wikidata-description' and contains(text(), '{DESCRIPTION}')]";
        itemSearchResultButtonStar = "xpath##//div[contains(@class, 'results-list-container')]//a[contains(@class, 'mw-ui-icon-wikimedia-unStar-progressive')]";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
