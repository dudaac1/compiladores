## especificação
O objetivo do trabalho é implementar um *parser* (Analisador Sintático) para a linguagem Karloff. Ele deve ser construído em cima do Analisador Léxico proposto para a mesma linguagem no Trabalho 2. Lembrando que o JavaCC não aceita recursão à esquerda nem alternativas começando com um mesmo símbolo, dessa forma, essas construções devem ser eliminadas da gramática caso existam. 

Dicas:
- todo não-terminal vira uma função;
- todo terminal deve ser chamado por meio do seu token. Exemplo: para *main* usar < MAIN >;
- a primeira regra deve possuir < EOF > antes de fechar sua declaração;
- uma regra que possua a opção de "ou vazio" deve ser implementada com o símbolo ?. Exemplo: a regra `C → COM ";" C' | vazio` é apresentada do seguinte modo:
    ```
    void C(): {} {
        (C() < PONTOVIRGULA > CLinha())?        
    }
    ```
- o OU no JavaCC é um pipe (|) e o E um &&;

Também deve ser entregue dois exemplos de programas que usem uma grande parte das construções sintáticas disponíveis na linguagem.

## regras para implementar
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

### correções:

É possível verificar que as regras VARDECL, SEQCOMANDOS, LISTAEXP, FUNC e LISTAARG possuem recursão à esquerda. As regras COMANDO e FATOR possuem regras que tem o mesmo inicio, sendo necessário fatorá-la. Logo, é necessário modificar a gramática, visto que o Analisador Sintático não reconhece estes tipos de composições. Portanto, as regras citadas, após correções, ficam da seguinte maneira:

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

## execução

Para executar o Analisador Sintático, é necessário ter a ferramenta JavaCC instalada. 

Caso você tenha Windows, sugere-se instalar o WSL do Ubuntu disponível na Microsoft Store. Após instalar o Ubuntu, atualize o sistema com `apt-get update` e, após, instale o JavaCC com `apt-get install javacc`.

Os seguintes comandos deverão ser executados na linha de comando:

`javacc Karloff.jj`

`javac *.java`

`java Karloff teste.kar`