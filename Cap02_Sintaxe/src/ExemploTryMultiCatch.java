/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.21
 */
public class ExemploTryMultiCatch {
	public static void main(String args[]) {
		try { // monitora eventuais problemas com multi-catch
				// converte 1o argumento em inteiro
			int j = Integer.parseInt(args[0]);
			while (j >= 0) {
				System.out.println(j);
				j--;
			}
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			// sinaliza falta de argumento ou argumento inválido
			System.out.println("Argumento nao fornecido ou invalido.");
		}
	}
}
