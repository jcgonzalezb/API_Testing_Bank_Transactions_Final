package org.Globant.tests;

import org.Globant.reporting.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class EndpointEmptyTest extends BaseTest {

    @Parameters({"endpoint"})
    @Test
    public void verifyEndpointIsEmpty(String endpoint) {
        Reporter.info("Complete list" + getAllTransactions(endpoint));
    }
}
