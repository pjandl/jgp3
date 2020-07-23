/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.56
 */
import java.util.*;

public class UsaTipoNum {
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in);
		List<TipoNum<String>> lista = new ArrayList<TipoNum<String>>();
		while (true) {
			System.out.print("Digite um nome (. finaliza): ");
			String nome = sc.next();
			if (nome.equals("."))
				break;
			System.out.print("Digite um numero: ");
			int id = sc.nextInt();
			lista.add(new TipoNum<String>(id, nome));
		}
		sc.close();
		for (TipoNum<String> el : lista) {
			System.out.println("#" + el.getId() + ": " + el.getValor());
		}
	}
}
