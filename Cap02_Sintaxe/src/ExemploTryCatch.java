/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.19
 */
public class ExemploTryCatch {
	public static void main(String args[]) {
		try { // monitora eventuais problemas
			// converter 1o argumento em inteiro
			int j = Integer.parseInt(args[0]);
			while (j >= 0) {
				System.out.println(j);
				j--;
			}
		} catch (Exception e) { // sinaliza problemas encontrados
			System.out.println("Argumento nao foi dado ou nao e inteiro.");
		}
	}
}
