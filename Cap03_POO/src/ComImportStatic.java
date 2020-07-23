/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.18
 */
import static java.lang.Math.*; // observe uso do * após nome da classe

public class ComImportStatic {
	public static void main(String args[]) {
		double raio = Double.parseDouble(args[0]);
		double perim = 2 * PI * raio; // uso abreviado da constante
		System.out.println("raio = " + raio + ", perim = " + perim);
	}
}
