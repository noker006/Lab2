import model.Text;
import utility.TextParser;

public class Main {
    public static void main(String[] args) {
        Text text = TextParser.getText();
        int a = 0;

        text.getSentences().forEach(sentence -> System.out.println(sentence.getSentence()));
    }
}

