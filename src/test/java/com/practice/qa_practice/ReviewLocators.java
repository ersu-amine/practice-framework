package com.practice.qa_practice;

import com.github.javafaker.Faker;
import com.practice.library.BrowserUtilities;
import com.practice.library.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class ReviewLocators {
    @BeforeAll
    public static void navigation() {

        //WebDriver driver = new ChromeDriver();
        //driver.get("https://demoblaze.com");

        //using singleton driver

        Driver.getDriver().get("https://demoblaze.com");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @Test
    void locatingAndIntereacting() {

//        By signUp = By.partialLinkText("Sign up");
//        Driver.getDriver().findElement(signUp);


        Driver.getDriver().findElement(By.xpath("//a[text()='Sign up']")).click();

        String username = new Faker().name().username();

        Driver.getDriver().findElement(By.xpath("//input[@id='sign-username']")).sendKeys(username);

        Driver.getDriver().findElement(By.xpath("//input[@id='sign-password']")).sendKeys("Test12334");

        Driver.getDriver().findElement(By.xpath("//button[text()='Sign up']")).click();

        BrowserUtilities.sleep(2); //use explicit wait
        Alert alert = Driver.getDriver().switchTo().alert();

        alert.accept();

        BrowserUtilities.waitForElementVisibility(Driver.getDriver().findElement(By.xpath("//a[text()='Log in']")));

        Driver.getDriver().findElement(By.xpath("//a[text()='Log in']")).click();

        BrowserUtilities.waitForElementVisibility(Driver.getDriver().findElement(By.xpath("//input[@id='loginusername']")));

        Driver.getDriver().findElement(By.xpath("//input[@id='loginusername']")).sendKeys(username);

        Driver.getDriver().findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("Test12334");

        Driver.getDriver().findElement(By.xpath("//button[text()='Log in']")).click();
        BrowserUtilities.waitPageLoad();
        BrowserUtilities.sleep(3); //try to create a method to solve that problem about sync issue,, you create a loop to handle the issue
        String text = Driver.getDriver().findElement(By.id("nameofuser")).getText();
        System.out.println(text);
        Assertions.assertTrue(text.contains(username));
        saveUsernameToFile(username);
        //create method to store username to a txt file

    }

    public void saveUsernameToFile(String username) {
        File file = new File("src/test/resources/usernames.txt");

        try (FileWriter writer = new FileWriter(file, true)) { // true to append
            writer.write(username + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void tearDown(){
        BrowserUtilities.sleep(2);
        Driver.closeDriver();
    }
}
