package pl.polsl.wojciechdolibog.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The RomanNumeral enum represents the basic Roman numerals and provides utility methods for sorting them.
 * Each Roman numeral has a corresponding integer value.
 *
 * @author WDolibog
 * @version 1.0
 */
public enum RomanNumeral {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);

    /**
     * The integer value associated with each Roman numeral.
     */
    private final int value;

    /**
     * Constructs a RomanNumeral with the specified integer value.
     *
     * @param value The integer value of the Roman numeral.
     */
    RomanNumeral(int value) {
        this.value = value;
    }

    /**
     * Gets the integer value associated with the Roman numeral.
     *
     * @return The integer value of the Roman numeral.
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets a list of Roman numerals sorted in ascending order based on their integer values.
     *
     * @return A list of Roman numerals in ascending order.
     */
    public static List<RomanNumeral> getSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(RomanNumeral::getValue))
                .collect(Collectors.toList());
    }

    /**
     * Gets a list of Roman numerals sorted in descending order based on their integer values.
     *
     * @return A list of Roman numerals in descending order.
     */
    public static List<RomanNumeral> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(RomanNumeral::getValue).reversed())
                .collect(Collectors.toList());
    }
}
