package com.practice.pages;

import com.practice.library.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EvilTesterAlertsPage {
    public EvilTesterAlertsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (css = "input#promptexample")
    public WebElement promptAlert;
}
