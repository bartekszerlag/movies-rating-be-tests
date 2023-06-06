package tests;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

public class Base {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://movies-rating-service.herokuapp.com";
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter()
        );
    }
}