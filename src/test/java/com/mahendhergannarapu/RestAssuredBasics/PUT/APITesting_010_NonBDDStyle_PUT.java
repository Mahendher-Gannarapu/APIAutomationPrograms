package com.mahendhergannarapu.RestAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_010_NonBDDStyle_PUT {

    /* Currently using hardcoded but future if we want get token
    and Booking_Id use below code
    public void get_token()
    {
    }

    public void get_booking_id(){
    return bookingid;
    }
     */

    /*
    {
    "token": "1bbc44cfcd9e8aa"
    }

{
    "bookingid": 2296,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
}
     */
    @Description("Verify the PUT request for the Restful Booker APIs")
    @Test
    public void test_PUT_NonBDD()
    {
        //Booking id
        //Token
        /*Payload
        {
    "firstname" : "SrihansMahendher",
    "lastname" : "Kartikeya",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
         */

        String token ="73567aa971277b0";
        String bookingid = "2499";

        String payload = "        {\n" +
                "    \"firstname\" : \"Mahi\",\n" +
                "    \"lastname\" : \"G\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType("application/json");
        r.cookie("token",token);
        //r.auth().preemptive().basic("admin","password123");
        r.body(payload).log().all();

        Response response= r.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



    }
}
