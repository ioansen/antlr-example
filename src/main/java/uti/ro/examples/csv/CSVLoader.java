package uti.ro.examples.csv;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import uti.ro.examples.csv.gen.CSVLexer;
import uti.ro.examples.csv.gen.CSVParser;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class CSVLoader {

    private CSVMapsBuilder maps;

    public CSVLoader(File file) throws Exception{
        maps = new CSVMapsBuilder();
        ParseTree tree = buildTreeFromFile(file);
        walkTree(tree);
    }

    private ParseTree buildTreeFromFile(File file) throws Exception{
        CSVLexer lexer = lexer(file);
        CSVParser parser = parser(lexer);
        return parser.file();
    }

    private CSVLexer lexer(File file) throws Exception{
        CharStream input = CharStreams.fromStream(new FileInputStream(file));
        return new CSVLexer(input);
    }

    private CSVParser parser(CSVLexer lexer){
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new CSVParser(tokens);
    }

    private void walkTree(ParseTree tree){
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(maps, tree);
    }

    public List<Map<String, String>> getMaps() {
        return maps.rows;
    }
}
