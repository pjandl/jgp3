/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.45
 */
import java.util.Scanner;

public class Lista {
	public static void main(String arg[]) {
		No lista = null; // lista vazia (sem n�s)
		Scanner sc = new Scanner(System.in); // prepara console
		String aux;
		do { // la�o para solicita��o de dados
			System.out.println("Digite uma palavra (. encerra):");
			aux = sc.next();
			if (!aux.equals(".")) {
				No novo = new No(aux, lista);
				lista = novo;
			}
		} while (!aux.equals("."));
		sc.close();
		System.out.println("Lista das Palavras:\n");
		No no = lista; // vari�vel auxiliar p/ navegar lista
		while (no != null) {
			System.out.print(no.nome + " ");
			no = no.proximo;
		}
		System.out.println("<.>");
	}

	// classe aninhada est�tica
	private static class No {
		public String nome;
		public No proximo;

		@SuppressWarnings("unused")
		public No() {
			this(null, null); // aciona construtor parametrizado
		}

		public No(String n, No p) {
			nome = n;
			proximo = p;
		}
	}
}
