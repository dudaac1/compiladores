## especificação

O objetivo do trabalho é implementar um Analisador Léxico para a Linguagem Karloff usando a ferramenta JavaCC. O aluno deve usar a gramática da linguagem Karloff (que está disponível em PDF) como referência para os possíveis tokens da linguagem. Por exemplo, para o seguinte programa escrito em Karloff:

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

Além da implementação do Analisador Léxico em JavaCC, o aluno deve também fornecer dois exemplos novos de programas escritos em Karloff que usem boa parte das construções da linguagem.

## execução

Para executar o Analisador Léxico, é necessário ter a ferramenta JavaCC instalada. 

Caso você tenha Windows, sugere-se instalar o WSL do Ubuntu disponível na Microsoft Store. Após instalar o Ubuntu, atualize o sistema com `apt-get update` e, após, instale o JavaCC com `apt-get install javacc`.

Os seguintes comandos deverão ser executados na linha de comando:

`javacc Karloff.jj`

`javac *.java`

`java Karloff teste.kar`