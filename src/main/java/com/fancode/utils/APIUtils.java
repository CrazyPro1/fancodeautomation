package com.fancode.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.fancode.config.ConfigReader;

public class APIUtils {
    static {
        RestAssured.baseURI = ConfigReader.getProperty("base.url");
    }

    public static Response get(String endpoint) {
        return RestAssured.given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract().response();
    }
}
