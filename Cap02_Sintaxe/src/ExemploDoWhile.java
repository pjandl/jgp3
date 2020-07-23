/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.12
 */
public class ExemploDoWhile {
	public static void main(String args[]) {
		// converte 1o e 2o argumentos para inteiro
		int min = Integer.parseInt(args[0]), max = Integer.parseInt(args[1]);
		do {
			System.out.println(min + " < " + max);
			min++;
			max--;
		} while (min < max);
		System.out.println(min + " < " + max + " Condicao invalida!");
	}
}
