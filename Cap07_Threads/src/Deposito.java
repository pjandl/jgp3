/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.10
 */
public class Deposito {
	protected int valor;

	public void armazenar(int valor) {
		this.valor = valor;
	}

	public int retirar() {
		return valor;
	}
}
