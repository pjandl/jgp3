/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.44
 */
public class OutraExterna {
	private static int valor;

	public static class AninhadaEstatica {
		public void exibir() {
			System.out.println("valor = " + valor);
		}
	}
}
