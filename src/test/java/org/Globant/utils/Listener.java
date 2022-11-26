package org.Globant.utils;

import org.Globant.reporting.Reporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Represents the Listener which is used to show messages to the user based on
 * test success or failure.
 *
 * @author juancamilo.Gonzalez
 * @version 1.0
 */
public class Listener implements ITestListener {

    /**
     * Shows a text to the user when a test is successful.
     * @param result The result of a test.
     * @return Message showing the result of the test and the text [PASSED].
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.info("Test: " + result.getName() + " [PASSED]");}

    /**
     * Shows a text to the user when a test is unsuccessful.
     * @param result The result of a test.
     * @return Message showing the result of the test and the text [FAILED].
     */
    @Override
    public void onTestFailure(ITestResult result){
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }
}
