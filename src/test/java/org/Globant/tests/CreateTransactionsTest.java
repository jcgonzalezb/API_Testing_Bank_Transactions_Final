package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateTransactionsTest extends BaseTest {

    @Parameters({"endpoint"})
    @Test
    public void createTransactionsTest(String endpoint) {
        Reporter.info("Initializing the POJO and creating ten transactions using random data.");
        Reporter.info("Checking new transactions, looking for duplicate emails.");
        Assert.assertTrue(uploadAllTransactions(endpoint, 10),
                "Not all transactions were created on the endpoint.");
        Reporter.info("Sending the ten transactions to the endpoint...");
        Reporter.info("All ten transactions were created on the endpoint." );
    }
}


