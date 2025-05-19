package com.practice.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class BookerAPI {
    //https://demoqa.com/books
    //https://demoqa.com/swagger/#/Account/AccountV1UserPost

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "https://demoqa.com";
    }

    @Test
    void createUser() {
        Map < String, String> userData = Map.of("userName","theflash543","password","Hello123@");

        RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .post("/Account/v1/User").prettyPeek()
        .then().statusCode(201).and().contentType(ContentType.JSON);
    }
}
