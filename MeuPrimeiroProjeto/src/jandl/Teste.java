/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo A.2
 */
package jandl;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		if (args.length == 0) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite um (ou mais) argumentos:");
			String n = sc.nextLine();
			sc.close();
			System.out.println("Eco > " + n);
		} else {
			System.out.print("Eco > ");
			for(int i=0; i<args.length; i++) {
				System.out.print(args[0] + " ");
			}
			System.out.println();
		}
	}

}
