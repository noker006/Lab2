package utility;

import model.TextTokenType;
import model.Token;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTokenizer implements Enumeration<Token> {

    private final String content;
    private final Matcher matcher;
    private final TextTokenType[] textTokenTypes = TextTokenType.values();
    private int currentPosition = 0;

    RegexTokenizer(String content) {
        this.content = content;

        List<String> regexList = new ArrayList<>();
        for (int i = 0; i < textTokenTypes.length; i++) {
            String regex = textTokenTypes[i].getRegex();
            regexList.add("(?<g" + i + ">" + regex + ")");
        }
        String regex = String.join("|", regexList);

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(content);
        matcher.find();
    }

    @Override
    public boolean hasMoreElements() {
        return currentPosition < content.length();
    }

    @Override
    public Token nextElement() {                                                        //defines type of lexemes
        boolean found = currentPosition <= matcher.start() || matcher.find();

        int start = found ? matcher.start() : content.length();
        int end = found ? matcher.end() : content.length();

        if (found && currentPosition == start) {
            currentPosition = end;
            for (int i = 0; i < textTokenTypes.length; i++) {
                String si = "g" + i;
                if (matcher.start(si) == start && matcher.end(si) == end) {
                    return createToken(content, textTokenTypes[i], start, end);
                }
            }
        }
        throw new IllegalStateException("Не удается определить лексему в позиции " + currentPosition);
    }

    private Token createToken(String content, TextTokenType tokenType, int start, int end) {
        return new Token(content.substring(start, end), tokenType, start);
    }
}