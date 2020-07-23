/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.42
 */
package jandl.jgp3;

import jandl.jgp3.ui.*;

public class InstanceOf {
	public static void main(String a[]) {
		Object obj = new Triangulo(1.5, 1.5, 2.0); // cria triângulo
		System.out.println(obj); // exibe info
		// verifica de quem obj e instancia...
		System.out.printf("%s instancia de Triangulo.\n",
				obj instanceof Triangulo ? "E'" : "Nao e'");
		System.out.printf("%s instancia de Retangulo.\n",
				obj instanceof Retangulo ? "E'" : "Nao e'");
		System.out.printf("%s instancia de Forma.\n",
				obj instanceof Forma ? "E'" : "Nao e'");
		System.out.printf("%s instancia de Object.\n",
				obj instanceof Object ? "E'" : "Nao e'");
		System.out.printf("%s instancia de Runnable.\n",
				obj instanceof Runnable ? "E'" : "Nao e'");
	}
}
