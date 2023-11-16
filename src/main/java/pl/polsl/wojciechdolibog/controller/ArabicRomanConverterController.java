package pl.polsl.wojciechdolibog.controller;

import pl.polsl.wojciechdolibog.model.Mode;
import pl.polsl.wojciechdolibog.view.ArabicRomanConverterView;
import pl.polsl.wojciechdolibog.model.Converter;

/**
 * The ArabicRomanConverterController class manages the interaction between the model (Converter),
 * view (ArabicRomanConverterView), and the user. It handles the conversion process based on user input
 * and mode selection.
 *
 * @author WDolibog
 * @version 1.0
 */
public class ArabicRomanConverterController {

    private final Converter converter;
    private final ArabicRomanConverterView arabicRomanConverterView;

    /**
     * Constructs an ArabicRomanConverterController object with a Converter and ArabicRomanConverterView.
     */
    public ArabicRomanConverterController() {
        this.converter = new Converter();
        this.arabicRomanConverterView = new ArabicRomanConverterView();
    }

    /**
     * Converts an Arabic numeral to a Roman numeral and displays the result.
     */
    public void convertArabicToRoman() {
        try {
            int arabicNumber = arabicRomanConverterView.getArabicInput();
            String romanResult = converter.convertArabicToRoman(arabicNumber);
            arabicRomanConverterView.displayResult(romanResult);
        } catch (IllegalArgumentException e) {
            arabicRomanConverterView.displayError(e.getMessage());
        }
    }

    /**
     * Converts a Roman numeral to an Arabic numeral and displays the result.
     */
    public void convertRomanToArabic() {
        try {
            String romanNumber = arabicRomanConverterView.getRomanInput();
            int arabicResult = converter.convertRomanToArabic(romanNumber);
            arabicRomanConverterView.displayResult(String.valueOf(arabicResult));
        } catch (IllegalArgumentException e) {
            arabicRomanConverterView.displayError(e.getMessage());
        }
    }

    /**
     * Selects the conversion mode based on command-line arguments or user input.
     *
     * @param args Command-line arguments.
     * @return The selected mode.
     */
    public Mode selectMode(String[] args) {
        Mode mode = Mode.NONE;
        if (args.length == 1) {
            if (args[0].equals(Mode.ARABIC.getValue())) {
                mode = Mode.ARABIC;
            } else if (args[0].equals(Mode.ROMAN.getValue())) {
                mode = Mode.ROMAN;
            }
        }
        while (mode.equals(Mode.NONE)) {
            arabicRomanConverterView.displayError("Unknown mode");
            arabicRomanConverterView.displayHelp();
            String m = arabicRomanConverterView.getMode();
            if (m.equals(Mode.ARABIC.getValue())) {
                mode = Mode.ARABIC;
            } else if (m.equals(Mode.ROMAN.getValue())) {
                mode = Mode.ROMAN;
            }
        }
        return mode;
    }

    /**
     * Gets the mode from the view.
     *
     * @return The selected mode.
     */
    public String getMode() {
        return arabicRomanConverterView.getMode();
    }

    /**
     * Displays an error message using the view.
     *
     * @param errorMessage The error message to be displayed.
     */
    public void displayError(String errorMessage) {
        arabicRomanConverterView.displayError(errorMessage);
    }

    /**
     * Displays the help message using the view.
     */
    public void displayHelp() {
        arabicRomanConverterView.displayHelp();
    }
}
