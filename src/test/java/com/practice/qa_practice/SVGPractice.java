package com.practice.qa_practice;

import com.practice.library.BrowserUtilities;
import com.practice.library.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SVGPractice {
    @Test
    void svgTest() {
        //navigate to page
        Driver.getDriver().get("https://www.southwest.com/");
        BrowserUtilities.waitPageLoad();
        //flakiness due to page load delay
        Driver.getDriver().findElement(By.xpath("(//header//div[@role='navigation']//button)[1]")).click();

        //locate SVG
        BrowserUtilities.sleep(2);
        WebElement svgVacations = Driver.getDriver().findElement(By.xpath("//*[name()='svg' and @aria-label='vacations']"));

        Assertions.assertTrue(svgVacations.isDisplayed());

        Driver.closeDriver();
    }
}
