/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.32
 */
public class ExemploAnotacao {
	public static void main(String[] args) {
		System.out.println("Valor aleatorio: " + Anotacoes.random());
	}
}

class Anotacoes {
	@Deprecated
	public static double random() {
		return Math.random();
	}

	@Override
	@SuppressWarnings("unused")
	public String toString() {
		int x;
		return "ExemploAnotação";
	}
}