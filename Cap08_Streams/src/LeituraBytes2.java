/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.2
 */
import java.io.*;

public class LeituraBytes2 {
	public static void main(String a[]) {
		if (a.length == 0) { // checa argumento com nome do arquivo
			System.out.println("uso:\njava LeituraBytes2 <nomeArquivo>");
			System.exit(-1);
		}
		// abertura do arquivo para leitura de bytes com ARM
		try (DataInputStream dis = new DataInputStream(
				new FileInputStream(a[0]))) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			// efetua a leitura do arquivo enquanto existirem dados
			System.out.println("--- Conteudo ---");
			while (dis.available() > 0) {
				int i = dis.readInt(); // leitura do stream
				double aux = dis.readDouble();
				System.out.println("#" + i + " : " + aux);
			}
			System.out.println("--- Conteudo ---");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e);
		} // dis.close() implícito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
