/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.68
 */
import jandl.jgp3.ui.Circunferencia;

import java.util.Arrays;
import java.util.Comparator;

// Comparador espec�fico para objetos Circunferencia
class CircComparator implements Comparator<Circunferencia> {
	@Override
	public int compare(Circunferencia a, Circunferencia b) {
		return (int) (a.area() - b.area());
	}
}

public class RefMetType {
	public static void main(String[] args) throws Exception {
		// Array de circunferencias
		Circunferencia[] circArray = { new Circunferencia(4.5),
				new Circunferencia(3.5), new Circunferencia(2.5),
				new Circunferencia(1.5) };
		Circunferencia[] copia;
		System.out.println("0:" + Arrays.toString(circArray));
		// Ordena��o do array com comparator espec�fico
		copia = circArray.clone();
		Arrays.sort(copia, new CircComparator());
		System.out.println("1:" + Arrays.toString(copia));
		// Ordena��o do array com express�o lambda
		copia = circArray.clone();
		Arrays.sort(copia, (Circunferencia a, Circunferencia b) -> (int) (a
				.area() - b.area()));
		System.out.println("2:" + Arrays.toString(copia));
		// Ordena��o do array com refer�ncia para m�todo
		copia = circArray.clone();
		Arrays.sort(copia, Circunferencia::comparador);
		System.out.println("3:" + Arrays.toString(copia));
		copia = circArray.clone();
		Arrays.sort(copia, Circunferencia::comparador2);
		System.out.println("4:" + Arrays.toString(copia));
	}
}
