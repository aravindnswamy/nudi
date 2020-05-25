package devabhasha.nudi;

import devabhasha.nudi.listener.NudiCommandListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Application {
    public static void main(String[] args) {
        CharStream input = CharStreams.fromString(String.join(" ", args));
        NudiLexer lexer = new NudiLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NudiParser parser = new NudiParser(tokens);
        ParseTree tree = parser.command();

        ParseTreeWalker walker = new ParseTreeWalker();
        NudiCommandListener cmdListener = new NudiCommandListener();
        walker.walk(cmdListener, tree);
        cmdListener.evaluate();
    }
}
