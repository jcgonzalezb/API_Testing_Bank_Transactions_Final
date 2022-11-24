package org.Globant.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.Globant.endpoints.BankTransaction;

import java.util.List;

import static io.restassured.RestAssured.given;


public class BaseTest {


    protected List<BankTransaction> getAllTransactions (String endpoint){
        RestAssured.baseURI = endpoint;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");

        JsonPath jsonPathEvaluator = response.jsonPath();
        List<BankTransaction> allTransactions = jsonPathEvaluator.getList("", BankTransaction.class);
        return allTransactions;
    }

    protected void deleteTransaction(String endpoint, BankTransaction bankTransaction){
        Response response = given()
                .contentType("application/json")
                .when()
                .delete(endpoint + "/" + bankTransaction + bankTransaction.getId());
    }

    protected void deleteAllTransactions() {



    }





    //public List<BankTransactions> getAllTransactions(String endpoint) {
    //    Response response = given().contentType("application/json").when().get(endpoint"); }

    //    public boolean deleteAllTransactions(String endpoint) {
    //  List<Boolean> deleteTransactionsStatus = new ArrayList<>();    }

}
