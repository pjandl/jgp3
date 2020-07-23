/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.54
 */
import java.util.*;

public class ComGen { // Classe usa gen�ricos
	public static void main(String a[]) {
		// cria lista com indica��o de par�metro de tipo
		List<Integer> num = new ArrayList<Integer>();
		num.add(new Integer(10)); // adiciona Integer
		num.add(20); // auto-boxing
		// opera��o seguinte geraria erro na compila��o
		// num.add(new String("qualquer coisa"));
		int tot = 0;
		tot += num.get(0).intValue(); // coer��o n�o � necess�ria
		tot += num.get(1); // autounboxing
		System.out.println("tot=" + tot);
	}
}
