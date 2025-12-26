package com.practice.qa_practice;

import com.practice.library.BrowserUtilities;
import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import com.practice.pages.QAPracticeiFramePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class iFrames extends QAPracticeiFramePage {
    Logger LOG = LogManager.getLogger();

    @Test
    void frames() throws InterruptedException {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("qa_practice") + "/iframe");

        Driver.getDriver().switchTo().frame(iframeElement);

        String header = headerInFrame.getText();

        LOG.info("Header in iframe has the contents: {}", header);

        learnMoreButton.click();
        BrowserUtilities.waitForElementVisibility(hiddenText);

        String text = hiddenText.getText().trim();
        LOG.info("Hidden text contains '{}'",text);
        Assertions.assertEquals("This text appears when you click the \"Learn more\" button",text);

        BrowserUtilities.sleep(2);
        Driver.getDriver().quit();
    }
}
