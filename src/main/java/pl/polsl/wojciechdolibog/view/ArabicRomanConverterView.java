package pl.polsl.wojciechdolibog.view;

import java.util.Scanner;

/**
 *
 * @author WDolibog
 */
public class ArabicRomanConverterView {

    private final Scanner scanner;

    public ArabicRomanConverterView() {
        this.scanner = new Scanner(System.in);
    }
  
    public int getArabicInput() {
        System.out.println("Enter an Arabic number: ");
        return scanner.nextInt();
    }

    public String getRomanInput() {
        System.out.println("Enter a Roman number: ");
        return scanner.next();
    }

    public void displayResult(String result) {
        System.out.println("Result: " + result);

    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

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
