package devabhasha.nudi.eval.impl;

import devabhasha.nudi.eval.Evaluate;
import io.vavr.collection.List;

public class FindWords implements Evaluate {

    private final String wordToFind;

    public FindWords(String wordToFind) {
        this.wordToFind = wordToFind;
    }

    @Override
    public List<List<String>> evaluate(List<List<String>> data) {
        return data.filter(this::containsAny);
    }

    private boolean containsAny(List<String> data) {
        for (String sourceStr : data) {
            if (sourceStr.contains(wordToFind)) {
                return true;
            }
        }
        return false;
    }
}
