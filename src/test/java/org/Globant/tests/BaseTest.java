package org.Globant.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.Globant.endpoints.BankTransaction;
import org.Globant.reporting.Reporter;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static io.restassured.RestAssured.given;

/**
 * Represents the base test used for all the tests implemented.
 *
 * @author juancamilo.gonzalez
 * @version 1.0
 */
public class BaseTest {

    /** Gets all the bank transaction available on the endpoint.
     * The HTTP GET request is applied.
     * @param endpoint The endpoint in which the bank transactions are located.
     * @return A list of all the bank transactions on the endpoint.
     */
    protected List<BankTransaction> getAllTransactions (String endpoint){
        RestAssured.baseURI = endpoint;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200,
                "Transactions were not obtained properly.");

        JsonPath jsonPathEvaluator = response.jsonPath();
        List<BankTransaction> allTransactions = jsonPathEvaluator.getList("",
                BankTransaction.class);
        return allTransactions;
    }

    /** Deletes a bank transaction on the endpoint.
     * The HTTP DELETE request is applied.
     * @param endpoint The endpoint in which the bank transactions are located.
     * @param transaction The transaction to be deleted.
     * @return An integer representing the status code obtained after the delete request
     * is applied.
     */
    protected int deleteTransaction(String endpoint, BankTransaction transaction){
        Response response = given()
                .contentType("application/json")
                .when()
                .delete(endpoint + transaction.getId());
        return response.getStatusCode();
    }

    /** Deletes all bank transactions on the endpoint.
     * The HTTP DELETE request is applied.
     * @param endpoint The endpoint in which the bank transactions are located.
     * @return True if all the bank transactions are deleted successfully, otherwise
     * the return is false.
     */
    protected boolean deleteAllTransactions(String endpoint) {
        List<BankTransaction> transactions = getAllTransactions(endpoint);
        if (transactions.size() == 0) {
            return Reporter.error("No Transactions were found on the endpoint.");
        } else if (transactions.size() > 0) {
            for (int i = 0; i < transactions.size(); i++) {
                int statusCode = deleteTransaction(endpoint, transactions.get(i));
                if (statusCode != 200){
                    Reporter.error("Transaction cannot be deleted. " +
                            "Status code: " + statusCode);
                }
            }
        }
        return true;
    }

    /** Initializes the POJO with ten random data to create ten bank transactions.
     * @param amount The amount of bank transactions to be created. In this case,
     * ten bank transactions.
     * @return A list of ten bank transactions created based on random data.
     */
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

    /** Checks a list and looks for duplicate items.
     * @param items A list of items.
     * @return True if no duplicate items found in the list, otherwise the return is false.
     */
    private boolean checkForDuplicates(List items) {
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i) != null && items.get(i).equals(items.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /** Checks a bank transactions list and looks for duplicate emails.
     * @param transactionsList A list of bank transactions.
     * @return True if there are no duplicate emails in the list,
     * otherwise the return is false.
     */
    protected boolean checkDuplicateEmailList(List transactionsList) {
        List<BankTransaction> transactions = transactionsList;
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < transactions.size(); i++) {
            emailList.add(transactions.get(i).getEmail());
        }
        return checkForDuplicates(emailList);
    }

    /** Checks a bank transactions list extracted from the endpoint and looks
     * for duplicate emails.
     * @param endpoint The endpoint in which the bank transactions are located.
     * @return True if there are no duplicate emails on the endpoint,
     * otherwise the return is false.
     */
    protected boolean checkDuplicateEmailEndpoint(String endpoint) {
        List<BankTransaction> transactions = getAllTransactions(endpoint);
        return checkDuplicateEmailList(transactions);
    }

    /** Posts a bank transaction on the endpoint.
     * The HTTP POST request is applied.
     * @param endpoint The endpoint in which the bank transactions are located.
     * @param transaction The transaction to be posted.
     * @return An integer representing the status code obtained after the post request
     * is applied.
     */

    protected int createTransaction(String endpoint, BankTransaction transaction){
        Response response = given()
                .contentType("application/json")
                .body(transaction)
                .when()
                .post(endpoint);
        return response.getStatusCode();
    }

    /** Posts all bank transactions created on the endpoint.
     * The HTTP POST request is applied.
     * @param endpoint The endpoint in which the bank transactions are located.
     * @param amount The amount of bank transactions to be created. In this case,
     * ten bank transactions.
     * @return True if all the bank transactions are posted successfully, otherwise
     * the return is false.
     */
    protected boolean uploadAllTransactions(String endpoint, int amount) {
        List<BankTransaction> transactions = createTransactions(amount);
        if (transactions.size() == 0) {
            return Reporter.error("No Transactions were created.");
        } else if (transactions.size() > 0) {
            if (!checkDuplicateEmailList(transactions)) {
                return false;
            }
            for (int i = 0; i < transactions.size(); i++) {
                int statusCode = createTransaction(endpoint, transactions.get(i));
                if (statusCode != 201){
                    Reporter.error("Transaction cannot be posted. " +
                            "Status code: " + statusCode);
                }
            }
        }
        return true;
    }

    /** Updates a bank transaction on the endpoint.
     * The HTTP PUT request is applied.
     * @param endpoint The endpoint in which the bank transactions are located.
     * @param transaction The transaction to be updated.
     * @return An integer representing the status code obtained after the put request
     * is applied.
     */
    protected int updateTransaction(String endpoint, BankTransaction transaction){
        Response response = given()
                .contentType("application/json")
                .body(transaction)
                .when()
                .put(endpoint);
        return response.getStatusCode();
    }

    /** Updates the account number of a bank transaction created on the endpoint.
     * The HTTP PUT request is applied.
     * @param endpoint The endpoint in which the bank transactions are located.
     * @return True if the bank transaction is updated successfully, otherwise
     * the return is false.
     */
    protected boolean createUpdateInformation (String endpoint) {
        List<BankTransaction> transactions = getAllTransactions(endpoint);
        List<Integer> accountNumbers = new ArrayList<>();
        int min = 0;
        int max = 9;
        int maxAccountNumber = 999999;
        int randomIndex = (int) (Math.random() * (max - min + 1) + min);
        int newAccountNumber = (int) (Math.random() * (maxAccountNumber - min + 1) + min);
        if (transactions.size() == 0) {
            return Reporter.error("No Transactions were found on the endpoint.");
        } else if (transactions.size() > 0) {
            for (int i = 0; i < transactions.size(); i++) {
                accountNumbers.add(transactions.get(i).getAccountNumber());
                }
            int accountNumberUpdate = accountNumbers.get(randomIndex);
            if (!accountNumbers.contains(accountNumberUpdate)) {
                return false;
            }
            for (int i = 0; i < transactions.size(); i++) {
                if (transactions.get(i).getAccountNumber() == accountNumberUpdate) {
                    Reporter.info("The transaction with Account Number " +
                            accountNumberUpdate + " will be updated.");
                    transactions.get(i).setAccountNumber(newAccountNumber);
                    Reporter.info("The Account Number " + accountNumberUpdate +
                            " was replaced by the new account number " +
                            newAccountNumber + ".");
                    String updateEndpoint = endpoint +  transactions.get(i).getId() ;
                    int statusCode = updateTransaction(updateEndpoint, transactions.get(i));
                    if (statusCode != 200) {
                        Reporter.error("The transaction cannot be updated. " +
                                "Status code: " + statusCode);
                    }
                }
            }
        }
        return true;
    }
}
