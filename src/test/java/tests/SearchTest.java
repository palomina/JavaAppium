package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Test;

public class SearchTest extends CoreTestCase {

    @Test
    @Epic(value = "Articles")
    @Features(value = {@Feature(value="Article"),@Feature(value="Search")})
    @DisplayName("Check text")
    @Description("Check text in search field")
    @Step("Starting test testCheckText")
    @Severity(value = SeverityLevel.NORMAL)
    public void testCheckText() {
       WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
        welcomePageObject.skip();

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
    }

    @Test
    @Epic(value = "Articles")
    @Features(value = {@Feature(value="Article"),@Feature(value="Search")})
    @DisplayName("Search word and clean result")
    @Description("Search word and clean result")
    @Step("Starting test testSearchWordAndCleanResult")
    @Severity(value = SeverityLevel.NORMAL)
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
    @Epic(value = "Articles")
    @Features(value = {@Feature(value="Article"),@Feature(value="Search")})
    @DisplayName("Search word and check result")
    @Description("Search word and check result")
    @Step("Starting test testSearchWordAndCheckResult")
    @Severity(value = SeverityLevel.NORMAL)
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
    @Epic(value = "Articles")
    @Features(value = {@Feature(value="Article"),@Feature(value="Search")})
    @DisplayName("Search word and check results by title and description")
    @Description("Search word and check results by title and description")
    @Step("Starting test testSearchWordAndCheckResultsByTitleAndDescription")
    @Severity(value = SeverityLevel.NORMAL)
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
