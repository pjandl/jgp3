/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.14
 */
public class ExemploSwitch {
	public static void main(String args[]) {
		if (args.length > 0) { // testa presença de argumentos
			switch (args[0].charAt(0)) { // avalia inicial do 1o argumento
			case 'a': // argumento com inicial a minúscula ou maiúscula
			case 'A':
				System.out.println("Vogal A.");
				break;
			case 'e': // argumento com inicial e minúscula ou maiúscula
			case 'E':
				System.out.println("Vogal E.");
				break;
			case 'i': // idem
			case 'I':
				System.out.println("Vogal I.");
				break;
			case 'o':
			case 'O':
				System.out.println("Vogal O.");
				break;
			case 'u':
			case 'U':
				System.out.println("Vogal U.");
				break;
			default: // inicial nao é uma vogal
				System.out.println("Nao e uma vogal.");
			}
		} else {
			System.out.println("Nao foi fornecido argumento.");
		}
	}
}
