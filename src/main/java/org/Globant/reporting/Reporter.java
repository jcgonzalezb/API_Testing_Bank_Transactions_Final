package org.Globant.reporting;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the reporter which is used to show messages to the user.
 *
 * @author juancamilo.Gonzalez
 * @version 1.0
 */
public class Reporter {

    /**
     * Constructor method for the Reporter class.
     */
    public Reporter() {}

    /**
     * Method used to find or create a logger.
     */
    private static Logger getLogger() { return LoggerFactory.getLogger(Reporter.class);}

    /**
     * Method used to show a text to the user.
     * @param text The text used to show a message to the user.
     */
    public static void info(String text) {
        getLogger().info(text);
    }

    /**
     * Method used to show an error message to the user.
     * @param text The text used to show an error message to the user.
     * @return false when during the program execution an error is found.
     */
    public static boolean error(String text) {
        getLogger().error(text);
        return false;
    }
}
