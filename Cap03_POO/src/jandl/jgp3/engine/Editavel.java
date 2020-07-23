/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.30/3.35
 */
package jandl.jgp3.engine;

public interface Editavel {
	long chave = 0xABDCEF0;

	void editar(String conteudo);

	default void limpar() { // método default
		editar("");
	}
}
