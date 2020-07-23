/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.8
 */
public class Corredor extends Thread {
	public int distancia = 0;
	private int max;

	public Corredor(int max) {
		this.max = max;
	}

	public void run() {
		while (distancia < max) {
			distancia++;
			System.out.println("#" + distancia); // interrupção possível
		}
	}
}
