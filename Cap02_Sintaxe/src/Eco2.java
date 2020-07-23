/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.31
 */
public class Eco2 {
	public static void main(String args[]) {
		for (int i = 0; i < args.length; i++) {
			System.out.printf("Argumento #%d: %s ", i, args[i]);
			try { // verifica se arg[i] é inteiro
				int n = Integer.parseInt(args[i]);
				System.out.printf("(inteiro=%d)%n", n);
			} catch (NumberFormatException e1) {
				// se ocorre exceção não é inteiro
				try { // verifica se arg[i] é real
					double d = Double.parseDouble(args[i]);
					System.out.printf("(real=%f)%n", d);
				} catch (NumberFormatException e2) {
					// se ocorre exceção não é real
					System.out.printf("(String=\"%s\")%n", args[i]);
				}
			}
		}
	}
}
