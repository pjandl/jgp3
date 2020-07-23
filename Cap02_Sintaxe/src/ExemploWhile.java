/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.11
 */
public class ExemploWhile {
	public static void main(String args[]) {
		int j = Integer.parseInt(args[0]);
		while (j >= 0) {
			System.out.println(j);
			j--;
		}
	}
}
