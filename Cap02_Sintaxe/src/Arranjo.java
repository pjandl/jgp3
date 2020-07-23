/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.26
 */
import java.util.Scanner;

public class Arranjo {
	public static void main(String args[]) {
		int a[] = new int[10]; // declara e aloca arranjo inteiro
		Scanner sc = new Scanner(System.in); // prepara console
		for (int i = 0; i < a.length; i++) { // lê valores para arranjo
			System.out.print("a[" + i + "]? ");
			a[i] = sc.nextInt();
		}
		int soma = 0; // exibe arranjo e soma seus elementos
		for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
			soma += a[i];
		}
		System.out.println("Soma = " + soma); // exibe soma obtida
		sc.close();
	}
}
