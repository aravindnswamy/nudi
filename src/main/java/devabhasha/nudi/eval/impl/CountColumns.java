package devabhasha.nudi.eval.impl;

import devabhasha.nudi.eval.Evaluate;
import devabhasha.nudi.utils.Output;
import io.vavr.collection.List;
import io.vavr.collection.Traversable;

public class CountColumns implements Evaluate {
    @Override
    public List<List<String>> evaluate(List<List<String>> data) {
        Output.out(data.map(Traversable::size).max().getOrElse(0));
        return List.empty();
    }
}
