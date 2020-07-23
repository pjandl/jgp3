/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.43
 */
public class Externa {
	private int valor;

	public Externa(int valor) {
		this.valor = valor;
	}

	public class Aninhada {
		public void exibir() {
			System.out.println("valor = " + valor);
		}
	}
}
