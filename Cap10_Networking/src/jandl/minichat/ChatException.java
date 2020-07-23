/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.14
 */
package jandl.minichat;

@SuppressWarnings("serial")
public class ChatException extends Exception {
	public ChatException(String msg) {
		super(msg);
	}

	public ChatException(Throwable cause) {
		super(cause);
	}

	public ChatException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
