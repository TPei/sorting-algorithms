package html.dom;

public enum DOM {
    TABLE("table"),
    TD("td"),
    TH("th"),
    TR("tr"),
    THEAD("thead"),
    TBODY("tbody");

    private DOM(String value) {
        this.value = value;
    }

    private final String value;

    public String value() {
        return value;
    }
}