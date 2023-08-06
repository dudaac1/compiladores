import java.io.*;
import java.lang.System;

enum TokenType { NUM, SOMA, MULT, APar, FPar, EOF, DIV, SUB}

class Token {
	String lexema;
	TokenType token;

	Token (String l, TokenType t) {
		lexema = l; 
		token = t;
	}	
}

class AnaliseLexica {
	static char lastchar;
	static int flag = 0; 

	BufferedReader arquivo;
	AnaliseLexica(String a) throws Exception {
	 	this.arquivo = new BufferedReader(new FileReader(a));
	}

	Token getNextToken() throws Exception {	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

		if (flag == 1) {
			currchar = lastchar;
			currchar1 = (int) lastchar;
		}
		else {
			do {
				currchar1 = arquivo.read(); //lendo character do arquivo
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
		}

		// System.out.println(currchar);
		if (currchar1 != eof && currchar1 != 10) {
			if (currchar >= '0' && currchar <= '9') {
				flag = 1;
				StringBuilder aux = new StringBuilder();
				while (currchar >= '0' && currchar <= '9') {
					aux.append(currchar);
					currchar = (char) arquivo.read();
					lastchar = currchar;
				}
				return (new Token(aux.toString(), TokenType.NUM));
			}
			else {
				flag = 0;
				switch (currchar) {
					case '(':
						return (new Token(String.valueOf(currchar), TokenType.APar));
					case ')':
						return (new Token(String.valueOf(currchar), TokenType.FPar));
					case '+':
						return (new Token(String.valueOf(currchar), TokenType.SOMA));
					case '*':
						return (new Token(String.valueOf(currchar), TokenType.MULT));
					case '-':
						return (new Token(String.valueOf(currchar), TokenType.SUB));
					case '/':
						return (new Token(String.valueOf(currchar), TokenType.DIV));
					default: 
						throw (new Exception("Caractere inválido: " + ((int) currchar)));
				}
			}
		}

		arquivo.close();
		return (new Token(String.valueOf(currchar),TokenType.EOF));
	}

}