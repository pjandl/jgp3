/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.12
 */
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo2 {
	public static void main(String a[]) {
		String lp[] = { "Fortran", "Cobol", "Pascal", "C", "Basic", "Algol",
				"C++", "ObjectPascal", "Java", "PHP", "Perl", "Simula",
				"Eiffel", "Lua" };
		TreeSet<String> ts = new TreeSet<>(Arrays.asList(lp));
		System.out.println("LPs: " + ts);
		SortedSet<String> ss1 = ts.subSet("C", "Java"); // intervalo [C,Java)
		System.out.println("LPs entre [C,Java): " + ss1.size() + " " + ss1);
		SortedSet<String> ss2 = ts.subSet("C", "Java\0"); // intervalo [C,Java]
		System.out.println("LPs entre [C,Java]: " + ss2.size() + " " + ss2);
		SortedSet<String> ss3 = ts.subSet("C\0", "Java\0"); // intervalo
															// (C,Java]
		System.out.println("LPs entre (C,Java]: " + ss3.size() + " " + ss3);
		System.out.println("Remove LP 'Eiffel'");
		ts.remove("Eiffel"); // remove um elemento
		System.out.println("LPs: " + ts); // efeito no conj. original e subconj.
		System.out.println("LPs entre [C,Java): " + ss1.size() + " " + ss1);
	}
}
