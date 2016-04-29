import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class TinyPyCCompiler {

	public static void main(String[] args) throws IOException {
		ANTLRFileStream input = new ANTLRFileStream("C:\\Users\\VISHAL\\scala_workspace\\TestAntlr\\target\\generated-sources\\antlr4\\Test.hpc");

		TinyPyCLexer lexer = new TinyPyCLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		TinyPyCParser parser = new TinyPyCParser(tokens);
		ParseTree tree = parser.vsc(); // begin parsing at rule 'r'
		EvalTree visitor = new EvalTree();
        visitor.visit(tree);
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree

	}

}
