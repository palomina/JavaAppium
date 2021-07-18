package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidWelcomePageObject extends WelcomePageObject {
    static {
        buttonSkip = "id##org.wikipedia:id/fragment_onboarding_skip_button";
        buttonNext = "id##org.wikipedia:id/fragment_onboarding_forward_button";
        linkLearnMore = "xpath##//*[contains(@text, 'The Free Encyclopedia')]";
        linkAddOrEditPreferredLanguages = "xpath##//*[@text='Reading lists with sync']";
        linkLearnMoreAboutDataCollected = "xpath##//*[@text='Send anonymous data']";
        buttonGetStarted = "id##org.wikipedia:id/fragment_onboarding_done_button";
        textNewWaysToExplore = "xpath##//*[@text='New ways to explore']";
    }
    public AndroidWelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

}
