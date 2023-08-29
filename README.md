# 🛠️ compiladores
Repositório para armazenar exercícios e trabalhos referentes a cadeira de Projeto de Compiladores do curso de Ciência da Computação.

# 🗂️ especificações

Para maiores detalhes acerca de cada trabalho, visualizar o README na pasta referente.

## 1️⃣: compilador didático
O objetivo do trabalho é implementar quatro alterações incrementais tendo como base o código fornecido: 
- permitir que o compilador aceite números naturais com mais de um dígito;
- adicionar operações de subtração e divisão;
- computar a expressão de entrada;
- implementar uma Máquina de Pilha para computar o código de pilha.

## 2️⃣: analisador léxico
O objetivo do trabalho é implementar um Analisador Léxico para a Linguagem Karloff usando a ferramenta JavaCC. O aluno deve usar a gramática da linguagem Karloff (que está disponível em PDF) como referência para os possíveis tokens da linguagem. [...] Além da implementação do Analisador Léxico em JavaCC, o aluno deve também fornecer dois exemplos novos de programas escritos em Karloff que usem boa parte das construções da linguagem.

## 3️⃣: analisador sintático
O objetivo do trabalho é implementar um *parser* (Analisador Sintático) para a linguagem Karloff. Ele deve ser construído em cima do Analisador Léxico proposto para a mesma linguagem no Trabalho 2. Lembrando que o JavaCC não aceita recursão à esquerda nem alternativas começando com um mesmo símbolo, dessa forma, essas construções devem ser eliminadas da gramática caso existam.  Também deve ser entregue dois exemplos de programas que usem uma grande parte das construções sintáticas disponíveis na linguagem. 

## 4️⃣: compilador
O objetivo do trabalho é implementar um compilador para a Linguagem Karloff, usando tradução dirigida por sintaxe, na ferramenta Javacc. Para realizar esta tarefa, é necessário adicionar ações semânticas às regras sintáticas já implementadas em Javacc, para que seja gerada uma árvore sintática do programa Karloff sendo compilado. Em seguida, o programa deve percorrer a árvore sintática gerando código Java (ou qualquer outra linguagem de programação) semanticamente equivalente ao código Karloff original.

##
*Eduarda A. Carvalho, agosto/2023.<br>
Última alteração: agosto/2023.<br>
eduarda.carvalho@inf.ufpel.edu.br*