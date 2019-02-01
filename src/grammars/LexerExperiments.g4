grammar LexerExperiments;

string
    :   value+ NL?
    ;

value
    :   AD  # AD
    |   AC  # AC
    |   FN  # FN
    |   AA  # AA
    ;




AD  :   M M A?  ;
AA  :   A A A?  ;
AC  :   A A A   ;
FN  :   F F F   ;
/*RT  :   M M M? M? M? M? M? M? M? M? ;*/

A   :   [A-Z]   ;
F   :   [0-9]   ;
M   :   A | F   ;

NL  :   '\r'? '\n'  ;