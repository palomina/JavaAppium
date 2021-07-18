package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.Locale;

abstract class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void waitElementAndClick(By by, String errorMessage, int timeout) {
        new WebDriverWait(driver, timeout)
                .withMessage(errorMessage)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }

    public void tryElementClick(By by, String errorMessage, int timeout) {
        int currentAttempts = 0;
        boolean needMoreAttempts = true;

        while (needMoreAttempts) {
            try {
                this.waitElementAndClick(by, errorMessage, 1);
                needMoreAttempts = false;
            } catch (Exception e) {
                if (currentAttempts > timeout) {
                    this.waitElementAndClick(by, errorMessage, 1);
                }
            }
            currentAttempts++;
        }
    }

    public void waitElementAndSendKeys(By by, String text, String errorMessage, int timeout) {
        new WebDriverWait(driver, timeout)
                .withMessage(errorMessage)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .sendKeys(text);
    }

    public WebElement waitElementPresent(By by, String errorMessage, int timeout) {
        return new WebDriverWait(driver, timeout)
                .withMessage(errorMessage)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public boolean isElementPresent(By by) {
        try {
            new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String waitElementAndGetAttribute(By by, String attributeName, String errorMessage, int timeout) {
        return new WebDriverWait(driver, timeout)
                .withMessage(errorMessage)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .getAttribute(attributeName);
    }

    public String waitElementAndGetText(By by, String errorMessage, int timeout) {
        return new WebDriverWait(driver, timeout)
                .withMessage(errorMessage)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .getText();
    }

    public void assertElementHasText(By by, String text, String errorMessage) {
        WebElement element = driver.findElement(by);
        Assert.assertTrue(errorMessage, element.getText().contains(text));
    }

    public void assertElementHasAttribute(By by,String atr, String text, String errorMessage) {
        WebElement element = driver.findElement(by);
        Assert.assertEquals(errorMessage, text, element.getAttribute(atr));
    }


    public void assertCountElements(By by, String errorMessage) {
        List<WebElement> elements = driver.findElements(by);
        Assert.assertTrue(errorMessage, elements.size() > 0);
    }


    public void assertElementsHasText(By by, String text, String errorMessage) {
        List<WebElement> elements = driver.findElements(by);
        for (WebElement element : elements) {
            Assert.assertTrue(errorMessage, element.getText().toLowerCase().contains(text.toLowerCase()));
        }
    }

    public void assertElementPresent(By by, String errorMessage) {
        List elements = driver.findElements(by);
        if (elements.size()==0) {
            throw new AssertionError(errorMessage + " with element: '" + by.toString() + "'");
        }
    }

    public void swipeElementToLeft(By by, String errorMessage) {
        if (driver instanceof AppiumDriver) {
            WebElement element = waitElementPresent(by, errorMessage, 10);

            int leftX = element.getLocation().getX();
            int rightX = leftX + element.getSize().getWidth();
            int upperY = element.getLocation().getY();
            int lowerY = upperY + element.getSize().getHeight();
            int middleY = (upperY + lowerY) / 2;

            TouchAction action = new TouchAction((AppiumDriver) driver);
            action
                    //    .press(rightX, middleY)
                    .press(PointOption.point(rightX, middleY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(leftX, middleY))
                    .release()
                    .perform();
        } else {
            System.out.println("Method swipeElementToLeft do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public By getLocator(String locator) {
        String[] parts = locator.split("##");
        switch (parts[0]) {
            case "id":
                return By.id(parts[1]);
            case "xpath":
                return By.xpath(parts[1]);
            case "css":
                return  By.cssSelector(parts[1]);
            default:
                throw new IllegalArgumentException("Unknown type of locator: " + parts[0]);
        }
    }
}
