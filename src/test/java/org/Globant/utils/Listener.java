package org.Globant.utils;

import org.Globant.reporting.Reporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Represents the Listener which is used to show messages to the user based on
 * test success or failure.
 *
 * @author juancamilo.gonzalez
 * @version 1.0
 */
public class Listener implements ITestListener {

    /**
     * Shows the name of the test and the text [PASSED] when a test is successful.
     * @param result The result of a test.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.info("Test: " + result.getName() + " [PASSED]");
    }

    /**
     * Shows the name of the test and the text [FAILED] when a test is unsuccessful.
     * @param result The result of a test.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }
}
