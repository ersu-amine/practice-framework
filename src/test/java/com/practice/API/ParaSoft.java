package com.practice.API;

import com.practice.library.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParaSoft {

    @Test
    public void getUser() {
        RestAssured.baseURI = ConfigurationReader.getProperty("parasoft_API");

        //login
        Map <String, String> pathParams = new HashMap<>();
        pathParams.put("username", ConfigurationReader.getProperty("username"));
        pathParams.put("password", ConfigurationReader.getProperty("password"));

        //Response response = RestAssured.given().accept(ContentType.JSON).and().pathParam("username", ConfigurationReader.getProperty("username")).and().pathParam("password", ConfigurationReader.getProperty("password")).log().all().when().get("/login/{username}/{password}");

        Response response = RestAssured.given().accept(ContentType.JSON).
                and().pathParams(pathParams).log().all().when().get("/login/{username}/{password}");

        response.prettyPrint();
    }
}
