package uti.ro.examples;


import uti.ro.examples.gen.postfix.postfixBaseListener;
import uti.ro.examples.gen.postfix.postfixParser;

public class PostfixStringToResult extends postfixBaseListener {

    private int result;

    @Override
    public void enterStat(postfixParser.StatContext ctx) {
        result = Integer.parseInt(ctx.INT().toString());
    }

    @Override
    public void enterAdd(postfixParser.AddContext ctx) {
        result += Integer.parseInt(ctx.INT().toString());
    }

    @Override
    public void enterSub(postfixParser.SubContext ctx) {
        result -= Integer.parseInt(ctx.INT().toString());
    }

    @Override
    public void enterMul(postfixParser.MulContext ctx) {
        result *= Integer.parseInt(ctx.INT().toString());
    }

    @Override
    public void enterDiv(postfixParser.DivContext ctx) {
        result /= Integer.parseInt(ctx.INT().toString());
    }

    int getResult(){
        return result;
    }
}
