/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.7
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JCopy {
	public static void copyFile(String origem, String destino) {
		// abre streams de entrada e saida com ARM
		try (BufferedInputStream orig = new BufferedInputStream(
				new FileInputStream(origem));
				BufferedOutputStream dest = new BufferedOutputStream(
						new FileOutputStream(destino))) {
			int disp; // no. bytes disponiveis
			while ((disp = orig.available()) > 0) { // se dados disponiveis
				byte dados[] = new byte[disp]; // cria array para dados
				orig.read(dados, 0, disp); // le todos os dados
				dest.write(dados, 0, disp); // grava todos os dados
			}
			dest.flush(); // garante gravacao
		} catch (IOException e) { // em caso de erro
			System.out.println("Copia nao foi possivel.");
			e.printStackTrace();
		} // orig.close() e dest.close() implicitos
	}

	//
	public static void main(String a[]) {
		// verifica se foram recebidos 2 argumentos obrigatorios
		if (a.length == 2) {
			System.out.print("Copiando de '" + a[0] + "' para '" + a[1]
					+ "'...");
			copyFile(a[0], a[1]);
			System.out.println("OK");
		} else {
			System.out.println("Uso:> JCopy arqOrigem arqDestino");
		}
	}
	//
}
