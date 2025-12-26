package com.practice.qa_practice;
import com.practice.library.BrowserUtilities;
import com.practice.library.Driver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class NavigateTo {

    @Test
    public void navigateTo() throws InterruptedException {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("https://www.google.com");

        BrowserUtilities.sleep(2);
        Driver.getDriver().navigate().to("https://www.amazon.com");

        BrowserUtilities.sleep(2);


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.open('https://www.amazon.com','_blank');");

        BrowserUtilities.sleep(2);
        Driver.getDriver().quit();
    }
}
