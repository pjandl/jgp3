/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.49
 */
public enum Opcoes {
	COMPACTAR("Compactacao", 0), // regra (i)
	DESCOMPACTAR("Descompactacao", 1);
	private final String nome; // regra (ii)
	private final int valor;

	Opcoes(String n, int v) { // regra (iii)
		nome = n;
		valor = v;
	}

	public int getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}

	public String toString() {
		return nome + "(" + valor + ")";
	}
}
