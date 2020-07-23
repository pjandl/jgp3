/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.32
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamDemo4 {
	public static void main(String[] args) {
		// Cria lista com valores reais
		List<Double> listaX = new ArrayList<>();
		for (double x = 0; x < 10; x += 0.5) {
			listaX.add(x);
		}
		System.out.println("X:" + listaX);
		// (1) Totaliza��o via navega��o com iterator
		Iterator<Double> iterator = listaX.iterator();
		double totalX = 0;
		while (iterator.hasNext()) {
			totalX += iterator.next();
		}
		System.out.println("Total(X):" + totalX);
		// (2) Totaliza��o via navega��o com forEach
		Somador somador = new Somador();
		listaX.forEach(x -> somador.add(x));
		System.out.println("Total(X):" + somador.getTotal());
		// (3) Totaliza��o via redu��o
		totalX = listaX.stream().mapToDouble(e -> e) // mapeamento
				.sum(); // redu��o
		System.out.println("Total(X):" + totalX);
		// Mapeamento restrito de X em Y
		List<Double> listaY = listaX.stream().filter(x -> x > 3 && x < 7) // filtragem
				.map(x -> x * x - 10 * x + 24) // mapeamento
				.collect(Collectors.toList()); // coleta
		System.out.println("Yrestrito:" + listaY);
		// Contagem e m�ximo via redu��o pr�-definida
		System.out.printf("Num(Yrestrito):%d valores\n", listaY.stream()
				.count()); // redu��o
		Optional<Double> maxY = listaY.stream().max(Double::compare); // redu��o
		System.out.println("Max(Yrestrito):" + maxY.get());
		// (4) Totaliza��o via redu��o definida
		double totalY = listaY.stream().reduce(0.0, (acc, e) -> acc + e); // redu��o
		System.out.println("Total(Yrestrito):" + totalY);
	}
}

// classe utilit�ria
class Somador {
	private double total;

	public Somador() {
		preset(0);
	}

	public Somador(double v) {
		preset(v);
	}

	public void add(double v) {
		total += v;
	}

	public double getTotal() {
		return total;
	}

	protected void preset(double v) {
		total = v;
	}

	public void reset() {
		preset(0);
	}
}
