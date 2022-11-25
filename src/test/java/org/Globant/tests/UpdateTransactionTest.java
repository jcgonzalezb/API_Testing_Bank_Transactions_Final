package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UpdateTransactionTest extends BaseTest{

    @Parameters({"endpoint"})
    @Test
    public void UpdateTransactionTest(String endpoint) {
        Reporter.info("Checking :" );
        Reporter.info("Amount of transactions on the endpoint: " + getAllTransactions(endpoint).size());
        if (createUpdateInformation(endpoint) == true) {
            Reporter.info("A transaction was Updated");
        } else {
            Reporter.info("Not all transactions were deleted");
        }
    }
}
