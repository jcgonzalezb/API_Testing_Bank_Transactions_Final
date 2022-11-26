package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateTransactionsTest extends BaseTest {

    @Parameters({"endpoint"})
    @Test
    public void createTransactionsTest(String endpoint) {
        Reporter.info("Creating 10 transactions using random data." );
        Assert.assertTrue(uploadAllTransactions(endpoint, 10),
                "Not all transactions were created");
        Reporter.info("All ten transactions were created on the endpoint." );
    }
}


