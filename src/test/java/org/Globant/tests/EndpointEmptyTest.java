package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class EndpointEmptyTest extends BaseTest {

    @Parameters({"endpoint"})
    @Test
    public void verifyEndpointIsEmpty(String endpoint) {
        Reporter.info("Getting all transactions from the endpoint...");
        Reporter.info("Amount of transactions on the endpoint: "
                + getAllTransactions(endpoint).size() + " transactions.");
        Assert.assertTrue(deleteAllTransactions(endpoint),
                "All transaction on the endpoint were not deleted");
        Reporter.info("Amount of transactions on the endpoint: "
                + getAllTransactions(endpoint).size() + " transactions.");
        Reporter.info("The endpoint is empty.");
    }
}
