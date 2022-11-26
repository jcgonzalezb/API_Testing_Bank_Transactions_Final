package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Represents the update an existing account number test.
 *
 * @author juancamilo.gonzalez
 * @version 1.0
 */
public class UpdateTransactionTest extends BaseTest {

    /** Updates the account number of a bank transaction on the endpoint.
     * @result A bank transaction has a new account number.
     * */
    @Parameters({"endpoint"})
    @Test
    public void updateAccountNumberTest(String endpoint) {
        Reporter.info("Getting all transactions from the endpoint...");
        Reporter.info("Amount of transactions on the endpoint: "
                + getAllTransactions(endpoint).size() + " transactions.");
        Assert.assertTrue(createUpdateInformation(endpoint),
                "Account number not found on endpoint.");
        Reporter.info("A transaction was updated using an existing account number.");
    }
}
