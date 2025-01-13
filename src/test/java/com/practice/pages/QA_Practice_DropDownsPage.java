package com.practice.pages;

import com.practice.library.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class QA_Practice_DropDownsPage {
    public QA_Practice_DropDownsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//select[@id='dropdown-menu']")
    public WebElement selectDropdown;


}
