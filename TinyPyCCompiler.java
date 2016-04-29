import java.io.IOException;
import java.util.Arrays;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class TinyPyCCompiler {

	public static void main(String[] args) throws IOException {
		
		ANTLRFileStream input = new ANTLRFileStream(args[0]);

		TinyPyCLexer lexer = new TinyPyCLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		TinyPyCParser parser = new TinyPyCParser(tokens);
		ParseTree tree = parser.vsc(); // begin parsing at rule 'r'
		String inputFile[] = args[0].split("\\.");
		EvalTree visitor = new EvalTree(inputFile[0] + ".bpc");
        visitor.visit(tree);
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree

	}

}
