/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.9
 */
public class TesteGC {
	public static void main(String a[]) {
		System.out.println("Instancias = " + Objeto.getInstancias());
		for (int i = 0; i < 10; i++) {
			@SuppressWarnings("unused")
			Objeto o = new Objeto();
		}
		System.out.println("Instancias = " + Objeto.getInstancias());
		System.gc(); // aciona garbage collector
		System.out.println("Instancias = " + Objeto.getInstancias());
	}
}
