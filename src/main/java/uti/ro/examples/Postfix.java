package uti.ro.examples;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import uti.ro.examples.gen.postfix.postfixLexer;
import uti.ro.examples.gen.postfix.postfixParser;


class Postfix {

    private int result;
    private PostfixStringToResult converter;

    {
        converter = new PostfixStringToResult();
    }


    Postfix(String expression){
        ParseTree tree = tree(expression);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(converter, tree);
        result = converter.getResult();
    }

    private postfixLexer lexer(String expression){
        CharStream input = CharStreams.fromString(expression);
        return new postfixLexer(input);
    }

    private postfixParser parser(postfixLexer lexer){
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new postfixParser(tokens);
    }

    private ParseTree tree(String expression){
        postfixLexer lexer = lexer(expression);
        postfixParser parser = parser(lexer);
        return parser.stat();
    }

    int result(){
        return result;
    }
}
