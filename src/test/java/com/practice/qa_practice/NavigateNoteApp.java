package com.practice.qa_practice;

import com.practice.library.BrowserUtilities;
import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigateNoteApp{
    @BeforeEach
    void setup() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("notes_app")+"/login");

        //Driver.getDriver().findElement(By.xpath("//a[text()='Login']")).click();

        Driver.getDriver().findElement(By.id("email")).sendKeys(ConfigurationReader.getProperty("notes_email"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("notes_password"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@data-testid='login-submit']"));

        BrowserUtilities.waitForElementVisibility(loginButton);
        loginButton.click();
    }

    @Test
    void createNote() {
        Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Add Note')]")).click();
        Driver.getDriver().findElement(By.id("title")).sendKeys("Test Title");
        Driver.getDriver().findElement(By.id("description")).sendKeys("Test Description");
        Driver.getDriver().findElement(By.xpath("//button[text()='Create']")).click();

    }

    @AfterEach
    void tearDown(){
        Driver.closeDriver();
    }
}
