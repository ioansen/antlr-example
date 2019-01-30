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
    private PostfixResultBuilder converter;

    {
        converter = new PostfixResultBuilder();
    }


    public Postfix(String expression){
        ParseTree tree = tree(expression);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(converter, tree);
        result = converter.getResult();
    }

    private PostfixLexer lexer(String expression){
        CharStream input = CharStreams.fromString(expression);
        return new PostfixLexer(input);
    }

    private PostfixParser parser(PostfixLexer lexer){
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new PostfixParser(tokens);
    }

    private ParseTree tree(String expression){
        PostfixLexer lexer = lexer(expression);
        PostfixParser parser = parser(lexer);
        return parser.expr();
    }

    public int result(){
        return result;
    }
}
