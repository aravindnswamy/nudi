package devabhasha.nudi.eval.impl;

import devabhasha.nudi.eval.Evaluate;
import io.vavr.collection.List;

public class Match implements Evaluate {

    private final String matchPattern;

    public Match(String matchPattern) {
        this.matchPattern = matchPattern;
    }

    @Override
    public List<List<String>> evaluate(List<List<String>> data) {
        return data.map(this::matches).filterNot(List::isEmpty);
    }

    private List<String> matches(List<String> data) {
        String regex = matchPattern.replace("WORD", "(.*)").concat("(.*)");
        return data.filter(word -> word.matches(regex)).map(this::takeOutWords);
    }

    private String takeOutWords(String word) {
        int start = 0;
        for (String commonWord : matchPattern.split("WORD")) {
            start = word.indexOf(commonWord);
            word = word.replaceFirst(commonWord, " ");
        }
        if (!matchPattern.endsWith("WORD")) {
            word = word.substring(0, start);
        }
        return word.trim();
    }
}
