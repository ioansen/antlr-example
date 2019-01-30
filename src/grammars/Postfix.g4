grammar Postfix;
import CommonLexerRules;

stat:   INT
    |   INT NEWLINE
    |   INT expr
    |   INT expr NEWLINE
    |   NEWLINE
    ;

expr:   add
    |   sub
    |   mul
    |   div
    ;

add :   INT '+' ;

sub :   INT '-' ;

mul :   INT '*' ;

div :   INT '/' ;
