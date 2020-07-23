/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.5
 */
import java.util.*;

public class TesteSort {
	public static void main(String a[]) {
		String data[] = new String[10000]; // define array com 10000 elementos
		for (int i = data.length - 1; i >= 0; i--) {
			data[i] = "" + (10000 - i); // valores 10000 a 1
		}
		String xtra[] = new String[data.length]; // array extra
		long inicio, fim; // marcadores de tempo
		System.arraycopy(data, 0, xtra, 0, data.length); // copia array extra
		inicio = System.currentTimeMillis(); // marca início da ordenação
		Ordenacao.sort(xtra); // usa classe Ordenacao
		fim = System.currentTimeMillis(); // marca fim da ordenação
		System.out.println("Tempo Ordenacao.sort = " + (fim - inicio));
		System.arraycopy(data, 0, xtra, 0, data.length); // copia array extra
		inicio = System.currentTimeMillis(); // marca início da ordenação
		Arrays.sort(xtra); // usa classe java.util.Arrays
		fim = System.currentTimeMillis(); // marca fim da ordenação
		System.out.println("Tempo Arrays.sort = " + (fim - inicio));
		List<String> lista = Arrays.asList(data); // cria lista a partir do
													// array
		inicio = System.currentTimeMillis(); // marca início da ordenação
		Collections.sort(lista); // usa classe java.util.Collections
		fim = System.currentTimeMillis(); // marca fim da ordenação
		System.out.println("Tempo Collections.sort = " + (fim - inicio));
	}
}
