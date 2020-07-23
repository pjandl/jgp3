/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.29
 */
package jandl.jgp3.engine;

public interface Imprimivel {
	public static final String INICIO = "<inicio>";
	public static final String FIM = "<fim>";
	public abstract void imprimir ();
	public abstract void imprimirNoConsole ();
}
