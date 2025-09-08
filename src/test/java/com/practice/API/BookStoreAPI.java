package com.practice.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class BookStoreAPI {
    //https://demoqa.com/books
    //https://demoqa.com/swagger/#/Account/AccountV1UserPost

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "https://demoqa.com";
    }

    private static String getToken(String username, String password){
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
        response.body().prettyPrint();
        JsonPath jsonPath = response.jsonPath();

        return jsonPath.getString("token");

    }

    //TODO implement masking username and password
    @Test
    void createUser() {
        Map < String, String> userData = Map.of("userName","theflash9","password","Hello123@");

        RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .post("/Account/v1/User").prettyPeek()
        .then().statusCode(201).and().contentType(ContentType.JSON);
    }


    
}
