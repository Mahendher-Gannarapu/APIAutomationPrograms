package com.mahendhergannarapu.SimpleTest;

import io.restassured.RestAssured;

public class APITest002 {
    public static void main(String[] args) {

        //Rest Assured work with Gherkins Syntax
        //Full Url : https://restful-booker.herokuapp.com/booking/1
        //baseUri : https://restful-booker.herokuapp.com
        //basePath : booking/1
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/1")
                .when()
                    .get()
                .then().log().all() //log.all for printing details
                    .statusCode(200);

    }
}
