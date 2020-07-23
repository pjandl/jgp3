/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.27
 */
import java.util.Scanner;

public class ArranjoForAvancado {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("No de elementos ? "); // l� no. de elementos
		int tamanho = sc.nextInt();
		assert tamanho > 0; // usa assert
		int arranjo[] = new int[tamanho]; // aloca arranjo
		for (int i = 0; i < tamanho; i++) { // for comum p/ ler elementos
			System.out.print("Elemento[" + i + "]? ");
			arranjo[i] = sc.nextInt();
		}
		sc.close();
		int soma = 0;
		System.out.print("[ ");
		for (int elemento : arranjo) { // for avan�ado p/ somar elementos
			soma += elemento; // soma elementos
			System.out.print(elemento + " ");
		}
		System.out.println("] soma = " + soma); // exibe soma obtida
	}
}
