package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class WelcomePageObject extends MainPageObject {

    protected static String
        buttonSkip,
        buttonNext,
        linkLearnMore,
        linkAddOrEditPreferredLanguages,
        linkLearnMoreAboutDataCollected,
        buttonGetStarted,
        textNewWaysToExplore;

    public WelcomePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    @Step("Skip welcome tutorial")
    public void skip() {
        this.waitElementPresent(
                getLocator(buttonSkip),
                "Button `Skip` not found",
                20
        );

        this.waitElementAndClick(
                getLocator(buttonSkip),
                "Button `Skip` not found",
                20
        );
    }

    @Step("Click next button")
    public void nextClick() {
        this.waitElementAndClick(
                getLocator(buttonNext),
                "Button `Next` not found",
                20
        );
    }

    @Step("Wait for text 'Learn more about Wikipedia'")
    public void waitForLearnMoreLink()
    {
        this.waitElementPresent(
                getLocator(linkLearnMore),
                "No link Learn More is presented",
                20
        );
    }

    @Step("Wait for text 'New ways to explore'")
    public void waitForNewWaysToExplore()
    {
        this.waitElementPresent(
                getLocator(textNewWaysToExplore),
                "No text 'New ways to Explore' is presented",
                20
        );
    }

    @Step("Wait for text 'Add or edit preferred languages'")
    public void waitForAddOrEditPreferredLanguages()
    {
        this.waitElementPresent(
                getLocator(linkAddOrEditPreferredLanguages),
                "No link Learn More is presented",
                20
        );
    }

    @Step("Wait for text 'Learn more about data collected'")
    public void waitForLearnMoreAboutDataCollected()
    {
        this.waitElementPresent(
                getLocator(linkLearnMoreAboutDataCollected),
                "No link Learn More is presented",
                20
        );
    }

    @Step("Click the button 'Get Started'")
    public void getStartedClick() {
        screenshot(this.takeScreenshot("welcome_get_started"));
        this.waitElementAndClick(
                getLocator(buttonGetStarted),
                "Button `Get Started` not found",
                20
        );
    }
}
