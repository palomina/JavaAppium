package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        buttonSaveToList = "id##org.wikipedia:id/article_menu_bookmark";
        buttonAddToList = "id##org.wikipedia:id/snackbar_action";
        inputListName = "id##org.wikipedia:id/text_input";
        buttonOk = "xpath##//*[@text='OK']";
        itemList_TPL = "xpath##//android.view.ViewGroup//android.widget.TextView[@text='{LIST_NAME}']";
        articleTitle_TPL = "xpath##//*[@text='{ARTICLE_NAME}']";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
