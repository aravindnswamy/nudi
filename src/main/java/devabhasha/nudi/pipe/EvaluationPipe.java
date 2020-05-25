package devabhasha.nudi.pipe;

import devabhasha.nudi.eval.Evaluate;
import devabhasha.nudi.utils.Input;
import devabhasha.nudi.utils.Output;
import io.vavr.collection.List;
import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationPipe {

    private final Deque<Evaluate> deque = new ArrayDeque<>();
    private final String fileName;

    EvaluationPipe(String fileName) {
        this.fileName = fileName;
    }

    void addEvalStep(Evaluate eval) {
        deque.add(eval);
    }

    private Evaluate nextStep() {
        return deque.removeLast();
    }

    public void eval() {

        if (deque.isEmpty()) {
            return;
        }

        List<List<String>> evaluated = Input.readFile(fileName);

        while (!deque.isEmpty() && !evaluated.isEmpty()) {
            evaluated = nextStep().evaluate(evaluated);
        }

        Output.out(evaluated);
    }
}
