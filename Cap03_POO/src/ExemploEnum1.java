/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 3.48
 */
public class ExemploEnum1 {
	public enum Opcoes {
		COMPACTAR, DESCOMPACTAR
	};

	public static void main(String a[]) {
		for (Opcoes opcao : Opcoes.values()) { // for avançado
			System.out.println(opcao);
		}
	}
}
