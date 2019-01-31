grammar Postfix;
import CommonLexerRules;

stat: expr NEWLINE? ;

expr:   num
    |   expr expr sign
    ;

num :   INT         # PositiveNum
    |   '-' INT     # NegativeNum
    ;

sign:   '+'         # Add
    |   '-'         # Sub
    |   '*'         # Mul
    |   '/'         # Div
    ;

