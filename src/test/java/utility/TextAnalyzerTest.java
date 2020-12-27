package utility;

import junit.framework.TestCase;
import model.Text;
import org.junit.Test;

import java.io.Console;
import java.util.List;

public class TextAnalyzerTest extends TestCase {
    @Test
    public void testGetUniqueWordInSentence() {
        Text text = TextParser.getText("ddfdfd hjhmil milk. ghghgj lk jil.");
        List<String> words = TextAnalyzer.getUniqueWordInSentence(text);
        System.out.println(words);
        assertTrue("List  doesn't have unique words", words.contains("milk"));
    }
}