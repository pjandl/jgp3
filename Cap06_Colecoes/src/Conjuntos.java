/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.16
 */
import java.util.*;

public class Conjuntos {
	public static void main(String a[]) {
		HashSet<Integer> A = new HashSet<>(); // instancia conjuntos
		HashSet<Integer> B = new HashSet<>();
		int metade = a.length % 2 == 0 ? a.length / 2 : a.length / 2 + 1;
		for (int i = 0; i < metade; i++) { // adiciona 1a metade dos args em A
			A.add(new Integer(a[i])); // cria objeto wrapper
		}
		for (int i = metade; i < a.length; i++) { // adiciona 2a metade em B
			B.add(new Integer(a[i])); // cria objeto wrapper
		}
		// exibe conjuntos
		System.out.println("A " + A + " Card = " + A.size());
		System.out.println("B " + B + " Card = " + B.size());
		// conjunto copia de A
		HashSet<Integer> copiaA = new HashSet<>(A);
		// testa operações
		System.out.println("A contem B? " + A.containsAll(B));
		A.addAll(B);
		System.out.println("A uniao B? " + A + " Card = " + A.size());
		A = new HashSet<>(copiaA); // como A foi alterado, recria A
		A.retainAll(B);
		System.out.println("A intersec B? " + A + " Card = " + A.size());
		A = new HashSet<>(copiaA); // como A foi alterado, recria A
		A.removeAll(B);
		System.out.println("A diferenca B? " + A + " Card = " + A.size());
	}
}
