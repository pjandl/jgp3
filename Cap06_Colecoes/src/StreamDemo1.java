/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.29
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo1 {
	public static void main(String[] args) {
		// Cria lista com valores reais
		List<Integer> lista = new ArrayList<>();
		for (int i = 1; i <= 15; i++) {
			lista.add((int) Math.pow(i, 2));
		}
		// Exibi��o da lista por meio de toString (impl�cito)
		System.out.println(lista);
		// Obt�m stream sequencial de tipo adequado
		Stream<Integer> stream1 = lista.stream();
		// Uso de forEach em stream com express�o lambda
		stream1.forEach(e -> System.out.print(e + ", "));
		System.out.println();
		// Alternativa compacta
		lista.forEach(e -> System.out.printf("%d; ", e));
		System.out.println();
	}
}