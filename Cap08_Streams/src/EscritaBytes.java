/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.6
 */
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscritaBytes {
	public static void main(String a[]) {
		//
		// checa argumento obrigatorio com nome do arquivo
		if (a.length == 0) {
			System.out.println("uso:\njava EscritaBytes <nomeArquivo> [quant]");
			System.exit(-1);
		}
		//
		// uso do arquivo com ARM
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(
				a[0]))) {
			System.out.println("Arquivo '" + a[0] + "' aberto.");
			// converte quantidade dada pelo usuario ou usa default
			int quant = 10; // valor default
			try {
				quant = Integer.parseInt(a[1]);
			} catch (Exception e) {
				System.out.println("Usando quantidade default 10");
			}
			// gera quantidade indicada de valores aleatorios
			System.out.println("Gerando conteudo...");
			for (int i = 0; i < quant; i++) {
				double aux = Math.random();
				dos.writeInt(i);
				dos.writeDouble(aux);
				System.out.println("#" + i + " : " + aux);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e);
		} // dos.close() implicito
		System.out.println("Arquivo '" + a[0] + "' fechado.");
	}
}
