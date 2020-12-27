package model;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private String sentence;
    private List<String> words = new ArrayList<>();
    private List<String> punctuations = new ArrayList<>();
    private List<String> characters = new ArrayList<>();
    private List<String> numbers = new ArrayList<>();

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<String> getPunctuations() {
        return punctuations;
    }

    public void setPunctuations(List<String> punctuations) {
        this.punctuations = punctuations;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence='" + sentence + '\'' +
                '}';
    }
}
