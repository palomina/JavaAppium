package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class CoreTestCase extends TestCase {


    protected RemoteWebDriver driver;
    protected Platform platform;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateToPORTRAIT();
        this.openWikiWebPAgeForMobileWeb();
    }

    @Override
    public void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateToLANDSCAPE(){
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateToLANDSCAPE does not for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    protected  void openWikiWebPAgeForMobileWeb(){
        if (Platform.getInstance().isMw()) {
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiWebPAgeForMobileWeb does not for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void rotateToPORTRAIT(){
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateToPORTRAIT does not for platform " + Platform.getInstance().getPlatformVar());
        }
    }
}
