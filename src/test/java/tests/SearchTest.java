package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Test;

public class SearchTest extends CoreTestCase {

    @Test
    public void testCheckText() {
       WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
        welcomePageObject.skip();

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
    }

    @Test
    public void testSearchWordAndCleanResult() {
        String word = "Java";

        WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
        welcomePageObject.skip();

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.searchByInputText(word);
        searchPageObject.checkIsResultsPresents();
        searchPageObject.clearResults();
    }

    @Test
    public void testSearchWordAndCheckResult()  throws Exception{
        String word = "Java";

        WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
        welcomePageObject.skip();

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.searchByInputText(word);
        searchPageObject.checkIsResultsPresents();
        searchPageObject.checkTextResults(word);
        searchPageObject.clearResults();
    }


    @Test
    public void testSearchWordAndCheckResultsByTitleAndDescription() {
        String word = "Java";

        WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
        welcomePageObject.skip();

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.searchByInputText(word);
        searchPageObject.checkIsResultsPresents();

        searchPageObject.waitForElementByTitleAndDescription("Java", "Indonesian island");
        searchPageObject.waitForElementByTitleAndDescription("Java", "High-level programming language");
        searchPageObject.waitForElementByTitleAndDescription("Java", "Object-oriented programming language");
    }

}
