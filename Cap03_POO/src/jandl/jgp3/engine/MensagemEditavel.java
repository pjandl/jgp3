/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.33
 */
package jandl.jgp3.engine;

public class MensagemEditavel extends Mensagem implements Imprimivel, Editavel {
	public MensagemEditavel(String conteudo) {
		super(conteudo);
	}

	@Override
	public void imprimir() {
		imprimirNoConsole();
	}

	@Override
	public void imprimirNoConsole() {
		System.out.println(Imprimivel.INICIO + getConteudo() + Imprimivel.FIM);
	}

	@Override
	public void editar(String conteudo) {
		setConteudo(conteudo);
	}
}
