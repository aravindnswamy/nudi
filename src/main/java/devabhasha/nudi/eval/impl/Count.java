package devabhasha.nudi.eval.impl;

import devabhasha.nudi.eval.Evaluate;
import devabhasha.nudi.utils.Output;
import io.vavr.collection.List;

public class Count implements Evaluate {

    @Override
    public List<List<String>> evaluate(List<List<String>> data) {
        Output.out(data.size());
        return List.empty();
    }
}
