/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.13
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Produto implements Serializable {
	String nome;
	int codigo;

	public Produto(String n, int c) {
		nome = n;
		codigo = c;
	}

	public String toString() {
		return "Produto[nome=" + nome + ", codigo=" + codigo + "]";
	}
}
