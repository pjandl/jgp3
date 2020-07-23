/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.32
 */
package jandl.jgp3.engine;

public class MensagemImprimivel extends Mensagem implements Imprimivel {
	public MensagemImprimivel(String conteudo) {
		super(conteudo);
	}

	@Override
	public void imprimir() {
		imprimirNoConsole();
	}

	@Override
	public void imprimirNoConsole() {
		System.out.println(Imprimivel.INICIO);
		System.out.println(getConteudo());
		System.out.println(Imprimivel.FIM);
	}
}
