package pl.polsl.wojciechdolibog.model;

import java.util.List;

public class Converter {

    private static final String INVALID_ROMAN_NUMERAL_LENGTH = "Roman Numeral cannot be of length 0";
    private static final String INVALID_ARABIC_NUMERAL_SMALL = "Arabic Numeral must be larger than 0";
    private static final String INVALID_ARABIC_NUMERAL_LARGE = "Arabic Numeral must be smaller than 5000";
    private static final String INVALID_ROMAN_NUMERAL = "Roman Numeral is incorrect. It cannot be converted to an Arabic Numeral";

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

    public String convertArabicToRoman(int arabic) {
        if (arabic < 1) {
            throw new IllegalArgumentException(INVALID_ARABIC_NUMERAL_SMALL + " (" + arabic + ")");
        } else if (arabic > 4999) {
            throw new IllegalArgumentException(INVALID_ARABIC_NUMERAL_LARGE + " (" + arabic + ")");
        }

        String roman = "";
        List<RomanNumeral> reverseRomanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while (arabic > 0 && i < reverseRomanNumerals.size()) {
            RomanNumeral symbol = reverseRomanNumerals.get(i);
            if (symbol.getValue() <= arabic) {
                roman += symbol.name();
                arabic -= symbol.getValue();
            } else {
                i++;
            }
        }
        return roman;
    }
}
