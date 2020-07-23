/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.41
 */
package jandl.jgp3;

import jandl.jgp3.ui.*;

public class TestaFormas {
	public static void main(String a[]) {
		Circunferencia c = new Circunferencia(1.5);
		System.out.println("areaCirc = " + c.area());
		Retangulo r = new Retangulo(2.5, 4.0);
		System.out.println("areaRet = " + r.area());
		Forma formas[] = new Forma[3];
		formas[0] = c;
		formas[1] = r;
		formas[2] = new Triangulo(1.0, 2.0, 2.0);
		for (int i = 0; i < formas.length; i++) {
			System.out.println(formas[i]);
			System.out.println("area = " + formas[i].area());
		}
	}
}
