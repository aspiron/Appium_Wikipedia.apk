package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    AppiumDriver dr;

    public HelperBase(AppiumDriver dr) {
        this.dr = dr;
    }

    public void tap(By locator) {
        dr.findElement(locator).click();
    }

    public void waitForElementAndTap(By locator, int timeOut) {
        new WebDriverWait(dr, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            if (!text.equals(dr.findElement(locator).getText())) {
                tap(locator);
                dr.findElement(locator).clear();
                dr.findElement(locator).sendKeys(text);
            }
        }
    }

    public void waitForElementAndType(By locator, int timeOut, String text) {
        if (text != null) {
            waitForElementAndTap(locator, timeOut);
            dr.findElement(locator).clear();
            dr.findElement(locator).sendKeys(text);
        }
    }


    public boolean isElementsPresent(By locator) {
        return dr.findElements(locator).size() > 0;
    }


    public void hideKeyboard() {
        dr.hideKeyboard();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void swipeUp() {
        TouchAction action = new TouchAction(dr);

        Dimension size = dr.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int stopY = (int) (size.height * 0.3);

        action.longPress(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release()
                .perform();
    }

    public void swipeDown() {
        TouchAction action = new TouchAction(dr);

        Dimension size = dr.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * 0.5);
        int stopY = (int) (size.height * 0.8);

        action.longPress(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release()
                .perform();
    }


    public void moveUp(By locator) {
        TouchAction action = new TouchAction(dr);
        // get activity points:
        Dimension size = dr.manage().window().getSize();

        int downPoint = (int) (size.height * 0.6);
        int upPoint = (int) (size.height * 0.5);
        // get element's point:
        WebElement element = dr.findElement(locator);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int middleX = (leftX + rightX) / 2;
        action.longPress(PointOption.point(middleX, downPoint))
                .moveTo(PointOption.point(middleX, upPoint))
                .release()
                .perform();

    }

    public void moveDown(By locator) {
        TouchAction action = new TouchAction(dr);
        // get activity points:
        Dimension size = dr.manage().window().getSize();

        int downPoint = (int) (size.height * 0.6);
        int upPoint = (int) (size.height * 0.5);

        // get element's point:
        WebElement element = dr.findElement(locator);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int middleX = (leftX + rightX) / 2;
        action.longPress(PointOption.point(middleX, upPoint))
                .moveTo(PointOption.point(middleX, downPoint))
                .release()
                .perform();
    }

    public void pressOnTimer(int x, int y) {
        TouchAction action = new TouchAction(dr);
        Dimension size = dr.manage().window().getSize();

        action.tap(PointOption.point(x,y))
                .release()
                .perform();
    }

}
