package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSWelcomePageObject extends WelcomePageObject {
    static {
        buttonSkip = "xpath##//XCUIElementTypeButton[@name='Skip']";
        buttonNext = "xpath##//XCUIElementTypeButton[@name='Next']";
        linkLearnMore = "xpath##//XCUIElementTypeStaticText[@name='Learn more about Wikipedia']";
        linkAddOrEditPreferredLanguages = "xpath##//XCUIElementTypeStaticText[@name='Add or edit preferred languages']";
        linkLearnMoreAboutDataCollected = "xpath##//XCUIElementTypeButton[@name='Learn more about data collected']";
        buttonGetStarted = "xpath##//XCUIElementTypeButton[@name='Get started']";
        textNewWaysToExplore = "id##New ways to explore";
    }
    public IOSWelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
