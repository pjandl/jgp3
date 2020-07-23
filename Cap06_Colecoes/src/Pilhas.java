/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.27
 */
import java.util.*;

public class Pilhas {
	private static String elements[] = { "Ni", "Cd", "Li" };

	public static void main(String a[]) {
		// coleções que podem ser usadas como pilhas
		List<String> arraylist = new ArrayList<>();
		Deque<String> arraydeque = new ArrayDeque<>();
		List<String> vector = new Vector<>();
		List<String> stack = new Stack<>();
		System.out.println("Estado inicial das pilhas");
		System.out.printf("AL %12s | AD %12s | Ve %12s | St %12s\n", arraylist,
				arraydeque, vector, stack);
		System.out.println("Incluindo elementos nas pilhas");
		for (int i = 0; i < elements.length; i++) {
			arraylist.add(0, elements[i]);
			arraydeque.addFirst(elements[i]);
			vector.add(0, elements[i]);
			stack.add(0, elements[i]);
			System.out.printf("AL %12s | AD %12s | Ve %12s | St %12s\n",
					arraylist, arraydeque, vector, stack);
		}
		System.out.println("Esvaziando pilhas");
		while (!arraylist.isEmpty() && !arraydeque.isEmpty()
				&& !vector.isEmpty() && !stack.isEmpty()) {
			arraylist.remove(0);
			arraydeque.pollFirst();
			vector.remove(0);
			stack.remove(0);
			System.out.printf("AL %12s | AD %12s | Ve %12s | St %12s\n",
					arraylist, arraydeque, vector, stack);
		}
	}
}
