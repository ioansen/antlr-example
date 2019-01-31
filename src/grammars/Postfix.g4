grammar Postfix;
import CommonLexerRules;

stat: expr NEWLINE? ;

expr:   num
    |   expr expr sign
    ;

num :   INT ;

sign:   '+'     # Add
    |   '-'     # Sub
    |   '*'     # Mul
    |   '/'     # Div
    ;

