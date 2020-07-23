/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.69
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RefMetConstructor {
	// M�todo f�brica de listas
	public static <T> List<T> createList() {
		return new ArrayList<T>();
	}

	// Supplier de listas<long>
	public static Supplier<List<Long>> listFactory = ArrayList<Long>::new;

	public static void main(String[] args) throws Exception {
		// Obten��o expl�cita de lista
		List<Long> lista1 = new ArrayList<Long>();
		// Obten��o de lista com f�brica
		List<Long> lista2 = RefMetConstructor.createList();
		// Obten��o de lista com Supplier
		List<Long> lista3 = RefMetConstructor.listFactory.get();
		// Uso das listas
		lista1.add(123456789L);
		lista2.add(135791113L);
		lista2.addAll(lista1);
		lista3.add(2468101214L);
		lista3.addAll(lista2);
		System.out.println("Lista1: " + lista1);
		System.out.println("Lista2: " + lista2);
		System.out.println("Lista3: " + lista3);
	}
}
