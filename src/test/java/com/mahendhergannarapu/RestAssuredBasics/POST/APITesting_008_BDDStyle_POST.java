package com.mahendhergannarapu.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_008_BDDStyle_POST {
    // url: https://restful-booker.herokuapp.com/auth
    // Header: Content-Type: application/json
    // Body:
    // {
    //    "username" : "admin",
    //    "password" : "password123"
    //}

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the POST Request - BDD Style")
    @Test
    public void test_Post_BDD_POSITIVE() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType("application/json")
                    .log().all().body(payload)
                .when()
                    .log().all()
                    .post()
                .then()
                    .log().all()
                    .statusCode(200);
    }


    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify the POST Request - BDD Style")
    @Test
    public void test_Post_BDD_NEGATIVE() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password\"\n" +
                "}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType("application/json")
                .log().all().body(payload)
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(200);
    }
}
