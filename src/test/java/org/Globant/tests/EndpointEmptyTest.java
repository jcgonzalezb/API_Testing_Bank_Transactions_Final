package org.Globant.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EndpointEmptyTest {

    @Test
    public void getUser() {
        given().when().get("https://637d966d9c2635df8f89fa85.mockapi.io/api/v1/bankTransactions/1");
    }
}
