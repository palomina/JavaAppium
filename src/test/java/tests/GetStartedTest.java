package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    @Epic(value = "Application")
    @Feature(value = "Welcome page")
    @DisplayName("Pass through welcome page")
    @Description("Pass through welcome page")
    @Step("Starting test testPassThroughWelcome")
    @Severity(value = SeverityLevel.MINOR)
    public void testPassThroughWelcome(){
        if (Platform.getInstance().isMw()) {
            return;
        }

        WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);
        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.nextClick();

        welcomePageObject.waitForNewWaysToExplore();
        welcomePageObject.nextClick();

        welcomePageObject.waitForAddOrEditPreferredLanguages();
        welcomePageObject.nextClick();

        welcomePageObject.waitForLearnMoreAboutDataCollected();
        welcomePageObject.getStartedClick();
    }
}
