/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.24
 */
public class TestaEquals {
	public static void main(String args[]) {
		Object a = new Object(); // novo objeto a
		Object b = new Object(); // novo objeto b
		Object c = b; // referência c é o mesmo objeto b
		System.out.println("a==b " + a.equals(b) + "\tb==a " + b.equals(a)); // false,
																				// false
		System.out.println("c==b " + c.equals(b) + "\tb==c " + b.equals(c)); // true,
																				// true
		System.out.println("a==c " + a.equals(c) + "\tc==a " + c.equals(a)); // false,
																				// false
		String s = new String("Java");
		String t = "Jandl"; // instanciação implícita de String
		String u = s;
		System.out.println("s==t " + s.equals(t) + "\tt==s " + t.equals(s)); // false,
																				// false
		System.out.println("s==u " + s.equals(u) + "\tu==s " + u.equals(s)); // true,
																				// true
	}
}
