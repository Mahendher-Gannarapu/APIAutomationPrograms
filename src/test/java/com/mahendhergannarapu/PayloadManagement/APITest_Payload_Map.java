//=======================================================
//But this is not suitable for heavy JSON
//If we have a heavy payload it is a hectic process
//======================================================
package com.mahendhergannarapu.PayloadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITest_Payload_Map {

    //instance variables
    RequestSpecification requestSpecification;
    //Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void testPOSTReq()
    {
        //{
        //    "firstname" : "Jim",
        //    "lastname" : "Brown",
        //    "totalprice" : 111,
        //    "depositpaid" : true,
        //    "bookingdates" : {
        //        "checkin" : "2018-01-01",
        //        "checkout" : "2019-01-01"
        //    },
        //    "additionalneeds" : "Breakfast"
        //}


        //Convert JSON -> HashMap
        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname", "Jim");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice", "111");
        jsonBodyUsingMap.put("depositpaid", "true");


        Map<String,Object> bookingsDateMap = new LinkedHashMap();
        bookingsDateMap.put("checkin","2018-01-01");
        bookingsDateMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingsDateMap);
        jsonBodyUsingMap.put( "additionalneeds","Breakfast");

        System.out.println(jsonBodyUsingMap);

        //Output
        //{
        // firstname=Jim,
        // lastname=Brown,
        // totalprice=111,
        // depositpaid=true,
        // bookingdates=
        // {checkin=2018-01-01,
        // checkout=2019-01-01},
        // additionalneeds=Breakfast
        // }

        //Its not looking like JSON its look like HashMap
        // Map is very close too JSON
        // Map to JSON conversion will done third party libraries like GSON or JackSon

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your booking id is ->"+ bookingId);

        //=======================================================
        //But this is not suitable for heavy JSON
        //If we have a heavy payload it is a hectic process
        //======================================================
    }
}
