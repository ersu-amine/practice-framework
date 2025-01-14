package com.practice.pages;

import com.practice.library.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAPracticeiFramePage {
    public QAPracticeiFramePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "iframe#iframe-checkboxes")
    public WebElement iframeElement;

    @FindBy(xpath = "//h1")
    public WebElement headerInFrame;

    @FindBy(css = "a#learn-more")
    public WebElement learnMoreButton;

    @FindBy(css = "div#show-text")
    public WebElement hiddenText;


}
