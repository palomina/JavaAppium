package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import lib.ui.mobile_web.MWAuthorizationPageObject;
import org.junit.Assert;
import org.junit.Test;

public class LIstTest extends CoreTestCase {

    @Test
    public void testSaveTwoArticle() throws Exception {
        String word = "Java";
        String listName = "List1";
        String firstArticleName;
        String secondArticleName;
        String titleArticleFromList;

        NavigationObject navigationObject = NavigationObjectFactory.get(driver);
        if (Platform.getInstance().isMw()) {
            navigationObject.clickAuthButton();

            String login = System.getenv("WIKI_LOGIN");
            String password = System.getenv("WIKI_PASSWORD");
            if (login.isEmpty() || password.isEmpty()) {
                throw new Exception("Credential data is not defined");
            }

            MWAuthorizationPageObject authorizationPageObject = new MWAuthorizationPageObject(driver);
            authorizationPageObject.enterLoginData(login, password);
            authorizationPageObject.submitForm();
        }

        WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
        welcomePageObject.skip();

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.searchByInputText(word);

        searchPageObject.checkIsResultsPresents();

        if (Platform.getInstance().isMw()) {
            searchPageObject.deselectStaredElements();
        }

        firstArticleName = searchPageObject.getArticleNameByIndex(1);
        searchPageObject.chooseArticleByIndex(1);

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.addToNewList(listName);

        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            navigationObject.back();
        } else {
            driver.navigate().back();
            welcomePageObject.skip();

            searchPageObject.initSearchInput();
            searchPageObject.searchByInputText(word);

            searchPageObject.checkIsResultsPresents();
        }

        secondArticleName = searchPageObject.getArticleNameByIndex(2);
        searchPageObject.chooseArticleByIndex(2);
        articlePageObject.addToList(listName);

        ListPageObject listPageObject = ListPageObjectFactory.get(driver);

        if (Platform.getInstance().isIOS()) {
            navigationObject.back();
            searchPageObject.cancelSearch();
        }

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            listPageObject.viewList();
        } else {
            navigationObject.clickWatchlistButton();
        }

        listPageObject.removeFromList(firstArticleName);

        if (Platform.getInstance().isAndroid()) {
            listPageObject.checkArticleInList(secondArticleName);

            titleArticleFromList = listPageObject.getArticleNameInList(secondArticleName);

            Assert.assertEquals("The name of the article is not the same is expected!", secondArticleName, titleArticleFromList);
        } else {
            listPageObject.clickOnArticleInList(secondArticleName);

            articlePageObject.removeFromList();
        }
    }
}
