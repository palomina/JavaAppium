package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class ArticlePageObject extends MainPageObject {

    protected static String
            buttonSaveToList,
            buttonAddToList,
            buttonRemoveFromList,
            inputListName,
            buttonOk,
            itemList_TPL,
            articleTitle_TPL;


    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /** TEMPLATES **/
    protected String getListItem(String listName) {
        return itemList_TPL.replace("{LIST_NAME}", String.valueOf(listName));
    }

    protected String getArticleTitle(String articleName) {
        return articleTitle_TPL.replace("{ARTICLE_NAME}", String.valueOf(articleName));
    }

    /** TEMPLATES **/

    public void addToNewList(String listName) {
        if (Platform.getInstance().isAndroid()) {
            this.waitElementAndClick(
                    getLocator(buttonSaveToList),
                    "Can't click to the button `Save to List`",
                    20
            );

            this.waitElementAndClick(
                    getLocator(buttonAddToList),
                    "Can't click to the button `Add to List`",
                    20
            );

            this.waitElementAndSendKeys(
                    getLocator(inputListName),
                    listName,
                    "Can't set the list's name",
                    20
            );

            this.waitElementAndClick(
                    getLocator(buttonOk),
                    "Can't click to the button `Ok`",
                    20
            );
        } else {
            this.waitElementAndClick(
                    getLocator(buttonAddToList),
                    "Can't click to the button `Save to List`",
                    20
            );
        }


    }

    public void addToList(String listName) {
        if (Platform.getInstance().isAndroid()) {
            this.waitElementAndClick(
                    getLocator(buttonSaveToList),
                    "Can't click to button `Save to List`",
                    20
            );

            this.waitElementAndClick(
                    getLocator(buttonAddToList),
                    "Can't click to button `Add to List`",
                    20
            );

            this.waitElementAndClick(
                    getLocator(getListItem(listName)),
                    "Can't add to list with name `" + listName + "`",
                    20
            );
        } else {
            this.waitElementAndClick(
                    getLocator(buttonSaveToList),
                    "Can't click to button `Save to List`",
                    20
            );
        }
    }

    public void removeFromList() {
        this.waitElementAndClick(
                getLocator(buttonRemoveFromList),
                "Can't click to button `Remove from List`",
                20
        );
    }

    public void checkArticleTitle(String articleName){
        this.waitElementPresent(
                getLocator(getArticleTitle(articleName)),
                "Can't see to the article title " + getArticleTitle(articleName),
                20
        );

        this.assertElementPresent(
                getLocator(getArticleTitle(articleName)),
                "Can't show the article's title"
        );
    }

}
