package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        buttonSaveToList = "xpath##//a[@id='ca-watch' and not(contains(@class, ' watched '))]";
        buttonAddToList = "xpath##//a[@id='ca-watch' and not(contains(@class, ' watched '))]";
        buttonRemoveFromList = "xpath##//a[@id='ca-watch' and contains(@class, ' watched ')]";
        articleTitle_TPL = "xpath##//h1[contains(text(), '{ARTICLE_NAME}')]";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
