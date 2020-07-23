/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.31
 */
package jandl.jgp3.engine;

public abstract class Mensagem {
	private String conteudo;

	public Mensagem(String conteudo) {
		setConteudo(conteudo);
	}

	public String getConteudo() {
		return conteudo;
	}

	protected void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
