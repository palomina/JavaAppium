package tests;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;

public class ChangeAppConditionTest extends CoreTestCase {

    @Test
    @Epic(value = "Application")
    @Feature(value = "Application condition")
    @DisplayName("Change orientation to landscape")
    @Description("Try to change application's orientation to landscape")
    @Step("Starting test testOrientation1")
    @Severity(value = SeverityLevel.MINOR)
    public void testOrientation1() {
        if (driver instanceof AppiumDriver) {
            String word = "Java";

            WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
            welcomePageObject.skip();


            SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
            searchPageObject.initSearchInput();

            this.rotateToLANDSCAPE();

            searchPageObject.searchByInputText(word);
        }else {
            System.out.println("Method rotateToLANDSCAPE does not for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Test
    @Epic(value = "Application")
    @Feature(value = "Application condition")
    @DisplayName("Check if orientation in default value")
    @Description("Check if orientation in default value")
    @Step("Starting test testOrientation2")
    @Severity(value = SeverityLevel.MINOR)
    public void testOrientation2() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            String word = "Java";

            WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
            welcomePageObject.skip();
            SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
            searchPageObject.initSearchInput();
            searchPageObject.searchByInputText(word);

            Assert.assertEquals("Orientation is not default", ScreenOrientation.PORTRAIT, driver.getOrientation());
        } else {
            System.out.println("Method Orientation does not for platform " + Platform.getInstance().getPlatformVar());
        }
    }
}
