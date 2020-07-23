/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.54
 */
import java.util.*;

public class ComGen { // Classe usa genéricos
	public static void main(String a[]) {
		// cria lista com indicação de parâmetro de tipo
		List<Integer> num = new ArrayList<Integer>();
		num.add(new Integer(10)); // adiciona Integer
		num.add(20); // auto-boxing
		// operação seguinte geraria erro na compilação
		// num.add(new String("qualquer coisa"));
		int tot = 0;
		tot += num.get(0).intValue(); // coerção não é necessária
		tot += num.get(1); // autounboxing
		System.out.println("tot=" + tot);
	}
}
