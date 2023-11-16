package pl.polsl.wojciechdolibog.controller;

import pl.polsl.wojciechdolibog.view.ArabicRomanConverterView;
import pl.polsl.wojciechdolibog.model.Converter;

/**
 *
 * @author WDolibog
 */
public class ArabicRomanConverterController {
    
    private final Converter converter;
    private final ArabicRomanConverterView arabicRomanConverterView;
    
    public ArabicRomanConverterController() {
        this.converter = new Converter();
        this.arabicRomanConverterView = new ArabicRomanConverterView();
    }
    
    public void convertArabicToRoman() {
        try {
            int arabicNumber = arabicRomanConverterView.getArabicInput();
            String romanResult = converter.convertArabicToRoman(arabicNumber);
            arabicRomanConverterView.displayResult(romanResult);
        } catch (IllegalArgumentException e) {
            arabicRomanConverterView.displayError(e.getMessage());
        }
    }
    
    public void convertRomanToArabic() {
        try {
            String romanNumber = arabicRomanConverterView.getRomanInput();
            int arabicResult = converter.convertRomanToArabic(romanNumber);
            arabicRomanConverterView.displayResult(String.valueOf(arabicResult));
        } catch (IllegalArgumentException e) {
            arabicRomanConverterView.displayError(e.getMessage());
        }
    }

    public void displayError(String errorMessage) {
        arabicRomanConverterView.displayError(errorMessage);
    }

    public void displayHelp() {
        arabicRomanConverterView.displayHelp();
    }
}
