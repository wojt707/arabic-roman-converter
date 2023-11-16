package pl.polsl.wojciechdolibog.model;

import java.util.List;

/**
 * The Converter class provides methods for converting between Arabic and Roman numerals.
 * It contains methods for converting Roman numerals to Arabic integers and vice versa.
 * The class also includes constants for error messages related to input validation.
 *
 * @author WDolibog
 * @version 1.0
 */
public class Converter {

    /**
     * Error message for an invalid Roman numeral length.
     */
    private static final String INVALID_ROMAN_NUMERAL_LENGTH = "Roman Numeral cannot be of length 0";

    /**
     * Error message for a small Arabic numeral during conversion to Roman numeral.
     */
    private static final String INVALID_ARABIC_NUMERAL_SMALL = "Arabic Numeral must be larger than 0";

    /**
     * Error message for a large Arabic numeral during conversion to Roman numeral.
     */
    private static final String INVALID_ARABIC_NUMERAL_LARGE = "Arabic Numeral must be smaller than 5000";

    /**
     * Error message for an incorrect Roman numeral during conversion to Arabic numeral.
     */
    private static final String INVALID_ROMAN_NUMERAL = "Roman Numeral is incorrect. It cannot be converted to an Arabic Numeral";

    /**
     * Converts a Roman numeral to an Arabic integer.
     *
     * @param roman The Roman numeral to be converted.
     * @return The equivalent Arabic integer.
     * @throws IllegalArgumentException If the input Roman numeral is invalid.
     */
    public int convertRomanToArabic(String roman) {
        if (roman.length() < 1) {
            throw new IllegalArgumentException(INVALID_ROMAN_NUMERAL_LENGTH);
        }
        String romanNumeral = roman.toUpperCase();
        int arabic = 0;
        List<RomanNumeral> reverseRomanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && i < reverseRomanNumerals.size()) {
            RomanNumeral symbol = reverseRomanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                arabic += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(INVALID_ROMAN_NUMERAL + " (" + roman.toUpperCase() + ")");
        }

        return arabic;
    }

    /**
     * Converts an Arabic integer to a Roman numeral.
     *
     * @param arabic The Arabic integer to be converted.
     * @return The equivalent Roman numeral.
     * @throws IllegalArgumentException If the input Arabic integer is out of the valid range.
     */
    public String convertArabicToRoman(int arabic) {
        if (arabic < 1) {
            throw new IllegalArgumentException(INVALID_ARABIC_NUMERAL_SMALL + " (" + arabic + ")");
        } else if (arabic > 4999) {
            throw new IllegalArgumentException(INVALID_ARABIC_NUMERAL_LARGE + " (" + arabic + ")");
        }

        StringBuilder roman = new StringBuilder();
        List<RomanNumeral> reverseRomanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while (arabic > 0 && i < reverseRomanNumerals.size()) {
            RomanNumeral symbol = reverseRomanNumerals.get(i);
            if (symbol.getValue() <= arabic) {
                roman.append(symbol.name());
                arabic -= symbol.getValue();
            } else {
                i++;
            }
        }
        return roman.toString();
    }
}
