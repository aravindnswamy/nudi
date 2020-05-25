package devabhasha.nudi.pipe;

import devabhasha.nudi.eval.Evaluate;

public class EvaluationPipeBuilder {

    private EvaluationPipe evalPipe;

    public EvaluationPipeBuilder(String fileName) {
        evalPipe = new EvaluationPipe(fileName);
    }

    public EvaluationPipeBuilder after(Evaluate eval) {
        evalPipe.addEvalStep(eval);
        return this;
    }

    public EvaluationPipe build() {
        return evalPipe;
    }
}