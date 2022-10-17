package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticleHelper extends HelperBase {
    public ArticleHelper(AppiumDriver dr) {
        super(dr);
    }

    public void addToFavorites() {
        createReadingListFirstTime();
    }

    public void createReadingListFirstTime() {
        tap(By.xpath("//android.widget.ImageView[@content-desc='Add this article to a reading list']"));
        waitForElementAndTap(By.id("onboarding_button"), 10);
        waitForElementAndTap(By.id("text_input"), 10);
        dr.findElement(By.id("text_input")).clear();
        dr.findElement(By.id("text_input")).sendKeys("Favorites");
        tap(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget." +
                "LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget." +
                "FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.ScrollView/android." +
                "widget.LinearLayout/android.widget.Button[2]"));
    }

    public void close() {
        tap(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
    }

}
