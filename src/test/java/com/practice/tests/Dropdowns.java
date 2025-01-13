package com.practice.tests;

import com.practice.library.BrowserUtilities;
import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import com.practice.pages.QA_Practice_DropDownsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {
    QA_Practice_DropDownsPage dropDownsPage = new QA_Practice_DropDownsPage();

    @Test
    void dropdowns() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa_practice") + "/dropdowns");

        Select dropdown = new Select(dropDownsPage.selectDropdown);

        dropdown.selectByValue("Taiwan");
        dropdown.selectByVisibleText("Fiji");
        dropdown.selectByIndex(29);
    }
}
