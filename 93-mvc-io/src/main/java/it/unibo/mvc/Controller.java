package it.unibo.mvc;

import java.util.List;

/**
 * Models a simple controller to print string on the standard output
 */
public interface Controller {

    /**
     * Sets the next string to print
     * 
     * @param str the next string to be printed
     */
    void setNextString(String str);

    /**
     * Gets the next string that will be printed
     * 
     * @return the next string to print
     */
    String getNextString();

    /**
     * Gets the strings that have been printed until
     * the invocation of this method
     * 
     * @return a list view of the printed strings
     */
    List<String> getPrintHistory();

    /**
     * Prints the current string
     * 
     * @throws IllegalStateException if the current string is unset
     */
    void printString() throws IllegalStateException;
}
