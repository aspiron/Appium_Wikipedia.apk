package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class AppManager {

    AppiumDriver dr;
    DesiredCapabilities capabilities;

    ArticleHelper article;
    MainScreenHelper mainScreen;

    public ArticleHelper getArticle() {
        return article;
    }

    public MainScreenHelper getMainScreen() {
        return mainScreen;
    }

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("deviceName", "qa_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", "C:/Tools/org.wikipedia.apk/");

        dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        article = new ArticleHelper(dr);
        mainScreen = new MainScreenHelper(dr);

    }

    public void stop() {
        dr.quit();
    }

    public AppiumDriver getDr() {
        return dr;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }



}
