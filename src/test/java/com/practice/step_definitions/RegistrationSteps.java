package com.practice.step_definitions;

import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import com.practice.pages.parasoft.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationSteps extends RegistrationPage {
    Logger LOG = LogManager.getLogger();

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("registration"));
        LOG.info("Navigation to registration page is successful");
    }

    @And("user fills registration form")
    public void user_fills_registration_form() {
        register();
    }

    @And("user clicks Register button")
    public void user_clicks_register_button() {
        clickRegisterButton();
    }

    @Then("user sees message {string}")
    public void user_sees_message(String confirmationMessage) {
        verifyRegistrationMessage(confirmationMessage);
        LOG.info("Registration is complete");
    }
}
