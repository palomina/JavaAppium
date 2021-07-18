package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        fieldsSearch = "xpath##//*[@resource-id='org.wikipedia:id/search_container']//android.widget.TextView";
        inputSearch = "id##org.wikipedia:id/search_src_text";
        panelSearchResult = "id##org.wikipedia:id/search_results_list";
        itemSearchResult = "xpath##//*[@resource-id='org.wikipedia:id/search_results_list']//android.view.ViewGroup//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        itemSearchResultDesc = "xpath##//*[@resource-id='org.wikipedia:id/search_results_list']//android.view.ViewGroup//*[@resource-id='org.wikipedia:id/page_list_item_description']";

        buttonClearSearch = "id##org.wikipedia:id/search_close_btn";
        panelSearchEmptyResult = "id##org.wikipedia:id/search_empty_container";

        itemSearchResult_TPL = "xpath##//*[@resource-id='org.wikipedia:id/search_results_list']//android.view.ViewGroup[{INDEX}]//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        itemSearchResultByTitleAndDescription_TPL = "xpath##//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title' and contains(@text, '{TITLE}')]/following-sibling::*[@resource-id='org.wikipedia:id/page_list_item_description' and contains(@text, '{DESCRIPTION}')]";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
