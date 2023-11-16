package pl.polsl.wojciechdolibog.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author WDolibog
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

    private final int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumeral> getSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(RomanNumeral::getValue))
                .collect(Collectors.toList());
    }

    public static List<RomanNumeral> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(RomanNumeral::getValue).reversed())
                .collect(Collectors.toList());
    }
}
