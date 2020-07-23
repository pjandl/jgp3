/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.61
 */
public class CalculavelImpl implements Calculavel {
	@Override
	public double calcular(double a, double b) {
		return 0.4 * a + 0.6 * b;
	}
}
