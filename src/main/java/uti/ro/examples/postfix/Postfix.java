package uti.ro.examples.postfix;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import uti.ro.examples.gen.postfix.PostfixLexer;
import uti.ro.examples.gen.postfix.PostfixParser;


public class Postfix {

    private int result;

    public Postfix(String expression){
        this.result = buildResultFromExpression(expression);
    }

    private int buildResultFromExpression(String expression){
        ParseTree tree = buildTreeFromExpression(expression);
        return buildResultFromTree(tree);
    }

    private ParseTree buildTreeFromExpression(String expression){
        PostfixLexer lexer = lexer(expression);
        PostfixParser parser = parser(lexer);
        return parser.stat();
    }

    private PostfixLexer lexer(String expression){
        CharStream input = CharStreams.fromString(expression);
        return new PostfixLexer(input);
    }

    private PostfixParser parser(PostfixLexer lexer){
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new PostfixParser(tokens);
    }

    private int buildResultFromTree(ParseTree tree){
        ParseTreeWalker walker = new ParseTreeWalker();
        PostfixResultBuilder resultBuilder = new PostfixResultBuilder();
        walker.walk(resultBuilder, tree);
        return resultBuilder.getResult();
    }

    public int result(){
        return result;
    }
}
