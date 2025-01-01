package com.mahendhergannarapu.PayloadManagement.Serialization_De_Ser;

import com.google.gson.Gson;
import com.mahendhergannarapu.PayloadManagement.Serialization_De_Ser.Booking;
import com.mahendhergannarapu.PayloadManagement.Serialization_De_Ser.Bookingdates;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class APITest_GSON_Demo {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPositive()
    {
        // Step1 - POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth - NO


        // Step 2
        // prepare the Payload ( Object -> JSON String)
        // send the request

        //Step 3
        // Validate Response ( JSON String -> Object)
        // FirstName,
        // Status Code
        // Time Response

        Booking booking = new Booking();
        booking.setFirstname("Mahendher");
        booking.setLastname("Gannarapu");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        Gson gson = new Gson();

        // Convert Object to JSON String through GSON - Serialization
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString  = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Verify the response in two ways
        // Case 1- Use 1.extract() or 2.jsonPath().getString() -
        // When your Response is small its working Fine


        // Case 2- When your Response -> Complex JSON  - Huge JSON
        // then convert to String to Object  - De Serialization

        BookingResponse bookingResponse = gson.fromJson(jsonResponseString, BookingResponse.class);

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Mahendher").isNotNull().isNotEmpty();


    }
}
