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
			System.out.println(codigo);
			// calcular resultado
			Interpretador calculo = new Interpretador();
			int result = calculo.interpretador(arv);
			System.out.println("Resultado: " + result);
		} catch (Exception e) {			
			System.out.println("Erro de compilação:\n" + e);
		}
	}
}
