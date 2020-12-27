package model;

public enum TextTokenType {

    WORD("[A-Za-z][A-Za-z0-9']*"),
    REAL_NUMBER("[0-9]+\\.[0-9]*"),
    NUMBER("[0-9]+"),
    PUNCTUATIONS("[.,:\\-\\s+]"),
    CHARACTERS("\\-\\-[^\\n\\r]*\\'");

    private final String regex;

    TextTokenType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
