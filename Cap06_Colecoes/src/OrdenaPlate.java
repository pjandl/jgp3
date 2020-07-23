/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.7
 */
import java.util.*;

public class OrdenaPlate {
	public static void main(String a[]) {
		List<Plate> list = criaLista(); // cria lista
		System.out.println("Original:\n" + list); // exibe lista como criada
		Collections.sort(list); // ordena com metodo da API
		System.out.println("Ordenada:\n" + list); // exibe lista apos ordenação
	}

	public static List<Plate> criaLista() {
		List<Plate> list = new ArrayList<>(); // cria lista
		list.add(new Plate(10.0, 22.5, "placa 5")); // adiciona objetos
													// desordenados
		list.add(new Plate(10.0, 22.5, "placa 4"));
		list.add(new Plate(15.0, 10.0, "placa 3"));
		list.add(new Plate(10.0, 15.0, "placa 2"));
		list.add(new Plate(7.5, 30.0, "placa 1"));
		return list;
	}
}
