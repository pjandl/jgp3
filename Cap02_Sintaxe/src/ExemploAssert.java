/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.25
 */
import java.util.Scanner;

public class ExemploAssert {
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in); // cria leitor de dados
		System.out.print("Forneca inteiro>9: ");
		int valor = sc.nextInt(); // l� valor inteiro
		assert valor > 9; // esperado valor maior que nove
		int soma = 0; // declara vari�vel para soma
		for (int i = 1; i < valor; i++) { // realiza la�o para efetuar soma
			soma += i;
			assert soma < 99 : "soma(" + soma + ")>=99"; // esperado soma<99
		}
		System.out.println("soma[1.." + valor + "] = " + soma);
		sc.close();
	}
}
