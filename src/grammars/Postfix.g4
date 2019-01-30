grammar Postfix;
import CommonLexerRules;

expr:   num NEWLINE?
    |   expr expr sign NEWLINE?
    ;

num:    INT ;

sign: op=('+'|'-'|'*'|'/')  ;

ADD :   '+' ;
SUB :   '-' ;
MUL :   '*' ;
DIV :   '/' ;
