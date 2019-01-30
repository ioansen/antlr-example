grammar Postfix;
import CommonLexerRules;

expr:   INT (expr sign)? NEWLINE?
    ;

sign: op=('+'|'-'|'*'|'/')  ;

ADD :   '+' ;
SUB :   '-' ;
MUL :   '*' ;
DIV :   '/' ;
