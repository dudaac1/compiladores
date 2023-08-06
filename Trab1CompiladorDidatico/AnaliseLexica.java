import java.io.*;

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
	// PushbackReader is a character-stream reader class 
	// that allows characters to be pushed back into the Stream
	PushbackReader arquivo;
	AnaliseLexica(String a) throws Exception{		
	 	this.arquivo = new PushbackReader(new FileReader(a));		
	}

	Token getNextToken() throws Exception {	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

		do {
			currchar1 = arquivo.read(); //lendo character do arquivo
			currchar = (char) currchar1;
		} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');

		if (currchar1 != eof && currchar1 != 10) {
			if (currchar >= '0' && currchar <= '9') {
				StringBuilder aux = new StringBuilder();
				while (currchar >= '0' && currchar <= '9') {
					aux.append(currchar);
					currchar = (char) arquivo.read();
				}
				arquivo.unread((int) currchar);
				return (new Token(aux.toString(), TokenType.NUM));
			}
			else {
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