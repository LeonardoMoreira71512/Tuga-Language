grammar Tuga;

program : (varDeclaration)* functionDeclaration+ EOF;

functionDeclaration: FUNCAO VAR_NAME LPAREN arguments? RPAREN (':' type)? bloco;

arguments: parameter (',' parameter)*;

parameter: VAR_NAME ':' type;

varDeclaration: VAR_NAME (','VAR_NAME)* ':' type ';';

type : (TypeINT | TypeDOUBLE | TypeSTRING | TypeBOOL);

inst : ESCREVE expr ';'         # Print
     | VAR_NAME '<-' expr ';'   # Afection
     | bloco                    # Block
     | enquanto                 # While
     | seSenao                  # IfElse
     | RETORNA expr? ';'        # Return
     | funcCall ';'             # VoidFunctionCall
     | ';'                      # Empty
     ;

funcCall : VAR_NAME LPAREN (expr (',' expr)*)? RPAREN;

bloco : INICIO varDeclaration* inst* FIM;

enquanto : ENQUANTO LPAREN expr RPAREN inst;

seSenao : SE LPAREN expr RPAREN inst (SENAO inst)?;

expr : LPAREN expr RPAREN                # Parentheses
     | op=(MINUS|NAO) expr               # Negation
     | expr op=(MULT|DIV|MOD) expr       # MultDivMod
     | expr op=(ADD|MINUS) expr          # AddSub
     | expr op=(GT|LT|GET|LET) expr      # Relational
     | expr op=(IGUAL|DIFERENTE) expr    # Equility
     | expr E expr                       # E
     | expr OU expr                      # OU
     | INT                               # Int
     | DOUBLE                            # Double
     | STRING                            # String
     | BOOLEAN                           # Boolean
     | VAR_NAME                          # Variable
     | funcCall                          # FunctionCallExpr
     ;

//Language Types
INT: DIGIT+;
DOUBLE: DIGIT+'.'DIGIT+;
STRING: '"' ('\\"'|.)*? '"';
BOOLEAN: VERDADEIRO | FALSO;

//Reserved Keywords
ESCREVE: 'escreve';
RETORNA: 'retorna';

VERDADEIRO: 'verdadeiro';
FALSO: 'falso';
TypeINT: 'inteiro';
TypeDOUBLE: 'real';
TypeSTRING: 'string';
TypeBOOL: 'booleano';
INICIO: 'inicio';
FIM: 'fim';
ENQUANTO: 'enquanto';
SE: 'se';
SENAO: 'senao';
FUNCAO: 'funcao';

//Operators
LPAREN: '(';
RPAREN: ')';
MINUS: '-';
ADD: '+';
MULT: '*';
DIV: '/';
MOD: '%';
GT: '>';
LT: '<';
GET: '>=';
LET: '<=';
IGUAL: 'igual';
DIFERENTE: 'diferente';
NAO: 'nao';
E: 'e';
OU: 'ou';

VAR_NAME: ('_'|LETTER) ('_'|LETTER|DIGIT)*;

WS: [ \t\r\n]+ -> skip ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip;
ML_COMMENT : '/*' .*? '*/' -> skip ;

fragment
DIGIT : [0-9] ;
LETTER : [A-Za-z];