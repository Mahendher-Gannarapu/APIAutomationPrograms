package com.mahendhergannarapu.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_009_NonBDDStyle_POST {
    // url: https://restful-booker.herokuapp.com/auth
    // Header: Content-Type: application/json
    // Body:
    // {
    //    "username" : "admin",
    //    "password" : "password123"
    //}

    @Description("Verify the POST Request - NonBDD Style")
    @Test
    public void test_NonBDD_Post_POSITIVE() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType("application/json").log().all();
        r.body(payload);
        r.when().post();
        r.then().log().all().statusCode(200);
    }

    @Description("Verify the POST Request - NonBDD Style")
    @Test
    public void test_NonBDD_Post_NEGATIVE() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType("application/json").log().all();
        r.body(payload);
        r.when().post();
        r.then().log().all().statusCode(203);
    }
}
