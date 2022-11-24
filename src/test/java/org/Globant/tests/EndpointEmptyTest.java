package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class EndpointEmptyTest extends BaseTest {

    @Parameters({"endpoint"})
    @Test
    public void verifyEndpointIsEmpty(String endpoint) {
        Reporter.info("Checking endpoint:" );
        Reporter.info("Amount of transactions on the endpoint: " + getAllTransactions(endpoint).size());
        if (deleteAllTransactions(endpoint) == true) {
            Reporter.info("All transactions were deleted");
        } else {
            Reporter.info("Not all transactions were deleted");
        }
    }
}
