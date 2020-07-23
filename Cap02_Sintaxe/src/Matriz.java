/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.29
 */
public class Matriz {
	public static void main(String args[]) {
		double m[][] = new double[3][4]; // declara e aloca matriz 3x4
		for (int l = 0; l < m.length; l++) { // preenche matriz
			for (int c = 0; c < m[l].length; c++) {
				m[l][c] = l * m[l].length + c;
			}
		}
		for (int l = 0; l < m.length; l++) { // exibe matriz
			for (int c = 0; c < m[l].length; c++) {
				System.out.print(m[l][c] + "\t");
			}
			System.out.println();
		}
	}
}
