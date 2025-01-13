package com.practice.library;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtilities {


    /**
     *
     * @param time in seconds
     * @throws InterruptedException
     */
    public static void sleep(int time) throws InterruptedException {
        time *= 1000;
        Thread.sleep(time);
    }


}
