## Regras a serem implementadas:
```
KARLOFF -> MAIN FUNC?

MAIN -> "void" "main" "(" ")" "{" VARDECL SEQCOMANDOS "}"

VARDECL -> VARDECL "newVar" TIPO TOKEN_id ";" | vazio

TIPO -> "integer" | "bool"

SEQCOMANDOS -> SEQCOMANDOS COMANDO | vazio

COMANDO -> TOKEN_id "=" EXP ";" 
    | TOKEN_id "(" LISTAEXP? ")" ";"
    | "if" "(" EXP ")" "then" "{" SEQCOMANDOS "}" ";"
    | "while" "(" EXP ")" "{" SEQCOMANDOS "}" ";"
    | "repeat" "{" SEQCOMANDOS "}" "until" "(" EXP ")" ";"
    | "return" EXP ";" 
    | "System.output" "(" EXP ")" ";"
    | TOKEN_id "=" "System.readint" "(" ")" ";"

EXP -> "(" EXP OP EXP ")" | FATOR

FATOR -> TOKEN_id | TOKEN_id "(" LISTAEXP? ")" | TOKEN_numliteral | "true" | "false

OP -> "+" | "-" | "*" | "/" | "&" | "|" | "<" | ">" | "=="

LISTAEXP -> EXP | LISTAEXP "," EXP

FUNC -> FUNC "func" TIPO TOKEN_id "(" LISTAARG? ")" "{" VARDECL SEQCOMANDOS "}"
    | "func" TIPO TOKEN_id "(" LISTAARG? ")" "{" VARDECL SEQCOMANDOS "}"

LISTAARG -> TIPO TOKEN_id | LISTAARG "," TIPO TOKEN_id
```

## Correções:

É possível verificar que as regras VARDECL, SEQCOMANDOS, LISTAEXP, FUNC e LISTAARG possuem recursão à esquerda. Logo, é necessário modificar a gramática, visto que o Analisador Sintático não reconhece este tipo de composição. Portanto, as regras citadas ficam da seguinte maneira:

```

VARDECL -> "newVar" TIPO TOKEN_id ";" VARDECL | vazio

SEQCOMANDOS -> COMANDO SEQCOMANDOS | vazio

LISTAEXP -> EXP LISTAEXP' 

LISTAEXP' -> "," EXP LISTAEXP' | vazio

FUNC -> "func" TIPO TOKEN_id "(" LISTAARG? ")" "{" VARDECL SEQCOMANDOS "}" FUNC'

FUNC' -> "func" TIPO TOKEN_id "(" LISTAARG? ")" "{" VARDECL SEQCOMANDOS "}" FUNC' | vazio

LISTAARG -> TIPO TOKEN_id LISTAARG'

LISTAARG' -> "," TIPO TOKEN_id LISTAARG' | vazio

```