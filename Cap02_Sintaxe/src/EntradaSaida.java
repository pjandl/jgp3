/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.4
 */
import java.util.Scanner; // importa��o da classe Scanner do pacote java.util

public class EntradaSaida {
	public static void main(String args[]) {
		System.out.println("Ola!"); // Mensagem inicial
		System.out.print("Digite um inteiro: "); // Exibe mensagem
		Scanner s = new Scanner(System.in); // Prepara entrada de dados
		int valor = s.nextInt(); // Declara e inicia vari�vel
		System.out.println("Valor = " + valor); // Exibe valor lido
		s.close(); // Fecha objeto leitor
	}
}
