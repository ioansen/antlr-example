package uti.ro.examples.postfix;


import uti.ro.examples.gen.postfix.PostfixBaseListener;
import uti.ro.examples.gen.postfix.PostfixParser;

public class PostfixStringToResult extends PostfixBaseListener {

    private int result;

    @Override
    public void enterStat(PostfixParser.StatContext ctx) {
        result = Integer.parseInt(ctx.INT().toString());
    }

    @Override
    public void enterAdd(PostfixParser.AddContext ctx) {
        result += Integer.parseInt(ctx.INT().toString());
    }

    @Override
    public void enterSub(PostfixParser.SubContext ctx) {
        result -= Integer.parseInt(ctx.INT().toString());
    }

    @Override
    public void enterMul(PostfixParser.MulContext ctx) {
        result *= Integer.parseInt(ctx.INT().toString());
    }

    @Override
    public void enterDiv(PostfixParser.DivContext ctx) {
        result /= Integer.parseInt(ctx.INT().toString());
    }

    int getResult(){
        return result;
    }
}
