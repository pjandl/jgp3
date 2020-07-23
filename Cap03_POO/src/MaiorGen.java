/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.52
 */
import java.util.Arrays;

public class MaiorGen {
	public static void main(String a[]) {
		Integer aI[] = { -2, 4, 7, 10, 8, 5, 1, -1 };
		Double aD[] = { -2.6, 4.4, 7.8, 9.5, 8.6, 5.7, 1.3, -1.9 };
		System.out.println("Maior Integer: " + maior(aI) + " de "
				+ Arrays.toString(aI));
		System.out.println("Maior Double : " + maior(aD) + " de "
				+ Arrays.toString(aD));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable> T maior(T array[]) {
		T maior = array[0];
		for (T elemento : array)
			if (maior.compareTo(elemento) < 0)
				maior = elemento;
		return maior;
	}
}
