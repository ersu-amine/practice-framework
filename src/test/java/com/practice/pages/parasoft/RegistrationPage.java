package com.practice.pages.parasoft;

import com.practice.library.BrowserUtilities;
import com.practice.library.ConfigurationReader;
import com.practice.library.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement address;

    @FindBy(id = "customer.address.city")
    private WebElement city;

    @FindBy(id = "customer.address.state")
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipcode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phone;

    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @FindBy(id = "customer.username")
    private WebElement usernameInput;

    @FindBy(id = "customer.password")
    private WebElement passwordInput;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPasswordInput;

    @FindBy(css = "input[value='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@id='rightPanel']/p")
    private WebElement messageConfirmation;

    public void register() {
        try {
            //TODO implement randomized information for user
            firstName.sendKeys(ConfigurationReader.getProperty("firstname"));
            lastName.sendKeys(ConfigurationReader.getProperty("lastname"));
            address.sendKeys(ConfigurationReader.getProperty("address"));
            city.sendKeys(ConfigurationReader.getProperty("city"));
            state.sendKeys(ConfigurationReader.getProperty("state"));
            zipcode.sendKeys(ConfigurationReader.getProperty("zipcode"));
            phone.sendKeys(ConfigurationReader.getProperty("phone"));
            ssn.sendKeys(ConfigurationReader.getProperty("ssn"));
            String username = ConfigurationReader.getProperty("username");
            String password = ConfigurationReader.getProperty("password");
            BrowserUtilities.sleep(2);
            usernameInput.sendKeys(username);
            passwordInput.sendKeys(password);
            confirmPasswordInput.sendKeys(password);
            BrowserUtilities.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
        }
    }
    public void clickRegisterButton() {
        registerButton.click();
    }

    public void verifyRegistrationMessage(String message){
        try {
            BrowserUtilities.sleep(2);
            Assert.assertEquals(message, messageConfirmation.getText());
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            throw new RuntimeException(e);
        }
    }

}
