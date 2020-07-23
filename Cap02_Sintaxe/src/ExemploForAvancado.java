/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.10
 */
public class ExemploForAvancado {
	public static void main(String arg[]) {
		double arranjo[] = { 1.1964, 6.1935, 6.1995, 7.1931, 12.1968 };
		System.out.print("For Comum    [ ");
		int tamanho = arranjo.length;
		for (int i = 0; i < tamanho; i++)
			System.out.print(arranjo[i] + " ");
		System.out.println("] Fim");
		System.out.print("For Avancado [ ");
		for (double elemento : arranjo)
			System.out.print(elemento + " ");
		System.out.println("] Fim");
	}
}
