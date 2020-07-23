/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.14
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerializaProduto {
	public static void main(String a[]) {
		//
		if (a.length == 0) {
			System.out.println("uso:\njava SerializaProduto <nomeArquivo>");
			System.exit(-1);
		}
		//
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(a[0]));) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			System.out.println("Gerando conteudo...");
			Produto p = new Produto("Nome do Produto", 123456);
			oos.writeObject(p);
			System.out.println(p);
			Date d = new Date();
			oos.writeObject(d);
			System.out.println(d);
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e);
		} // oos.close() implicito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
