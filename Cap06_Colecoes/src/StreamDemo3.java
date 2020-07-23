/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.31
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo3 {
	public static void main(String[] args) {
		// Cria lista com valores inteiros
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			lista.add(i);
		System.out.println(lista); // exibe lista
		// Obtém stream dos quadrados dos elementos
		IntStream quadrados = lista.stream().mapToInt((e) -> e * e);
		quadrados.forEach((e) -> System.out.println("\t" + e));
		// Cria Stream a partir de duplas de valores reais
		Stream<Dupla> streamDuplas = Stream.of(new Dupla(81.5, 1.69),
				new Dupla(52.5, 1.62), new Dupla(64.2, 1.66));
		// Obtém stream dos imc dos elementos com massa maior que 80
		DoubleStream imc = streamDuplas.filter((d) -> d.valor1 > 80)
				.mapToDouble((d) -> d.getValor1() / Math.pow(d.valor2, 2));
		imc.forEach((e) -> System.out.println("[imc] " + e));
	}
}

// classe utilitária
class Dupla {
	public double valor1; // campos
	public double valor2;

	public double getValor1() {
		return valor1;
	} // getter

	public Dupla(double valor1, double valor2) { // construtor
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
}
