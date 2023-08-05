# compiladores
Repositório para armazenar exercícios e trabalhos referentes a cadeira de Projeto de Compiladores do curso de Ciência da Computação.

# especificações

## trabalho 1 : compilador didático
(1) A implementação atual do compilador didático aceita apenas números com um único dígito. Modificar o compilador para que ele aceite também números naturais com mais de um dígito

(2) A implementação atual do compilador didático aceita apenas as operações de soma e multiplicação. Modifique o compilador para que aceite também subtração e divisão. Para essas operações, gerar as instruções SUB e DIV.

(3) O compilador didático possui um back-end que gera código para uma máquina de pilha hipotética: 
`CodeGen backend = new CodeGen();
String codigo = backend.geraCodigo(arv);``
O back-end recebe como entrada a árvore sintática e percorre essa árvore gerando código para uma máquina de pilha. Substituir o back-end desse compilador por um back-end interpretador, ou seja, ao invés de gerar uma String com código para ser executado na máquina de pilha, o back-end já devolve o resultado da computação da expressão de entrada.


(4) Implementar em Java, uma máquina de pilha que execute as instruções geradas pelo compilador didático. A máquina de pilha deve receber como entrada um arquivo texto com as instruções e devolver como saída o resultado final da execução dessas instruções.
A classe principal deve se chamar MaquinaPilha. Ex:

`~$ java MaquinaPilha arquivoDeEntrada`

OBS: Os exercícios 1, 2 e 3 são incrementais, ou seja, o exercício 2 deve ser implementado em
cima das modificações feitas no exercício 1, e o exercício 3 deve ser implementado em cima da
versão gerada no exercício 2.

## trabalho 2 : analisador léxico

O objetivo do trabalho é implementar um analisador léxico para a Linguagem Karloff
usando a ferramenta JavaCC. O aluno deve usar a gramática da linguagem Karloff (que está disponível em arquivo separado no e-aula) como referência para os possíveis tokens da linguagem. Por exemplo, para o seguinte programa escrito em Karloff:

```
void main () {
    newVar integer teste;
    teste = 9;
    System.output (teste);
}
```

a saída deve ser algo parecido com:

```
$java Karloff teste.kar
    Palavra reservada: void
    Palavra reservada: main
    Abre parênteses: (
    Fecha parênteses: )
    Abre chaves: {
    Palavra reservada: newVar
    Palavra reservada: integer
    Identificador: teste
    Ponto e virgula: ;
    Identificador: teste
    Atribuição: =
    Número: 9
    Ponto e virgula: ;
    Palavra reservada: System.output
    Abre parênteses: (
    Identificador: teste
    Fecha parênteses: )
    Ponto e virgula: ;
    Fecha chaves: }
```

Além da implementação do analisador léxico em javacc, o aluno deve também fornecer
2 exemplos novos de programas escritos em Karloff que usem boa parte das
construções da linguagem

## trabalho 3 : analisador sintático
O objetivo do trabalho é implementar um parser (Analisador Sintático) para a linguagem Karloff. O parser deve ser construído em cima do analisador léxico proposto para a mesma linguagem no trabalho 2. Lembrando que o JavaCC não aceita recursão à esquerda nem alternativas começando com um mesmo símbolo, dessa forma, essas construções devem ser eliminadas da gramática caso existam. As dicas de como implementar esse parser estão na vídeo aula: 09 - Análise Sintática usando a ferramenta Javacc. Os alunos devem entregar também dois exemplos de programas que usem uma grande parte das construções sintáticas disponíveis na linguagem.

##
*Eduarda A. Carvalho, agosto/2023.<br>
Última alteração: agosto/2023.<br>
eduarda.carvalho@inf.ufpel.edu.br*