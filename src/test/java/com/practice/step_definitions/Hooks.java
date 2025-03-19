package com.practice.step_definitions;

import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
    Logger LOG = LogManager.getLogger();

    @Before
    public void setup(){
        Driver.getDriver().manage().window().maximize();
        LOG.info("Getting ready");
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("parasoft_web"));
        LOG.info("Navigating to Welcome page");
    }

    @After
    public void tearDown(){
        LOG.info("Shutting down");
        Driver.closeDriver();
    }
}
