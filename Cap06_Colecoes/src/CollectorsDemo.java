/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.35
 */
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsDemo {
	public static void main(String[] args) {
		// Obt�m uma lista de funcion�rio
		List<Func> func = FuncList.criaListaFunc();
		// Obt�m a lista de nomes [map+reduce]
		List<String> nomes = func.stream().map(Func::getNome)
				.collect(Collectors.toList());
		System.out.println(nomes);
		// Concatena String com nomes espec�ficos [filter+map+reduce]
		String juncao = func.stream().filter(f -> f.getNome().endsWith("g"))
				.map(Func::getNome).collect(Collectors.joining("##"));
		System.out.println("Nomes: " + juncao);
		// Soma sal�rios dos funcionarios [reduce]
		double total = func.stream().collect(
				Collectors.summingDouble(Func::getSalario));
		System.out.println("Total: " + total);
		// Agrupa funcion�rios por depto [map+reduce]
		Map<Integer, List<Func>> porDepto = func.stream().collect(
				Collectors.groupingBy(Func::getDepto));
		System.out.println(porDepto);
		// Subtotal de salarios por depto [map+reduce]
		Map<Integer, Double> totalPorDepto = func.stream().collect(
				Collectors.groupingBy(Func::getDepto,
						Collectors.summingDouble(Func::getSalario)));
		System.out.println(totalPorDepto);
	}
}
