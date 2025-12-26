package com.practice.API;


import com.practice.library.BrowserUtilities;
import com.practice.library.Driver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenLinksPractice {
    @Test
    public void brokenLinksTest() {

        Driver.getDriver().get("https://www.automationexercise.com/"); //navigate to website
        //implement explicit wait for loading all link

        BrowserUtilities.waitPageLoad(); //waits until page fully loaded

        //get all the links
        List<WebElement> links = Driver.getDriver().findElements(By.xpath("//a[@href]"));

        for (WebElement link : links) {
            //add all href ttribute which contains the link to the list
            //hrefs.add(link.getAttribute("href"));

            String hrefLink = link.getAttribute("href");
            System.out.println(hrefLink);
            Response response = RestAssured.given().when().get(hrefLink);

            //print broken links
            if(response.statusCode()!=200){
                System.out.println(hrefLink);
            }
        }

        Driver.closeDriver();

    }

}
