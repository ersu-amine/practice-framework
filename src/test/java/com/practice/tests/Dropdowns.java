package com.practice.tests;

import com.practice.library.BrowserUtilities;
import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import com.practice.pages.QAPracticeDropDownsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {
    QAPracticeDropDownsPage dropDownsPage = new QAPracticeDropDownsPage();

    Logger LOG = LogManager.getLogger();

    @Test
    void simpleDropdowns() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa_practice") + "/dropdowns");

        Select dropdown = new Select(dropDownsPage.selectDropdown);

        dropdown.selectByValue("Taiwan");
        LOG.info("selecting by value");
        dropdown.selectByVisibleText("Fiji");
        LOG.info("selecting by visible text");
        dropdown.selectByIndex(29);
        LOG.info("selecting by index");

        BrowserUtilities.sleep(2);
        Driver.getDriver().quit();
    }

    @Test
    void multiLevelDropdowns() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa_practice") + "/dropdowns");

        dropDownsPage.multiLevelDropdown.click();
        dropDownsPage.option2.click();
        LOG.info("Option 2 has been chosen");

        //needs hovering
        Actions actions = new Actions(Driver.getDriver());
        dropDownsPage.multiLevelDropdown.click();
        actions.moveToElement(dropDownsPage.option3).moveToElement(dropDownsPage.secondLevelDropdown).moveToElement(dropDownsPage.thirdLevelDropdown).moveToElement(dropDownsPage.fourthLevelOption1).perform();
        dropDownsPage.fourthLevelOption1.click();
        LOG.info("Fourth level option 1 has been selected");
        BrowserUtilities.sleep(2);
        Driver.getDriver().quit();
    }
}
