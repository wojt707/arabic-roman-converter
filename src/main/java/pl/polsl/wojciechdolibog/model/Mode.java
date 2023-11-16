package pl.polsl.wojciechdolibog.model;

/**
 * The Mode enum represents the operating mode of the ArabicRomanConverter application.
 * It defines two modes: ARABIC and ROMAN, and an additional mode NONE for cases when no mode is specified.
 * Each mode has a corresponding value, which is a command-line argument used to select the mode.
 *
 * @author WDolibog
 * @version 1.0
 */
public enum Mode {

    /**
     * Mode representing the conversion from Arabic to Roman numerals.
     */
    ARABIC("--arabic"),

    /**
     * Mode representing the conversion from Roman to Arabic numerals.
     */
    ROMAN("--roman"),

    /**
     * Mode representing no specific conversion mode.
     */
    NONE("NONE");

    /**
     * The command-line argument value associated with each mode.
     */
    private final String value;

    /**
     * Constructs a Mode with the specified command-line argument value.
     *
     * @param value The command-line argument value.
     */
    Mode(String value) {
        this.value = value;
    }

    /**
     * Gets the command-line argument value associated with the mode.
     *
     * @return The command-line argument value.
     */
    public String getValue() {
        return value;
    }

}
