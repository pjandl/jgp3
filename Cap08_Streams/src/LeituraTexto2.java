/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.4
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;

public class LeituraTexto2 {
	public static void main(String a[]) {
		if (a.length == 0) { // checa argumento com nome do arquivo
			System.out.println("uso:\njava LeituraBytes2 <nomeArquivo>");
			System.exit(-1);
		}
		try (LineNumberReader lnr = new LineNumberReader(new FileReader(a[0]))) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			String line;
			System.out.println("--- Conteudo ---");
			// leitura do stream
			while ((line = lnr.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("--- Conteudo ---");
			System.out.println("Linhas lidas: " + lnr.getLineNumber());
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (Exception e) {
			System.out.println(e);
		} // br.close() implícito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
