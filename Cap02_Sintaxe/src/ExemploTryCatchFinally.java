/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.22
 */
public class ExemploTryCatchFinally {
	public static void main(String args[]) {
		int j = 5; // valor default
		try { // monitora convers�o do argumento
			j = Integer.parseInt(args[0]);
		} catch (Exception e) { // sinaliza problema com convers�o
			System.out
					.println("Argumento invalido ou ausente. Usando default.");
		} finally { // execucao do la�o com valor informado ou default
			while (j >= 0) {
				System.out.println(j);
				j--;
			}
		}
	}
}
