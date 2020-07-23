/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.4
 */
public class Dobro {
	// armazena número de instâncias da classe
	private static int instancias = 0;
	// armazena último valor usado por metodo dobro(int)
	public int ultimoValor;

	// construtor que atualiza no. de instâncias
	public Dobro() {
		instancias++;
	}

	// retorna no. de instâncias
	public static int getInstancias() {
		return instancias;
	}

	// calcula o dobro
	public int dobro(int valor) {
		ultimoValor = valor;
		return 2 * valor;
	}
}
