/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.18
 */
import java.util.*;

public class DupNoDup {
	public static void main(String args[]) {
		Set<String> conjunto = new HashSet<>(); // cria conjunto
		List<String> lista = new ArrayList<>(); // cria lista
		for (String elem : args) { // adiciona argumentos nas coleções
			conjunto.add(elem);
			lista.add(elem);
		}
		System.out.println("Conj. " + conjunto); // exibe conteúdos
		System.out.println("Lista " + lista);
	}
}
