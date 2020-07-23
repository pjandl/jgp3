/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.15
 */
import java.io.*;
import java.util.*;

public class DesserializaProduto {
	public static void main(String a[]) {
		//
		if (a.length == 0) {
			System.out.println("uso:\njava DesserializaProduto <nomeArquivo>");
			System.exit(-1);
		}
		//
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				a[0]));) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			System.out.println("--- Conteudo ---");
			Produto p = (Produto) ois.readObject();
			System.out.println(p);
			Date d = (Date) ois.readObject();
			System.out.println(d);
			System.out.println("--- Conteudo ---");
		} catch (FileNotFoundException | ClassNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e);
		} // ois.close() implicito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
