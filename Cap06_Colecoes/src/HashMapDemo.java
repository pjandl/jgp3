/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.23
 */
import java.util.*;

public class HashMapDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<>();
		int counter = 0;
		String nome = "";
		while (!nome.equals("*")) {
			System.out.print("Digite um nome ('*' finaliza): ");
			nome = sc.nextLine();
			if (nome.equals("*"))
				continue;
			hm.put(nome, counter++);
			System.out.println(hm);
		}
		do {
			System.out.print("Digite um nome para excluir ('*' finaliza): ");
			nome = sc.nextLine();
			if (nome.equals("*"))
				continue;
			if (hm.containsKey(nome)) {
				hm.remove(nome);
				System.out.println("Nome removido.\n" + hm);
			} else {
				System.out.println("Nome nao encontrado.\n" + hm);
			}
		} while (!nome.equals("*"));
		sc.close();
	}
}
