/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.4
 */
public class Ordenacao { // ordena��o por sele��o direta
	public static <T extends Comparable<T>> void sort(T array[]) {
		for (int j = array.length - 1; j > 0; j--) {
			int pos = j; // toma posi��o e valor do pivot como maior
			T maior = array[pos];
			for (int i = j - 1; i >= 0; i--) { // percorre array
				if (array[i].compareTo(maior) > 0) { // compara elementos
					pos = i; // armazena posi��o e valor do maior
					maior = array[pos];
				}
			}
			array[pos] = array[j]; // troca maior com pivot
			array[j] = maior;
		}
	}

	public static <T> String toString(T array[]) {
		StringBuffer sb = new StringBuffer("[ ");
		for (T elem : array) {
			sb.append(elem);
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String a[]) {
		Integer dados[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("dados  (antes)" + toString(dados));
		sort(dados); // dados e um array cujo tipo implementa Comparable
		System.out.println("dados (depois)" + toString(dados));
	}
}
