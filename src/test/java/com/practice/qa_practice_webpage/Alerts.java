package com.practice.qa_practice_webpage;

import com.practice.library.BrowserUtilities;
import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import com.practice.pages.EvilTesterAlertsPage;
import com.practice.pages.QAPracticeAlertsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Alerts {

    QAPracticeAlertsPage alertsPage = new QAPracticeAlertsPage();

    Logger LOG = LogManager.getLogger();
    @Test
    void simpleAlert() throws InterruptedException {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("qa_practice") + "/alerts");

        //getting colour of the header text
        String cssValue = Driver.getDriver().findElement(By.tagName("h2")).getCssValue("color");
        String elementFont = Driver.getDriver().findElement(By.tagName("h2")).getCssValue("font-family");
        String fontSize = Driver.getDriver().findElement(By.tagName("h2")).getCssValue("font-size");
        LOG.info(cssValue);
        LOG.info(elementFont);
        LOG.info(fontSize);
        
        //Driver.getDriver().switchTo().alert().accept();
        alertsPage.alertButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        LOG.info("Driver switch to alert");

        alert.accept();
        LOG.info("Alert has been accepted");

        BrowserUtilities.sleep(2);
        Driver.getDriver().quit();
    }

    @Test
    void confirmationAlert() throws InterruptedException {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("qa_practice") + "/alerts");

        alertsPage.confirmAlertButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        LOG.info("Driver switch to alert");
        alert.accept();
        LOG.info("Alert has been accepted");

        alertsPage.confirmAlertButton.click();
        LOG.info("Opening alert for the second time");
        Driver.getDriver().switchTo().alert().dismiss();
        LOG.info("Alert has been dismissed");
        BrowserUtilities.sleep(2);
        Driver.getDriver().quit();
    }

    @Test
    void promptAlert() throws InterruptedException {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("evil_tester")+"/alerts/alert-test.html");

        EvilTesterAlertsPage alertPage = new EvilTesterAlertsPage();

        alertPage.promptAlert.click();
        BrowserUtilities.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        LOG.info("Driver switch to alert");

        //displaying issue in google chrome, input does not show but accepted as the entered way
        alert.sendKeys("golden 5");
        BrowserUtilities.sleep(2);
        alert.accept();
        BrowserUtilities.sleep(2);
        LOG.info("Alert has been accepted");

        BrowserUtilities.sleep(2);
        Driver.getDriver().quit();
    }
}
