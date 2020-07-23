/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.1
 */
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestaIterable {
	// Implementação de Consumer por meio de expressão lambda
	static Consumer<String> consumer1 = (e) -> {
		if (e.startsWith("P")) {
			System.out.println("[P] " + e);
		}
	};

	public static void main(String[] args) {
		// Lista de Strings
		List<String> lista = Arrays.asList("Banana", "Laranja", "Pera", "Uva");
		// Aplicação de referência para método como Consumer
		lista.forEach(System.out::println);
		// Aplicação Consumer pré-definido
		lista.forEach(consumer1);
		// Aplicação Consumer por meio de expressão lambda
		lista.forEach((e) -> {
			if (e.length() > 5) {
				System.out.printf("%s (%d)\n", e, e.length());
			}
		});
	}
}
