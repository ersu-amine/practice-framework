package com.practice.API.RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;


import java.util.HashMap;
import java.util.Map;

public class Auth {

    public static String getAuthToken() {
        String reqBody = "{\"username\": \"admin\", \"password\": \"password123\"}";
        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("username", "admin");
        mapBody.put("password", "password123");

        String token = "";
        JsonPath jPath = RestAssured.given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .body(mapBody)
                .post("/auth")
                .then()
                .statusCode(201)
                .extract().jsonPath();

        //jPath.prettyPrint();

        token = jPath.getString("token");
        return token;
    }

}
