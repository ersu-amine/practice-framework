package com.practice.pages;

import com.practice.library.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAPracticeAlertsPage {
    public QAPracticeAlertsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "button#alert-btn")
    public WebElement alertButton;

    @FindBy(css = "button#confirm-btn")
    public WebElement confirmAlertButton;
}
