package com.practice.qa_practice;

import com.practice.library.BrowserUtilities;
import com.practice.library.Driver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GetAttribute {
    @Test
    public void name() throws InterruptedException {
        //getattribute method is deprecated in newest selenium version 4.27
        //current framework is with 4.26
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("https://www.google.com");

        BrowserUtilities.sleep(2);

        String domAttribute = Driver.getDriver().findElement(By.name("q")).getDomAttribute("title");
        System.out.println("domAttribute = " + domAttribute);
        
        String domProperty = Driver.getDriver().findElement(By.name("q")).getDomAttribute("title");

        System.out.println("domProperty = " + domProperty);
        
        
    }
}
