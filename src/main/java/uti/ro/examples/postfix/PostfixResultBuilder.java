package uti.ro.examples.postfix;


import uti.ro.examples.gen.postfix.PostfixBaseListener;

import static uti.ro.examples.gen.postfix.PostfixParser.*;

import java.util.Stack;

public class PostfixResultBuilder extends PostfixBaseListener {

    private Stack<Integer> numbersStack = new Stack<>();
    private int firstOp;
    private int secondOp;

    @Override
    public void enterPositiveNum(PositiveNumContext ctx) {
        numbersStack.push(Integer.parseInt(ctx.INT().toString()));
    }

    @Override
    public void enterNegativeNum(NegativeNumContext ctx) {
        numbersStack.push(-Integer.parseInt(ctx.INT().toString()));
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
        secondOp = numbersStack.pop();
        firstOp = numbersStack.pop();
    }

    private void pushResult(int result){
        numbersStack.push(result);
    }

    int getResult(){
        return numbersStack.pop();
    }
}
