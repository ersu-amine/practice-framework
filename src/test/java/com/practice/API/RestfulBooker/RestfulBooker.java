package com.practice.API.RestfulBooker;

import com.practice.library.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class RestfulBooker {
    static {
        RestAssured.baseURI = ConfigurationReader.getProperty("restfulAPI");
    }

    @Test
    @DisplayName("GET - Health Check")
    public void healthCheck() {
        //status code 201
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get("/ping")
                .then()
                .statusCode(201)
                .extract().response();

        response.prettyPrint();

        //TODO assert response body has "Created"
    }

    @Test
    @DisplayName("GET - Bookings list, no Auth")
    public void getBookings(){
        JsonPath jsonPath = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().jsonPath();

        //TODO create booking, save id and assert if present
    }


}
