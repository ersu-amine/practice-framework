package com.practice.qa_practice_webpage;

import com.practice.library.BrowserUtilities;
import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SignInPractice {
    WebDriver driver = Driver.getDriver();
    @Test
    void signInTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        //navigate to main page
        driver.get(ConfigurationReader.getProperty("website2"));

        //click sign in
        driver.findElement(By.xpath("//*[text()='Sign in']/..")).click();

        Assertions.assertTrue(Driver.getDriver().findElement(By.xpath("//h2[text()='Sign in']")).isDisplayed());

        //input email
        driver.findElement(By.xpath("//input[@id='MPIDEmailField']")).sendKeys("test@gmail.com");

        //click continue
        driver.findElement(By.xpath("//span[text()='Continue']/ancestor::button")).click();

        BrowserUtilities.sleep(1);
        Driver.closeDriver();
    }
}
