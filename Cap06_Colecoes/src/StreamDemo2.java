/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.30
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {
	public static void main(String[] args) {
		// Cria lista com valores reais
		List<Double> lista = new ArrayList<>();
		for (int i = 0; i < 180; i += 10) {
			lista.add(Math.sin(Math.toRadians(i)));
		}
		// Uso impl�cito de lista.toString()
		System.out.println(lista);
		// Define um valor limite
		double LIMITE = 0.95;
		// Obt�m stream sequencial adequada
		Stream<Double> stream1 = lista.stream();
		// Aplica filtro com express�o lambda
		Stream<Double> maiores = stream1.filter(e -> e > LIMITE);
		// Uso de forEach com express�o lambda
		System.out.println("Maiores que 0.95:");
		maiores.forEach(e -> System.out.println("\t" + e));
		// Obt�m (novamente) stream sequencial adequada
		Stream<Double> stream2 = lista.stream();
		// Aplica filtro com express�o lambda e adiciona em outra cole��o
		List<Double> menores = stream2.filter(e -> e <= 0.2).collect(
				Collectors.toList());
		// Verifica tipo do objeto retornado por Collectors
		System.out.println(menores.getClass().getName());
		// Uso de forEach em lista com express�o lambda
		System.out.println("Menores que 0.2:");
		menores.forEach(e -> System.out.println("\t" + e));
	}
}
