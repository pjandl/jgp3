/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.11
 */
import java.util.*;

public class TreeSetDemo {
	public static void main(String a[]) {
		List<String> lista = Arrays.asList(a); // cria lista com argumentos
		System.out.println("Argumentos: " + lista); // exibe lista de argumentos
		TreeSet<String> ts1 = new TreeSet<>(lista); // cria conj. ordenado
		System.out.println("TreeSet1: " + ts1); // exibe conj. ordenado
		TreeSet<String> ts2 = new TreeSet<>(); // cria conj. ordenado vazio
		for (String e : lista) {
			ts2.add(e);
		} // adiciona argumentos
		System.out.println("TreeSet2: " + ts2); // exibe conj. ordenado
		SortedSet<String> ss1 = ts1.headSet(a[a.length / 2]); // obtem subconj.
																// inicial
		System.out.print("TreeSet.headSet: "); // exibe subconj. inicial
		Iterator<String> i1 = ss1.iterator();
		while (i1.hasNext()) {
			System.out.print(i1.next() + " ");
		}
		SortedSet<String> ss2 = ts2.tailSet(a[a.length / 2]); // obtem subconj.
																// final
		System.out.println("\nTreeSet.tailSet: first=" + ss2.first() + " last="
				+ ss2.last());
	}
}
