package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateTransactionsTest extends BaseTest {

    @Parameters({"endpoint"})
    @Test
    public void createTransactionsTest(String endpoint) {
        Reporter.info("Checking :" );
        Reporter.info("Amount of transactions on the list: " + getAllTransactions(endpoint).size());
        if (createAllTransactions(endpoint, 10)) {
            Reporter.info("All transactions were created");
        } else {
            Reporter.info("Not all transactions were created");
        }

    }
}


