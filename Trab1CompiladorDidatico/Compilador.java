import java.io.PrintWriter;

class Compilador {
	public static void main(String[]args) {	
		ArvoreSintatica arv = null;
		try {
			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
			arv = as.parseProg();

			// código para máquina de pilha
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);
			System.out.println("\n" + codigo);

			// calcular resultado
			Interpretador calculo = new Interpretador();
			int result = calculo.interpretador(arv);
			System.out.println("\nResultado: " + result);

			// salvar código p maq de pilha
			PrintWriter arquivo = new PrintWriter(args[0] + "-pilha");
			arquivo.print(codigo);
			arquivo.close();
			System.out.println("\nArquivo " + args[0] + "-pilha criado.\n");

		} catch (Exception e) {			
			System.out.println("Erro de compilação:\n" + e);
		}
	}
}
