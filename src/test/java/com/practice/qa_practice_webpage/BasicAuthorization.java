package com.practice.qa_practice_webpage;

import com.practice.library.BrowserUtilities;
import com.practice.library.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class BasicAuthorization {
    @Test
    void basicAuth() throws InterruptedException {
        String username = "authorized";
        String password = "password001";
        Driver.getDriver().manage().window().maximize();

        Driver.getDriver().get("https://" + username + ":" + password + "@testpages.eviltester.com/styled/auth/basic-auth-results.html");

        Assertions.assertEquals("Authenticated", Driver.getDriver().findElement(By.cssSelector("span[id='status']")).getText());
        BrowserUtilities.sleep(2);

        Driver.getDriver().quit();
    }
}
