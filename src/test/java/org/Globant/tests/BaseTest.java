package org.Globant.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.Globant.endpoints.BankTransaction;
import org.Globant.reporting.Reporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        Response response = given()
                .contentType("application/json")
                .when()
                .delete(endpoint + bankTransaction.getId());
        return response.getStatusCode();
    }

    protected boolean deleteAllTransactions(String endpoint) {
        List<BankTransaction> transactions = getAllTransactions(endpoint);
        if (transactions.size() == 0) {
            return Reporter.error("No Transactions were found on the endpoint.");
        } else if (transactions.size() > 0) {
            for (int i = 0; i < transactions.size(); i++) {
                int statusCode = deleteTransaction(endpoint, transactions.get(i));
                if (statusCode != 200){
                    Reporter.error("Transaction cannot be deleted " + "Status code: " + statusCode);
                }
            }
        }
        return true;
    }

    protected int createTransaction(String endpoint, BankTransaction bankTransaction){
        Response response = given()
                .contentType("application/json")
                .body(bankTransaction)
                .when()
                .post(endpoint);
        return response.getStatusCode();
    }

    protected List<BankTransaction> createTransactions (int amount) {
        List<BankTransaction> transactions = new ArrayList<>();

        Faker feku = new Faker(new Locale("en-US"));

        for(int i =0; i < amount; i++) {
            transactions.add(new BankTransaction(
                    feku.name().firstName(),
                    feku.name().lastName(),
                    feku.number().numberBetween(0, 999999),
                    feku.number().randomDouble(2, 0, 10000),
                    feku.options().option("withdrawal","payment","invoice","deposit"),
                    feku.internet().emailAddress(),
                    feku.random().nextBoolean(),
                    feku.address().country(),
                    feku.phoneNumber().cellPhone()
            ));

        }
        return transactions;
    }

    protected boolean uploadAllTransactions(String endpoint, int amount) {
        List<BankTransaction> transactions = createTransactions(amount);
        if (transactions.size() == 0) {
            return Reporter.error("No Transactions were created.");
        } else if (transactions.size() > 0) {
            for (int i = 0; i < transactions.size(); i++) {
                int statusCode = createTransaction(endpoint, transactions.get(i));
                if (statusCode != 201){
                    Reporter.error("Transaction cannot be created" + "Status code: " + statusCode);
                }
            }
        }
        return true;
    }

    private boolean checkForDuplicates(List emailList) {
        for (int i = 0; i < emailList.size(); i++) {
            for (int j = i + 1; j < emailList.size(); j++) {
                System.out.println(emailList.get(i));
                if (emailList.get(i) != null && emailList.get(i).equals(emailList.get(j))) {
                    return false;
                }
            }
        }
        System.out.println(emailList);
        return true;
    }

    protected boolean checkDuplicateEmail(String endpoint) {
        List<BankTransaction> transactions = getAllTransactions(endpoint);
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < transactions.size(); i++) {
            emailList.add(transactions.get(i).getEmail());
        }
        if (checkForDuplicates(emailList) == true) {
            return true;
        } else {
            return false;
        }
    }




    protected int updateTransaction(String endpoint, BankTransaction bankTransaction){
        Response response = given()
                .contentType("application/json")
                .body(bankTransaction)
                .when()
                .put(endpoint);
        return response.getStatusCode();
    }

    protected boolean createUpdateInformation (String endpoint) {
        List<BankTransaction> transactions = getAllTransactions(endpoint);
        List<Integer> accountNumbers = new ArrayList<>();
        int min = 0;
        int max = 9;
        int randomIndex = (int) (Math.random() * (max - min + 1) + min);
        if (transactions.size() == 0) {
            return Reporter.error("No Transactions were found on the endpoint.");
        } else if (transactions.size() > 0) {
            for (int i = 0; i < transactions.size(); i++) {
                accountNumbers.add(transactions.get(i).getAccountNumber());
                }
            int accountNumberUpdate = accountNumbers.get(randomIndex);
            for (int i = 0; i < transactions.size(); i++) {
                    if (transactions.get(i).getAccountNumber() == accountNumberUpdate) {
                        Reporter.info("The Account Number currently updating is: " + accountNumberUpdate);
                        transactions.get(i).setName("Thomas");
                        transactions.get(i).setLastName("Anderson");
                        transactions.get(i).setCountry("Colombia");
                        transactions.get(i).setAmount(10000.01);
                        String updateEndpoint = endpoint +  transactions.get(i).getId() ;
                        int statusCode = updateTransaction(updateEndpoint, transactions.get(i));
                        if (statusCode != 200) {
                            Reporter.error("Transaction cannot be created" + "Status code: " + statusCode);
                        }
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
