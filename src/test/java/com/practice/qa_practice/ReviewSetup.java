package com.practice.qa_practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReviewSetup {
    @Test
    public void setUp() {
        //open browser and go to google
        WebDriver driverChrome = new ChromeDriver();

        driverChrome.get("https://www.google.com");
    }

}
