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
	// Implementa��o de Consumer por meio de express�o lambda
	static Consumer<String> consumer1 = (e) -> {
		if (e.startsWith("P")) {
			System.out.println("[P] " + e);
		}
	};

	public static void main(String[] args) {
		// Lista de Strings
		List<String> lista = Arrays.asList("Banana", "Laranja", "Pera", "Uva");
		// Aplica��o de refer�ncia para m�todo como Consumer
		lista.forEach(System.out::println);
		// Aplica��o Consumer pr�-definido
		lista.forEach(consumer1);
		// Aplica��o Consumer por meio de express�o lambda
		lista.forEach((e) -> {
			if (e.length() > 5) {
				System.out.printf("%s (%d)\n", e, e.length());
			}
		});
	}
}
