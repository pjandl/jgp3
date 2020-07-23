/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.15
 */
public class ExemploRethrow2 {
	public static Object create(String className) throws Exception {
		try {
			Class<?> classe = Class.forName(className);
			return classe.newInstance();
		} catch (InstantiationException e) {
			// tratamento local
			System.out.println(e);
		} catch (Exception e) {
			throw e; // rethrow
		}
		return null;
	}

	public static void main(String... a) {
		try {
			Object o = create(a[0]);
			System.out.println("Objeto: " + o.getClass());
			// catch genérico
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
