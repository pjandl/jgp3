/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.29
 */
import java.util.Arrays;
import java.util.Scanner;
public class ArranjoOrdenado {
	public static void main (String args[]) {
		int a[] = new int[10]; // declara e aloca arranjo inteiro
		Scanner sc = new Scanner(System.in); // prepara console
		for (int i=0; i<a.length; i++) { // lê valores para arranjo
			System.out.print("a[" + i + "]? ");
			a[i] = sc.nextInt();
		}
		sc.close(); // fecha console
		// Exibe arranjo fornecido, efetua ordenação e reexibe arranjo
		System.out.println("Arranjo Fornecido\n" + Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("Arranjo Ordenado\n" + Arrays.toString(a));
}	}
