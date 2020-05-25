package devabhasha.nudi.eval;

import io.vavr.collection.List;

public interface Evaluate {

    List<List<String>> evaluate(List<List<String>> data);
}
