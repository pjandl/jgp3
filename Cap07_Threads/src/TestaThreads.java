/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.2
 */
public class TestaThreads {
	public static void main(String a[]) {
		System.out.println("Inicio: main");
		MinhaThread mt1 = new MinhaThread(), mt2 = new MinhaThread(), mt3 = new MinhaThread();
		mt1.start();
		mt2.start();
		mt3.start();
		System.out.println("Fim: main");
	}
}
