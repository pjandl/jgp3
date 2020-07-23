/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.34
 */
import java.util.ArrayList;

public class FuncList {
	public static ArrayList<Func> criaListaFunc() {
		ArrayList<Func> lista = new ArrayList<>();
		lista.add(new Func("John Backus", 1, 1954));
		lista.add(new Func("Niklaus Wirth", 2, 1970));
		lista.add(new Func("Dennis Ritchie", 3, 1972));
		lista.add(new Func("Ken Thompson", 3, 1972));
		lista.add(new Func("Bjorne Stroustrup", 4, 1983));
		lista.add(new Func("James Gosling", 5, 1991));
		lista.add(new Func("Anders Hejlsberg", 6, 1999));
		return lista;
	}
}
