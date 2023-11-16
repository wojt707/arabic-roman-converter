package pl.polsl.wojciechdolibog.controller;

import pl.polsl.wojciechdolibog.model.Mode;

/**
 * The Main class is the entry point for the ArabicRomanConverter application.
 * It initializes the ArabicRomanConverterController, selects the conversion mode,
 * and triggers the corresponding conversion process.
 *
 * @author WDolibog
 * @version 1.0
 */
public class Main {

    /**
     * The main method of the application. It initializes the controller,
     * selects the conversion mode based on command-line arguments or user input,
     * and triggers the corresponding conversion process.
     *
     * @param args Command-line arguments provided during program execution.
     */
    public static void main(String[] args) {
        ArabicRomanConverterController controller = new ArabicRomanConverterController();
        Mode mode = controller.selectMode(args);

        if (mode.equals(Mode.ARABIC)) {
            controller.convertArabicToRoman();
        } else if (mode.equals(Mode.ROMAN)) {
            controller.convertRomanToArabic();
        }
    }
}
