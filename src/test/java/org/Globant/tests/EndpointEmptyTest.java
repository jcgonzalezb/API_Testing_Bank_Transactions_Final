package org.Globant.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.Globant.endpoints.BankTransactions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EndpointEmptyTest extends BaseTest {

    @Test
    public void verifyEndpointIsEmpty() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

        //given().when().get("https://637d966d9c2635df8f89fa85.mockapi.io/api/v1/bankTransactions/1").then().assertThat().statusCode(200);


        //ArrayList<Map<String,?>> jsonAsArrayList = from(jsonAsString).get("");

        //Response response = given().contentType("application/json").when().get("https://637d966d9c2635df8f89fa85.mockapi.io/api/v1/bankTransactions/");
        //List<transaction> allTransaction = jsonPathEvaluator.getList("BankTransactions");
        //response.then().extract().response();
        //response.prettyPrint();

    }
}
