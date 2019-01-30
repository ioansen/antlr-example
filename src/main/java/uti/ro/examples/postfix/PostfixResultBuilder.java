package uti.ro.examples.postfix;


import uti.ro.examples.gen.postfix.PostfixBaseListener;
import uti.ro.examples.gen.postfix.PostfixParser;
import static uti.ro.examples.gen.postfix.PostfixParser.*;

import java.util.Stack;

public class PostfixResultBuilder extends PostfixBaseListener {

    private Stack<Integer> numbersStack = new Stack<>();

    @Override
    public void enterNum(NumContext ctx) {
        numbersStack.push(Integer.parseInt(ctx.INT().toString()));
    }

    @Override
    public void enterSign(SignContext ctx) {
        int secondOp = numbersStack.pop();
        int firstOp = numbersStack.pop();

        switch (ctx.op.getType()){
            case ADD:
                numbersStack.push(firstOp + secondOp);
                break;
            case SUB:
                numbersStack.push(firstOp - secondOp);
                break;
            case MUL:
                numbersStack.push(firstOp * secondOp);
                break;
            case DIV:
                numbersStack.push(firstOp / secondOp);
                break;
        }
    }

    int getResult(){
        return numbersStack.pop();
    }
}
