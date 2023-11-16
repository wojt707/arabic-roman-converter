package pl.polsl.wojciechdolibog.view;

import java.util.Scanner;

/**
 * The ArabicRomanConverterView class handles input and output operations for the Arabic-Roman Converter application.
 * It provides methods for getting user input, displaying results, errors, and help information.
 *
 * @author WDolibog
 * @version 1.0
 */
public class ArabicRomanConverterView {

    /**
     * The scanner object to read input from the console.
     */
    private final Scanner scanner;

    /**
     * Constructs an ArabicRomanConverterView object with a Scanner for input.
     */
    public ArabicRomanConverterView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Gets an Arabic number input from the user.
     *
     * @return The user-entered Arabic number.
     */
    public int getArabicInput() {
        System.out.println("Enter an Arabic number: ");
        return scanner.nextInt();
    }

    /**
     * Gets a Roman number input from the user.
     *
     * @return The user-entered Roman number.
     */
    public String getRomanInput() {
        System.out.println("Enter a Roman number: ");
        return scanner.next();
    }

    /**
     * Gets a mode input from the user (either "--roman" or "--arabic").
     *
     * @return The user-entered mode.
     */
    public String getMode() {
        System.out.println("Enter --roman or --arabic");
        return scanner.next();
    }

    /**
     * Displays the result to the user.
     *
     * @param result The result to be displayed.
     */
    public void displayResult(String result) {
        System.out.println("Result: " + result);
    }

    /**
     * Displays an error message to the user.
     *
     * @param errorMessage The error message to be displayed.
     */
    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    /**
     * Displays help information to the user.
     */
    public void displayHelp() {
        System.out.println("""
        This is a help page for the application. The data when running the program from the command line
        (command line arguments) is read as follows:
        
        java ArabicRomanConverter.java mode
          
        where mode can be "--arabic" to convert arabic numeral to roman numeral
        or "--roman" to convert roman numeral to arabic numeral
          
        Examples of the commands:
        java ArabicRomanConverter.java --arabic
        java ArabicRomanConverter.java --roman
        """);
    }
}
