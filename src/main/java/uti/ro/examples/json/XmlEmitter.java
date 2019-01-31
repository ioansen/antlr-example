package uti.ro.examples.json;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import uti.ro.examples.json.gen.JsonBaseListener;
import uti.ro.examples.json.gen.JsonParser;

import static com.sun.javafx.util.Utils.stripQuotes;

public class XmlEmitter extends JsonBaseListener {

    private ParseTreeProperty<String> xml = new ParseTreeProperty<>();

    public String getXml(ParseTree ctx) {
        return xml.get(ctx);
    }

    public void setXml(ParseTree ctx, String string){
        xml.put(ctx, string);
    }

    @Override
    public void exitAtom(JsonParser.AtomContext ctx) {
        setXml(ctx,ctx.getText());
    }

    @Override
    public void exitString(JsonParser.StringContext ctx) {
        setXml(ctx, stripQuotes(ctx.getText()));
    }

    @Override
    public void exitObjectValue(JsonParser.ObjectValueContext ctx) {
        setXml(ctx, getXml(ctx.object()));
    }

    @Override
    public void exitArrayValue(JsonParser.ArrayValueContext ctx) {
        setXml(ctx, getXml(ctx.array()));
    }

    @Override
    public void exitPair(JsonParser.PairContext ctx) {
        String tag = stripQuotes(ctx.STRING().getText());
        JsonParser.ValueContext vctx = ctx.value();
        String x = String.format("<%s>%s</%s>\n", tag, getXml(vctx), tag);
        setXml(ctx, x);
    }

    @Override
    public void exitAnObject(JsonParser.AnObjectContext ctx) {
        StringBuilder buf = new StringBuilder();
        buf.append("\n");
        for (JsonParser.PairContext pctx : ctx.pair()) {
            buf.append(getXml(pctx));
        }
        setXml(ctx, buf.toString());
    }

    @Override
    public void exitEmptyObject(JsonParser.EmptyObjectContext ctx) {
        setXml(ctx, "");
    }

    @Override
    public void exitAnArray(JsonParser.AnArrayContext ctx) {
        StringBuilder buf = new StringBuilder();
        buf.append("\n");
        for (JsonParser.ValueContext vctx : ctx.value()) {
            buf.append("<element>"); // conjure up element for valid XML
            buf.append(getXml(vctx));
            buf.append("</element>");
            buf.append("\n");
        }
        setXml(ctx, buf.toString());
    }

    @Override
    public void exitEmptyArray(JsonParser.EmptyArrayContext ctx) {
        setXml(ctx, "");
    }

    @Override
    public void exitJson(JsonParser.JsonContext ctx) {
        setXml(ctx, getXml(ctx.getChild(0)));
    }
}
