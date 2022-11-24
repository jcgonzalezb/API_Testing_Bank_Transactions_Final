package org.Globant.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.Globant.endpoints.BankTransactions;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseTest {

    @BeforeClass
    public static void setupURL()
    {
        // here we set up the default URL and API base path to use throughout the tests
        RestAssured.baseURI = "https://637d966d9c2635df8f89fa85.mockapi.io";
        RestAssured.basePath = "/api/v1/bankTransactions/";
    }

    //public List<BankTransactions> getAllTransactions(String endpoint) {
    //    Response response = given().contentType("application/json").when().get(endpoint"); }

    //    public boolean deleteAllTransactions(String endpoint) {
    //  List<Boolean> deleteTransactionsStatus = new ArrayList<>();    }

}
