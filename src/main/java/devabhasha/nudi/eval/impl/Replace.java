package devabhasha.nudi.eval.impl;

import devabhasha.nudi.eval.Evaluate;
import io.vavr.collection.List;

public class Replace implements Evaluate {

    private final String replaced;
    private final String replacement;

    public Replace(String replaced, String replacement) {
        this.replaced = replaced;
        this.replacement = replacement;
    }

    @Override
    public List<List<String>> evaluate(List<List<String>> data) {
        return data.map(this::replaceAll);
    }

    private List<String> replaceAll(List<String> line) {
        return line.map(word -> word.replaceAll(replaced, replacement));
    }
}
