grammar Postfix;
import CommonLexerRules;

stat: expr NEWLINE? ;

expr:   num
    |   expr expr sign
    ;

num :   INT ;

sign: op=('+'|'-'|'*'|'/')  ;

ADD :   '+' ;
SUB :   '-' ;
MUL :   '*' ;
DIV :   '/' ;
