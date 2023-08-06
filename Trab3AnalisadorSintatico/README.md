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

É possível verificar que as regras VARDECL, SEQCOMANDOS, LISTAEXP, FUNC e LISTAARG possuem recursão à esquerda. As regras COMANDO, FATOR possuem regras que tem o mesmo inicio, sendo necessário fatorá-la. Logo, é necessário modificar a gramática, visto que o Analisador Sintático não reconhece estes tipos de composições. Portanto, as regras citadas ficam da seguinte maneira:

```

VARDECL -> "newVar" TIPO TOKEN_id ";" VARDECL | vazio

SEQCOMANDOS -> COMANDO SEQCOMANDOS | vazio

COMANDO -> TOKEN_id COMANDO'
    | "if" "(" EXP ")" "then" "{" SEQCOMANDOS "}" ";"
    | "while" "(" EXP ")" "{" SEQCOMANDOS "}" ";"
    | "repeat" "{" SEQCOMANDOS "}" "until" "(" EXP ")" ";"
    | "return" EXP ";" 
    | "System.output" "(" EXP ")" ";"

COMANDO' -> "(" LISTAEXP? ")" ";" | "=" COMANDO''

COMANDO'' -> EXP ";" | "System.readint" "(" ")" ";"

FATOR -> TOKEN_id FATOR' | TOKEN_numliteral | "true" | "false

FATOR' -> "(" LISTAEXP? ")" | vazio

LISTAEXP -> EXP LISTAEXP' 

LISTAEXP' -> "," EXP LISTAEXP' | vazio

FUNC -> "func" TIPO TOKEN_id "(" LISTAARG? ")" "{" VARDECL SEQCOMANDOS "}" FUNC'

FUNC' -> "func" TIPO TOKEN_id "(" LISTAARG? ")" "{" VARDECL SEQCOMANDOS "}" FUNC' | vazio

LISTAARG -> TIPO TOKEN_id LISTAARG'

LISTAARG' -> "," TIPO TOKEN_id LISTAARG' | vazio

```

## Execução

Para executar o Analisador Sintático, é necessário ter a ferramenta JavaCC instalada. 

Caso você tenha Windows, sugere-se instalar o WSL do Ubuntu disponível na Microsoft Store. Após instalar o Ubuntu, atualize o sistema com `apt-get update` e, após, instale o JavaCC com `apt-get install javacc`.

Os seguintes comandos deverão ser executados na linha de comando:

`javacc Karloff.jj`

`javac *.java`

`java Karloff teste.kar`