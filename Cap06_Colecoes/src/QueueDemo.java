/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.22
 */
import java.util.*;

public class QueueDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("Indique classe tipo Queue<E>: ");
		String className = sc.next(); // l� nome de classe
		sc.close();
		Queue<Integer> fila = null; // declara vari�vel Queue<Integer>
		try {
			Class cl = Class.forName(className); // carrega classe indicada
			Object obj = cl.newInstance(); // instancia classe indicada
			if (obj instanceof Queue) { // verifica se Queue
				fila = (Queue<Integer>) obj; // efetua coer��o
			} else {
				System.err.println("Classe dada precisa implementar Queue<E>.");
				System.exit(-1);
			}
		} catch (Exception e) { // exibe ocorr�ncia de erros
			System.err.println("Classe nao encontrada ou nao instanciavel");
			System.exit(-1);
		}
		System.out.println("Fila " + fila); // exibe conte�do da fila
		insereElementos(fila, 5); // insere novos elementos
		System.out.println("Fila " + fila); // exibe conte�do da fila
		removeElementos(fila.iterator()); // remove elements
		System.out.println("Fila " + fila); // exibe conte�do da fila
	}

	// insere elementos Integer
	public static void insereElementos(Queue<Integer> fila, int n) {
		for (int i = 0; i < n; i++) {
			fila.offer(i);
		}
	}

	// remove elementos Integer pares
	public static void removeElementos(Iterator<Integer> i) {
		while (i.hasNext()) { // in�cio->fim
			if (i.next() % 2 == 0) { // obt�m e testa elemento
				i.remove(); // remove apenas Integer pares
			}
		}
	}
}
