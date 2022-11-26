package org.Globant.tests;

import io.restassured.response.Response;
import org.Globant.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Represents to obtain all bank transaction from endpoint and duplicate email check test.
 *
 * @author juancamilo.gonzalez
 * @version 1.0
 */
public class ObtainTransactionsTest extends BaseTest {

    /** Gets all the bank transaction available on the endpoint and checks if all client´s
     * emails are different.
     * @result A list of bank transactions from the endpoint with no client´s emails duplicated.
     * */
    @Parameters({"endpoint"})
    @Test
    public void getTransactionsTest(String endpoint) {
        Reporter.info("Getting all transactions from the endpoint...");
        Reporter.info("Amount of transactions on the endpoint: "
                + getAllTransactions(endpoint).size() + " transactions.");
        Reporter.info("Checking all transactions from the endpoint looking for duplicate emails");
        Assert.assertTrue(checkDuplicateEmailEndpoint(endpoint),
                "Two or more transactions on the endpoint have the same email address.");
        Reporter.info("All transactions have different emails. No duplicated emails were found.");
    }
}
