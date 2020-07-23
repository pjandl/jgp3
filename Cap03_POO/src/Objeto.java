/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.8
 */
public class Objeto {
	private static int instancias = 0;
	private int id;

	public Objeto() {
		id = instancias++;
		System.out.println("Objeto.Objeto() [id=" + id + "]");
	}

	public static int getInstancias() {
		return instancias;
	}

	public int getId() {
		return id;
	}

	@Override
	protected void finalize() {
		instancias--;
		System.out.println("Objeto.finalize() [id=" + id + "]");
	}
}
