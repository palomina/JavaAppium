package tests;

import lib.CoreTestCase;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Test;

public class ArticleTest extends CoreTestCase {

    @Test
    public void testCheckArticleNamePresent() {
        String word = "Java";
        String firstArticleName;

        WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
        welcomePageObject.skip();

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.searchByInputText(word);
        searchPageObject.checkIsResultsPresents();

        firstArticleName = searchPageObject.getArticleNameByIndex(1);
        searchPageObject.chooseArticleByIndex(1);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.checkArticleTitle(firstArticleName);
    }

}
