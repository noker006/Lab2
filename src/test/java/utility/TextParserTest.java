package utility;


import model.Sentence;
import model.Text;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
 public class TextParserTest {

    @Test
    public void getSentences() {
        List<Sentence>sentences = new ArrayList<>();
        sentences.add(new Sentence("hello,world"));
        sentences.add(new Sentence("cfg bhgcg gvhg"));
        Text text = TextParser.getText("hello,world.cfg bhgcg gvhg.");
        Assert.assertEquals(sentences.toString(),text.getSentences().toString());
    }
}