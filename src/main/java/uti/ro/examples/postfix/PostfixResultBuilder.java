package uti.ro.examples.postfix;


import uti.ro.examples.gen.postfix.PostfixBaseListener;

import static uti.ro.examples.gen.postfix.PostfixParser.*;

import java.util.Stack;

public class PostfixResultBuilder extends PostfixBaseListener {

    private Stack<Integer> stack = new Stack<>();
    private int firstOp;
    private int secondOp;

    @Override
    public void enterPositiveNum(PositiveNumContext ctx) {
        stack.push(stringToInt(ctx.INT().toString()));
    }

    @Override
    public void enterNegativeNum(NegativeNumContext ctx) {
        stack.push(-stringToInt(ctx.INT().toString()));
    }

    private int stringToInt(String string){
        return Integer.parseInt(string);
    }

    @Override
    public void enterAdd(AddContext ctx) {
        popOperands();
        pushResult(firstOp + secondOp);
    }

    @Override
    public void enterSub(SubContext ctx) {
        popOperands();
        pushResult(firstOp - secondOp);
    }

    @Override
    public void enterMul(MulContext ctx) {
        popOperands();
        pushResult(firstOp * secondOp);
    }

    @Override
    public void enterDiv(DivContext ctx) {
        popOperands();
        pushResult(firstOp / secondOp);
    }

    private void popOperands(){
        secondOp = stack.pop();
        firstOp = stack.pop();
    }

    private void pushResult(int result){
        stack.push(result);
    }

    int getResult(){
        return stack.pop();
    }
}
