package model;


public class Token {

    private final String text;
    private final TextTokenType type;
    private final int start;

    public Token(String text, TextTokenType type, int start) {
        this.text = text;
        this.type = type;
        this.start = start;
    }

    public String getText() {
        return text;
    }

    public TextTokenType getType() {
        return type;
    }


}