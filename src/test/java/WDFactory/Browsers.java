package WDFactory;

public enum Browsers {
    CHROME("chrome"),
    EDGE("edge");

    private final String value;


    Browsers(String value) {
        this.value = value;
    }

    public static Browsers fetchValue(String constant) {
        for (Browsers command : Browsers.values()) {
            if (command.value.equals(constant)) {
                return command;
            }
        }
        return null;
    }
}
