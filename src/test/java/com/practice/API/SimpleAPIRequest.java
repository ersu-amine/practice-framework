package com.practice.API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleAPIRequest {
    @Test
    void get() {
        Response response = RestAssured.get("http://openlibrary.org/search.json?q=the+lord+of+the+rings").then().extract().response();

        JsonPath jsonPath = response.jsonPath();
    }
}
