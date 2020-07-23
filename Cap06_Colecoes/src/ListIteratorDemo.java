/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.20
 */
import java.util.*;

public class ListIteratorDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("Indique classe tipo List<E>: ");
		String className = sc.next(); // l� nome de classe
		sc.close();
		List<Number> lista = null; // declara vari�vel tipo List<Number>
		try {
			Class cl = Class.forName(className); // carrega classe indicada
			Object obj = cl.newInstance(); // instancia classe indicada
			if (obj instanceof List) { // verifica se � tipo List<E>
				lista = (List<Number>) obj; // efetua coer��o
			} else {
				System.err.println("Classe dada precisa implementar List<E>.");
				System.exit(-1);
			}
		} catch (Exception e) { // exibe ocorr�ncia de erros
			System.err.println("Classe nao encontrada ou nao instanciavel");
			System.exit(-1);
		}
		// adiciona elementos Integer na lista
		for (int i = 0; i < 4; i++) {
			lista.add(new Integer(i));
		}
		navegaInicioAoFim(lista.listIterator()); // navega lista in�cio-->fim
		navegaFimAoInicio(lista.listIterator(lista.size())); // fim-->in�cio
		insereElementos(lista.listIterator()); // insere novos elementos
		navegaInicioAoFim(lista.listIterator()); // navega lista in�cio-->fim
		navegaFimAoInicio(lista.listIterator(lista.size())); // fim-->in�cio
		removeElementos(lista.listIterator()); // remove elementos
		navegaInicioAoFim(lista.listIterator()); // navega lista in�cio-->fim
		navegaFimAoInicio(lista.listIterator(lista.size())); // fim-->in�cio
	}

	// insere elementos Double ap�s existentes
	public static void insereElementos(ListIterator<Number> li) {
		while (li.hasNext()) { // in�cio->fim
			li.next(); // obt�m elemento
			li.add(new Double(li.nextIndex() / 2.0)); // insere Double
		}
	}

	// remove elementos Integer ap�s existentes
	public static void removeElementos(ListIterator<Number> li) {
		while (li.hasNext()) { // in�cio->fim
			if (li.next() instanceof Integer) { // obt�m e testa elemento
				li.remove(); // remove apenas Integer
			}
		}
	}

	// navega lista do in�cio ao fim exibindo elementos
	public static void navegaInicioAoFim(ListIterator<Number> li) {
		System.out.print("I [ ");
		if (li.hasNext()) {
			System.out.print(li.next());
		}
		while (li.hasNext()) {
			System.out.print(", " + li.next());
		}
		System.out.println(" ] F");
	}

	// navega lista do final ao in�cio exibindo elementos
	public static void navegaFimAoInicio(ListIterator<Number> li) {
		System.out.print("F [ ");
		if (li.hasPrevious()) {
			System.out.print(li.previous());
		}
		while (li.hasPrevious()) {
			System.out.print(", " + li.previous());
		}
		System.out.println(" ] I");
	}
}
