package model;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private List<Sentence> sentences = new ArrayList<>();

    public Text() {}

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }


}
