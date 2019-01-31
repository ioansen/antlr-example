grammar Json;

json:   object
    |   array
    ;

object: '{' pair (',' pair)* '}'    # anObject
    |   '{' '}'                     # emptyObject
    ;

pair:   STRING ':' value;

array:  '[' value (',' value)* ']'  # anArray
    |   '[' ']'                     # emptyArray
    ;

value:  STRING      # string
    |   NUMBER      # atom
    |   object      # objectValue
    |   array       # arrayValue
    |   'true'      # atom
    |   'false'     # atom
    |   'null'      # atom
    ;

STRING : '"' (ESC | ~["\\])* '"' ;

fragment ESC : '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

NUMBER: '-'? INT '.' INT EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP // 1e10 -3e4
    |   '-'? INT // -3, 45
    ;
fragment INT : '0' | [1-9] [0-9]* ; // no leading zeros
fragment EXP : [Ee] [+\-]? INT ; // \- since - means "range" inside [...]

WS : [ \t\n\r]+ -> skip ;