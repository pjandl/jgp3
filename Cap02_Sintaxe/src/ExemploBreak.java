/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.16
 */
import java.util.Scanner;

public class ExemploBreak {
	public static void main(String args[]) {
		// leitura do numero máximo de pares desejados
		System.out.print("Maximo no pares ? ");
		Scanner s = new Scanner(System.in);
		int max = s.nextInt(); // variável p/ número máximo de pares
		int pares = 0; // variável p/ contar pares encontrados
		for (int i = 0; i < 1000; i++) { // for com variável imediata
			if (i % 2 == 0) {
				pares++;
				System.out.printf("i = %4d  pares = %4d%n", i, pares);
			}
			if (pares == max) {
				break;
			}
		}
		s.close();
	}
}
