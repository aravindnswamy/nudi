package devabhasha.nudi.eval.impl;

import devabhasha.nudi.NudiError;
import devabhasha.nudi.eval.Evaluate;
import io.vavr.collection.List;

public class SplitBy implements Evaluate {

    private final String splitWord;

    public SplitBy(String splitWord) {
        this.splitWord = splitWord;
    }

    @Override
    public List<List<String>> evaluate(List<List<String>> data) {
        return data.map(this::splitByVar);
    }

    private List<String> splitByVar(List<String> list) {
        // TODO : maybe allow more
        if (list.size() != 1) {
            throw new NudiError("How to split already split words?");
        }
        return List.of(list.get(0).split(splitWord));
    }
}
