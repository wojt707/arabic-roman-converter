package pl.polsl.wojciechdolibog.model;

/**
 *
 * @author WDolibog
 */
public enum Mode {

    ARABIC("--arabic"),
    ROMAN("--roman");

    private final String value;

    Mode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
