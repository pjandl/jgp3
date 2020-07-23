/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.3
 */
import java.io.*;

public class LeituraTexto {
	public static void main(String a[]) {
		if (a.length == 0) { // checa argumento com nome do arquivo
			System.out.println("uso:\njava LeituraText <nomeArquivo>");
			System.exit(-1);
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(a[0]));
			System.out.println("Arquivo '" + a[0] + "' aberto.");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		}
		try {
			String line;
			System.out.println("--- Conteudo ---");
			// leitura do stream
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("--- Conteudo ---");
			br.close();
			System.out.println("Arquivo '" + a[0] + "' fechado.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
