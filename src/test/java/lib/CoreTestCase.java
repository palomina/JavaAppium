package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;

public class CoreTestCase {


    protected RemoteWebDriver driver;
    protected Platform platform;

    @Before
    @Step("Run driver and session")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
        this.rotateToPORTRAIT();
        this.openWikiWebPAgeForMobileWeb();
    }

    @After
    @Step("Remove driver and session")
    public void tearDown() {
        driver.quit();
    }

    @Step("Rotate screen to landscape mode")
    protected void rotateToLANDSCAPE(){
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateToLANDSCAPE does not for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    @Step("Open Wikipedia URL for mobile Web (this method does nothing for Android and iOS)")
    protected  void openWikiWebPAgeForMobileWeb(){
        if (Platform.getInstance().isMw()) {
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiWebPAgeForMobileWeb does not for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Rotate screen to portrait mode")
    protected void rotateToPORTRAIT(){
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateToPORTRAIT does not for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    private void createAllurePropertyFile() {
        String path = System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Environment");
            fos.close();
        } catch (Exception e) {
            System.err.println("IO problem when writing allure properties file");
        }
    }
}
