package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainScreenHelper extends HelperBase{
    public MainScreenHelper(AppiumDriver dr) {
        super(dr);
    }

    public void searchArticle() {
        tap(By.id("fragment_feed_header"));
        waitForElementAndTap(By.id("search_src_text"), 10);
        waitForElementAndType(By.id("search_src_text"), 10, "TCP/IP");
        hideKeyboard();
        waitForElementAndTap(By.id("view_card_header_title"), 10);
    }

    public void selectFavorites() {
        waitForElementAndTap(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"), 10);
        tap(By.id("item_title"));
    }


}
