package com.practice.step_definitions;

import com.practice.library.ConfigurationReader;
import com.practice.pages.parasoft.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginSteps extends LoginPage {
    Logger LOG = LogManager.getLogger();
    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        //navigation happens in hooks
        LOG.info("User is on main page");
    }
    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
    }
    @Then("user logs in successfully")
    public void user_logs_in_successfully() {
        //TODO assertion confirmint login
    }

    @When("user enters invalid credentials")
    public void userEntersInvalidCredentials() {
        login("username","password");
    }
}
