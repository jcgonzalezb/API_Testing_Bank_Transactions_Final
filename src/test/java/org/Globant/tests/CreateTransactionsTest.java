package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Represents the POJO initialization with random data and duplicate email check test.
 *
 * @author juancamilo.gonzalez
 * @version 1.0
 */
public class CreateTransactionsTest extends BaseTest {

    /** Creates on the endpoint ten bank transactions based on random data. All client´s
     * emails should be different.
     * @result Ten bank transactions on the endpoint based on random data with no client´s
     * emails duplicated.
     */
    @Parameters({"endpoint"})
    @Test
    public void createRandomTransactionsTest(String endpoint) {
        Reporter.info("Initializing the POJO and creating ten transactions using random data.");
        Reporter.info("Checking new transactions, looking for duplicate emails.");
        Assert.assertTrue(uploadAllTransactions(endpoint, 10),
                "Not all transactions were created on the endpoint.");
        Reporter.info("Sending the ten transactions to the endpoint...");
        Reporter.info("All ten transactions were created on the endpoint." );
    }
}


