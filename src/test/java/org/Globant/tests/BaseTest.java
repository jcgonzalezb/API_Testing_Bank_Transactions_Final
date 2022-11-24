package org.Globant.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.Globant.endpoints.BankTransaction;
import org.Globant.reporting.Reporter;

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

    protected int deleteTransaction(String endpoint, BankTransaction bankTransaction){
        System.out.println(bankTransaction.getId());
        Response response = given().contentType("application/json")
                .when()
                .delete(endpoint + "/" + bankTransaction.getId());
        System.out.println(response.prettyPrint());
        return response.getStatusCode();
    }

    protected boolean deleteAllTransactions(String endpoint) {
        List<BankTransaction> transactions = getAllTransactions(endpoint);
        if (transactions.size() > 0) {
            for (int i = 0; i < transactions.size(); i++) {
                int statusCode = deleteTransaction(endpoint, transactions.get(i));
                if (statusCode != 200){
                    Reporter.error("Transaction cannot be deleted" + "Status code: " + statusCode);
                }
            }
        }
        return true;
    }





    //public List<BankTransactions> getAllTransactions(String endpoint) {
    //    Response response = given().contentType("application/json").when().get(endpoint"); }

    //    public boolean deleteAllTransactions(String endpoint) {
    //  List<Boolean> deleteTransactionsStatus = new ArrayList<>();    }

}
