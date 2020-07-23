/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.14
 */
public class ExemploRethrow {
	public static Object create(String className)
			throws ClassNotFoundException, IllegalAccessException {
		try {
			Class<?> classe = Class.forName(className);
			return classe.newInstance();
		} catch (InstantiationException e) {
			// tratamento local
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			throw e; // rethrow
		} catch (IllegalAccessException e) {
			throw e; // rethrow
		}
		return null;
	}

	public static void main(String... a) {
		try {
			Object o = create(a[0]);
			System.out.println("Objeto: " + o.getClass());
			// multi-catch
		} catch (ClassNotFoundException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
