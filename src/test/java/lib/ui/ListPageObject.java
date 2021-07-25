package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import lib.ui.factories.ArticlePageObjectFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class ListPageObject extends MainPageObject {

    protected static String
            buttonViewList,
            buttonClosePopup,
            buttonDeleteArticle,
            buttonDeleteArticle_TPL,
            itemArticle_TPL;

    public ListPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /** TEMPLATES **/
    protected String getArticleItem(String name) {
        return itemArticle_TPL.replace("{ARTICLE_NAME}", name);
    }

    protected String getArticleItemUnStarButton(String name) {
        return buttonDeleteArticle_TPL.replace("{ARTICLE_NAME}", name);
    }

    /** TEMPLATES **/

    @Step("View list")
    public void viewList() {
        this.waitElementAndClick(
                getLocator(buttonViewList),
                "Can't click to button `View List`",
                20
        );

        if (Platform.getInstance().isIOS()) {
            this.closePopup();
        }
    }

    @Step("Remove article '{articleName}' from list")
    public void removeFromList(String articleName) {
        this.waitElementPresent(
                getLocator(getArticleItem(articleName)),
                "First article is not found in list",
                10
        );

        screenshot(this.takeScreenshot("before_remove_from_list"));
        if (Platform.getInstance().isMw()) {
            this.waitElementAndClick(
                    getLocator(getArticleItemUnStarButton(articleName)),
                    "Button of remove article from saved is not found",
                    10
            );
            driver.navigate().refresh();
        } else {
            this.swipeElementToLeft(
                    getLocator(getArticleItem(articleName)),
                    "Can't swipe"
            );

            if (Platform.getInstance().isIOS()) {
                this.waitElementAndClick(
                        getLocator(buttonDeleteArticle),
                        "Button of remove article from saved is not found",
                        10
                );
            }
        }
    }

    @Step("Check article in list '{articleName}'")
    public void checkArticleInList(String articleName) {
        this.waitElementPresent(
                getLocator(getArticleItem(articleName)),
                "Article `" + articleName + "` is not found in the list",
                10
        );
    }

    @Step("Click on article '{articleName}' in list")
    public void clickOnArticleInList(String articleName) {
        this.waitElementAndClick(
                getLocator(getArticleItem(articleName)),
                "Article `" + articleName + "` is not found in the list",
                10
        );
    }

    @Step("Get article text in list")
    public String getArticleNameInList(String articleName){
        return this.waitElementAndGetText(
                getLocator(getArticleItem(articleName)),
                "The title of second article in the list is not present",
                10
        );
    }

    @Step("Close popup")
    public void closePopup() {
        this.waitElementAndClick(
                getLocator(buttonClosePopup),
                "Can't click to button `View List`",
                20
        );
    }
}
