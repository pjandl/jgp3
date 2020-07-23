/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.17
 */
public class SemImportStatic {
	public static void main(String args[]) {
		double raio = Double.parseDouble(args[0]);
		double perim = 2 * Math.PI * raio; // uso da constante qualificada
		System.out.println("raio = " + raio + ", perim = " + perim);
	}
}
