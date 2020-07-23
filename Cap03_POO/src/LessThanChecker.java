/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.58
 */
public class LessThanChecker implements Checker<Boolean, Double> {
	@Override
	public Boolean check(Double left, Double right) {
		return left < right; // comparação dos argumentos
	}
}
