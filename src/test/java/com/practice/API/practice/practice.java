package com.practice.API.practice;

import com.practice.library.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class practice {
    static {
        RestAssured.baseURI= ConfigurationReader.getProperty("JPAPI");
    }

    @Test
    @DisplayName("GET all posts")
    void getAll() {
        RestAssured.given().when().accept(ContentType.JSON).get("/posts").then().statusCode(200).contentType(ContentType.JSON).extract().response().prettyPrint();
    }

    @Test
    @DisplayName("GET comment for postId=2")
    void getComment() {
        RestAssured.given().when().queryParam("postId",2).accept(ContentType.JSON).get("/comments").then().statusCode(200).contentType(ContentType.JSON).extract().response().prettyPrint();
    }

    @Test
    @DisplayName("POST creation with map")
    void createPost() {
        Map<String,Object> map = new HashMap<>();
        map.put("title","Post title");
        map.put("body","Lorem ipsum dolor it amet...");
        map.put("userId",1);

        RestAssured.given().when().accept(ContentType.JSON).body(map).post("/posts").then().statusCode(201).contentType(ContentType.JSON);
    }

    //TODO
    @Test
    @DisplayName("POST creation with POJO")
    void createPostPOJO() {
    }

    @Test
    @DisplayName("Delete post with id 7")
    void deletePost() {
        RestAssured.given().when().pathParams("postId",7)
    .delete("/posts/{postId}").then().statusCode(200);
    }

    @Test
    @DisplayName("Update post with postId 3")
    void updatePost() {
        //Map<String,Object> map = new HashMap<>();
        //map.put("title","New title");
        RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)//not updating when missing
                .pathParam("postId",3)
                .body("""
                        {
                        "title":"New title"
                         }""")
                .when()
                .patch("/posts/{postId}")

                .then().statusCode(200).body("title",equalTo("New title"))
                .extract().response().prettyPrint();

    }

}
