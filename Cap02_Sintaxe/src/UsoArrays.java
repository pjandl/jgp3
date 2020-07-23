/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.28
 */
import java.util.Arrays;
import java.util.Scanner;

public class UsoArrays {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("No de elementos ? "); // l� no. de elementos
		int tamanho = sc.nextInt();
		System.out.print("Preenchimento real? "); // l� preenchimento
		double valor = sc.nextDouble();
		double arranjo1[] = new double[tamanho]; // aloca arranjo
		Arrays.fill(arranjo1, valor); // preenche arranjo
		System.out.println(Arrays.toString(arranjo1)); // exibe arranjo
		// l� posi��es inicial e final da c�pia
		System.out.print("Posicao inicial da copia? ");
		int de = sc.nextInt();
		System.out.print("Posicao final da copia? ");
		int para = sc.nextInt();
		// efetua c�pia parcial e integral
		double arranjo2[] = Arrays.copyOfRange(arranjo1, de, para);
		double arranjo3[] = Arrays.copyOf(arranjo1, arranjo1.length);
		// exibe novos arrays
		System.out.println("Copia parcial:\n" + Arrays.toString(arranjo2));
		System.out.println("Copia total:\n" + Arrays.toString(arranjo3));
		sc.close(); // fecha console
	}
}
