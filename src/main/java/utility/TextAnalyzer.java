package utility;

import model.Sentence;
import model.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextAnalyzer {

    public static List<String> getUniqueWordInSentence(Text text) {
        List<Sentence> sentences = text.getSentences();
        Sentence firstSentence = sentences.get(0);
        //skip first sentence and get all words from text
        List<String> words = getAllWordsFromText(sentences.stream().skip(1).collect(Collectors.toList()));
        //filter first sentence by unique words
        return firstSentence.getWords().stream()
                .filter(word -> !words.contains(word)).collect(Collectors.toList());
    }

    private static List<String> getAllWordsFromText(List<Sentence> sentences) {
        List<String> allWords = new ArrayList<>();
        sentences.forEach(words -> allWords.addAll(words.getWords()));
        return allWords;
    }
}
