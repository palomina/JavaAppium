package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
        buttonSaveToList = "id##Save for later";
        buttonAddToList = "id##Save for later";
        buttonRemoveFromList = "id##Saved. Activate to unsave.";
        articleTitle_TPL = "xpath##//*[@name='{ARTICLE_NAME}']";
    }

    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
