/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.3
 */
public class Escopo { // In�cio do bloco 0
	public static void main (String arg[]) { // In�cio do bloco 1
		int i = 5; // Vari�vel do bloco 1
		{ // In�cio do bloco 2
			int j = 0; // Vari�vel do bloco 2
			System.out.println(i); // Uso de i dentro do seu escopo
			j = 5 * i; // Uso de j dentro do seu escopo
			System.out.println(j);
			{ // Inicio do bloco 3
				System.out.println(i); // Uso de i dentro do seu escopo
				System.out.println(j); // Uso de j dentro do seu escopo
			}
		}
		System.out.println(i); // Uso de i dentro do seu escopo
//		System.out.println(j); // ERRO! Uso de j FORA do seu escopo
	}
}
