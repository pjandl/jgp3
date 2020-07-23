/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.1
 */
public class MinhaThread extends Thread {
	@Override
	public void run() {
		System.out.println("Inicio: " + getName());
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "-" + getName());
		}
		System.out.println("Fim: " + getName());
	}
}
