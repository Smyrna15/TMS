package enums;


public enum LINES {
    ORANGE("orange_line"),
    VODAFONE("vf_line"),
    ETISALAT("etsalat_line"),
    LANDLINE("landline");

    private final String value;

    LINES(final String newValue) {
        value = newValue;
    }

    public String getValue() {
        return value;
    }
}
