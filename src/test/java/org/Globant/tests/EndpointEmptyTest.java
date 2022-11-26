package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Represents the empty endpoint verification test.
 *
 * @author juancamilo.gonzalez
 * @version 1.0
 */
public class EndpointEmptyTest extends BaseTest {

    /** Verifies that the endpoint is empty (If it has any data, it uses the DELETE request to
     * clean it and leaves it empty).
     * @result Empty endpoint.
     * */
    @Parameters({"endpoint"})
    @Test
    public void verifyEndpointIsEmpty(String endpoint) {
        Reporter.info("Getting all transactions from the endpoint...");
        Reporter.info("Amount of transactions on the endpoint: "
                + getAllTransactions(endpoint).size() + " transactions.");
        Reporter.info("Deleting all transactions from the endpoint...");
        Assert.assertTrue(deleteAllTransactions(endpoint),
                "All transaction on the endpoint were not deleted");
        Reporter.info("Amount of transactions on the endpoint: "
                + getAllTransactions(endpoint).size() + " transactions.");
        Reporter.info("The endpoint is empty.");
    }
}
