package devabhasha.nudi.listener;

import devabhasha.nudi.NudiBaseListener;
import devabhasha.nudi.NudiParser;
import devabhasha.nudi.eval.impl.Count;
import devabhasha.nudi.eval.impl.CountColumns;
import devabhasha.nudi.eval.impl.FetchIpAddress;
import devabhasha.nudi.eval.impl.FetchMobileNumber;
import devabhasha.nudi.eval.impl.FindWords;
import devabhasha.nudi.eval.impl.Match;
import devabhasha.nudi.eval.impl.Replace;
import devabhasha.nudi.eval.impl.SplitBy;
import devabhasha.nudi.eval.impl.TakeColumns;
import devabhasha.nudi.pipe.EvaluationPipeBuilder;
import io.vavr.collection.List;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.TerminalNode;

public class NudiCommandListener extends NudiBaseListener {

    private EvaluationPipeBuilder evalPipeBuilder;

    @Override
    public void enterCommand(NudiParser.CommandContext ctx) {
        evalPipeBuilder = new EvaluationPipeBuilder(ctx.WORD().getText());
    }

    @Override
    public void enterCount(NudiParser.CountContext ctx) {
        evalPipeBuilder.after(new Count());
    }

    @Override
    public void enterCountColumns(NudiParser.CountColumnsContext ctx) {
        evalPipeBuilder.after(new CountColumns());
    }

    @Override
    public void enterSplitBy(NudiParser.SplitByContext ctx) {
        evalPipeBuilder.after(new SplitBy(ctx.WORD().getText()));
    }

    @Override
    public void enterReplace(NudiParser.ReplaceContext ctx) {
        evalPipeBuilder.after(new Replace(ctx.WORD(0).getText(), ctx.WORD(1).getText()));
    }

    @Override
    public void enterTakeColumns(NudiParser.TakeColumnsContext ctx) {
        evalPipeBuilder.after(new TakeColumns(List.ofAll(ctx.WORD()).map(TerminalNode::getText)));
    }

    @Override
    public void enterFindWords(NudiParser.FindWordsContext ctx) {
        evalPipeBuilder.after(new FindWords(getFullText(ctx).replace("find", "").trim()));
    }

    @Override
    public void enterMatch(NudiParser.MatchContext ctx) {
        evalPipeBuilder.after(new Match(getFullText(ctx).replace("match", "").trim()));
    }

    @Override
    public void enterFetchIp(NudiParser.FetchIpContext ctx) {
        //evalPipeBuilder.after(new FetchIpAddress(getFullText(ctx).replace("fetchIpAddress", "").trim()));
        evalPipeBuilder.after(new FetchIpAddress());
    }

    @Override
    public void enterFetchMobileNumber(NudiParser.FetchMobileNumberContext ctx) {
        evalPipeBuilder.after(new FetchMobileNumber());
    }

    public void evaluate() {
        evalPipeBuilder.build().eval();
    }

    private String getFullText(ParserRuleContext context) {
        if (context.start == null || context.stop == null || context.start.getStartIndex() < 0 || context.stop.getStopIndex() < 0) {
            return context.getText();
        }
        return context.start.getInputStream().getText(Interval.of(context.start.getStartIndex(), context.stop.getStopIndex()));
    }
}
