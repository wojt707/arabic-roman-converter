package pl.polsl.wojciechdolibog.controller;

import pl.polsl.wojciechdolibog.model.Mode;

/**
 *
 * @author WDolibog
 */
public class Main {

    public static void main(String[] args) {
        ArabicRomanConverterController controller = new ArabicRomanConverterController();

        if (args.length == 0) {
            controller.displayError("No mode provided");
            controller.displayHelp();
            return;
        }
        if (args[0].equals(Mode.ARABIC.getValue())) {
            controller.convertArabicToRoman();
        } else if (args[0].equals(Mode.ROMAN.getValue())) {
            controller.convertRomanToArabic();
        } else {
            controller.displayError("Unknown mode");
            controller.displayHelp();
        }
    }
}
