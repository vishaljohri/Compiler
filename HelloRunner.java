import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class HelloRunner {

	public static void main(String[] args) throws IOException {

		ANTLRFileStream input = new ANTLRFileStream("C:\\Users\\VISHAL\\scala_workspace\\TestAntlr\\target\\generated-sources\\antlr4\\test.vsc");

		HelloLexer lexer = new HelloLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HelloParser parser = new HelloParser(tokens);
		ParseTree tree = parser.vsc(); // begin parsing at rule 'r'
		EvaluateVisitor visitor = new EvaluateVisitor();
        visitor.visit(tree);
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree

	}

}
