Para executar o Analisador Léxico, é necessário ter a ferramenta JavaCC instalada. 

Caso você tenha Windows, sugere-se instalar o WSL do Ubuntu disponível na Microsoft Store. Após instalar o Ubuntu, atualize o sistema com `apt-get update` e, após, instale o JavaCC com `apt-get install javacc`.

Os seguintes comandos deverão ser executados na linha de comando:

`javacc Karloff.jj`

`javac *.java`

`java Karloff teste1.kar`