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

    @FindBy(css = "div.dropdown>button")
    public  WebElement multiLevelDropdown;

    @FindBy(xpath = "//a[text() = 'Some other action']")
    public WebElement option2;

    @FindBy(xpath = "//a[text() = 'Hover me for more options']")
    public WebElement option3;

    @FindBy(xpath = "//a[text() = 'Even More..']")
    public WebElement secondLevelDropdown;

    @FindBy(xpath = "//a[text() = 'another level']")
    public WebElement thirdLevelDropdown;

    @FindBy(xpath = "//a[@href = '#4th-level-1']")
    public WebElement fourthLevelOption1;




}
