package org.Globant.tests;

import io.restassured.response.Response;
import org.Globant.reporting.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ObtainTransactionsTest extends BaseTest{

    @Parameters({"endpoint"})
    @Test
    public void ObtainTransactionsTest(String endpoint) {
        Reporter.info("Checking :" );
        Reporter.info("Amount of transactions on the endpoint: " + getAllTransactions(endpoint).size());
    }


}
