package com.mahendhergannarapu.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Test03_Assertions_Real_Ex {
         //POST - Create -> Verify the response
        // Verify the response by using the assertions

        RequestSpecification requestSpecification;
        ValidatableResponse validatableResponse;
        Response response;
        String token;
        Integer bookingId;

        public void test_post()
        {
            String payload_POST = "{\n" +
                    "    \"firstname\" : \"Mahendher\",\n" +
                    "    \"lastname\" : \"Gannnarapu\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : false,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2024-01-01\",\n" +
                    "        \"checkout\" : \"2024-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Lunch\"\n" +
                    "}";

            requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
            requestSpecification.basePath("/booking");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(payload_POST).log().all();

            response = requestSpecification.when().post();

            // Get Validate response to perform validation
            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);

            // There are 3 libraries available for assertions
            //1. Validate Response -I- Hamcreast - Rest Assured- Its automatically available

            // Rest Assured Default - Hamcrest(have lot limitations, don't prepor)
            // import org.hamcrest.Matchers;
            validatableResponse.body("booking.firstname", Matchers.equalTo("Mahendher"));
            validatableResponse.body("booking.lastname", Matchers.equalTo("Gannarapu"));
            validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));
            validatableResponse.body("bookingid", Matchers.notNullValue());


            //2 TestNG Assertions (This is good but now a days we are not using this also)
            // SoftAssert vs HardAssert -

            bookingId = response.then().extract().path("bookingId");
            String firstname = response.then().extract().path("booking.firstname");
            String lastname = response.then().extract().path("booking.lastname");

            Assert.assertNotNull(bookingId);
            Assert.assertEquals(firstname, "Mahendher");
            Assert.assertEquals(lastname, "Gannarapu");

            //3 AssertJ( 3rd -Lib to assertions) (Now a day using this)
            assertThat(bookingId).isNotNull().isPositive().isNotZero();
            assertThat(firstname).isEqualTo("Mahendher").isNotNull().isNotBlank().isNotEmpty().isAlphanumeric();
            assertThat(lastname).isEqualTo("Gannarapu").isNotNull().isNotBlank().isNotEmpty().isAlphanumeric();

        }

}
