package com.practice.library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtilities {

    /**
     *
     * @param seconds in seconds
     * @throws InterruptedException
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElementVisibility(WebElement element){
        new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitPageLoad(){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30)).until(
                (ExpectedCondition<Boolean>) wd ->
                        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

    }

}
