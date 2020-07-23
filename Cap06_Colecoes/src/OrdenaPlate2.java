/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.9
 */
import java.util.*;

public class OrdenaPlate2 {
	public static void main(String a[]) {
		List<Plate> list = OrdenaPlate.criaLista(); // cria lista como em
													// OrdenaPlate
		System.out.println("Original:\n" + list); // exibe lista como criada
		// com método da API, efetua ordenação e re-exibe lista
		Collections.sort(list); // ordenação natural
		System.out.println("O.Natural:\n" + list);
		Collections.sort(list, PlateComparatorFactory.ALTURA); // usa Comparator
		System.out.println("O.Altura:\n" + list);
		Collections.sort(list, PlateComparatorFactory.TIPO); // usa Comparator
		System.out.println("O.Tipo:\n" + list);
	}
}
