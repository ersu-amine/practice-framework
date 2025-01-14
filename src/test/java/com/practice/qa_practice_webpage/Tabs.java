package com.practice.qa_practice_webpage;

import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Tabs {
    @Test
    void tabPractice() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("qa_practice") + "/tab");
        //click button to open tab
        Driver.getDriver().findElement(By.cssSelector("button#newTabBtn")).click();

        //get current handle
        String mainHandle = Driver.getDriver().getWindowHandle();

        //iterate over all handles
        for (String handle: Driver.getDriver().getWindowHandles()){
            if(!handle.equals(mainHandle)){
                Driver.getDriver().switchTo().window(handle);
                break;
            }
        }

        //confirm tab switch by comparing url of page
        Assertions.assertEquals("https://qa-practice.netlify.app/web-table", Driver.getDriver().getCurrentUrl());



    }
}
