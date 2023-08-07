import java.io.*;
import java.util.Stack;

class MaquinaPilha {
	public static void main(String[] args) {	
        BufferedReader arquivo;
        Stack<Integer> pilha = new Stack<>();
        int resultado, num1, num2;
        String linha;
		try {
            arquivo = new BufferedReader(new FileReader(args[0]));
            while ( (linha = arquivo.readLine()) != null) {
                switch (linha) {
                    case "SUM":
                        num1 = pilha.pop();
                        num2 = pilha.pop();
                        pilha.push(num1+num2);
                        System.out.println(num1 +"+"+ num2 +"="+ (num1+num2));
                        break;
                    case "SUB":
                        num1 = pilha.pop();
                        num2 = pilha.pop();
                        pilha.push(num2-num1);
                        System.out.println(num2 +"-"+ num1 +"="+ (num2-num1));
                        break;
                    case "MULT":
                        num1 = pilha.pop();
                        num2 = pilha.pop();
                        pilha.push(num1*num2);
                        System.out.println(num1 +"*"+ num2 +"="+ (num1*num2));
                        break;
                    case "DIV":
                        num1 = pilha.pop();
                        num2 = pilha.pop();
                        pilha.push(num2/num1);
                        System.out.println(num2 +"/"+ num1 +"="+ (num2/num1));
                        break;
                    case "PRINT":
                        System.out.println(pilha.pop());
                    default:
                        if (linha.contains("PUSH ")) {
                            linha = linha.replace("PUSH ", "");
                            pilha.push(Integer.valueOf(linha));
                        }
                }
            }
            arquivo.close();
		} catch (Exception e) {			
			System.out.println("Erro de compilação:\n" + e);
		}
	}
}
