package utility;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import model.Sentence;
import model.Text;
import model.Token;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utility.file.FileReader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
public class TextParser {
    private static final Logger logger = LogManager.getLogger();

    private static final String SENTENCE_PATTERN = "[;.!?]\\s*";

    public static Text getText() {
        String content = FileReader.readFileAsLine("src/main/resources/file.txt");
        List<Sentence> sentences = splitSentencesByToken(splitTextBySentences(content));
        Text text = new Text(sentences);
        logger.info("text obj "+text);
        return text;
    }

    public static Text getText(String content) {
        List<Sentence> sentences = splitSentencesByToken(splitTextBySentences(content));
        Text text = new Text(sentences);
        logger.info("text obj"+text);
        return text;
    }

    private static List<Sentence> splitTextBySentences(String content) {
        return Stream.of(content.split(SENTENCE_PATTERN))
                .map(Sentence::new)
                .collect(Collectors.toList());
    }

    private static List<Sentence> splitSentencesByToken(List<Sentence> sentences) {
        sentences.forEach(sentence -> {
            RegexTokenizer tokenizer = new RegexTokenizer(sentence.getSentence());
            while (tokenizer.hasMoreElements()) {
                Token token = tokenizer.nextElement();
                switch (token.getType()) {
                    case WORD:
                        sentence.getWords().add(token.getText());
                        break;
                    case PUNCTUATIONS:
                        sentence.getPunctuations().add(token.getText());
                        break;
                    case CHARACTERS:
                        sentence.getCharacters().add(token.getText());
                    case NUMBER:
                    case REAL_NUMBER:
                        sentence.getNumbers().add(token.getText());
                    default:
                        break;
                }
            }
        });
        return sentences;
    }
}
