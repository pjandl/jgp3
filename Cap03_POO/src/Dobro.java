/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.4
 */
public class Dobro {
	// armazena n�mero de inst�ncias da classe
	private static int instancias = 0;
	// armazena �ltimo valor usado por metodo dobro(int)
	public int ultimoValor;

	// construtor que atualiza no. de inst�ncias
	public Dobro() {
		instancias++;
	}

	// retorna no. de inst�ncias
	public static int getInstancias() {
		return instancias;
	}

	// calcula o dobro
	public int dobro(int valor) {
		ultimoValor = valor;
		return 2 * valor;
	}
}
