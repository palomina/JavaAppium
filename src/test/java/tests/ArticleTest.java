package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Test;

public class ArticleTest extends CoreTestCase {

    @Test
    @Epic(value = "Articles")
    @Features(value = {@Feature(value="Article"),@Feature(value="Search")})
    @DisplayName("Check article name")
    @Description("Search article and check it name on article page")
    @Step("Starting test testCheckArticleNamePresent")
    @Severity(value = SeverityLevel.MINOR)
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
