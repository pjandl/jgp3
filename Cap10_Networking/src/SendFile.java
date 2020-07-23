/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.4
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SendFile {
	public static void main(String a[]) {
		//
		if (a.length == 0) {
			System.out.println("Uso:\nSendFile <endIP> <arquivo>");
			System.exit(0);
		}
		//
		System.out.println("[Conectando Servidor...]");
		try (Socket clienteC = new Socket(a[0], 1234);
				Socket clienteD = new Socket(a[0], 1235)) {
			System.out.printf("[Conexao aceita de %s]\n", clienteC
					.getInetAddress().toString());
			// obtencao dos dados do arquivo e sua abertura
			File file = new File(a[1]);
			System.out.printf("[Enviando arquivo '%s']\n", file.getName());
			BufferedInputStream arquivo = new BufferedInputStream(
					new FileInputStream(file));
			// abre canal controle (modo texto)
			PrintWriter canalC = new PrintWriter(clienteC.getOutputStream(),
					true);
			long sent = 0, total = file.length();
			System.out.printf("[%d bytes no arquivo]\n", total);
			canalC.println(file.getName()); // envio dos dados do arquivo
			canalC.println(total + "");
			canalC.close(); // fecha canal modo texto
			// abertura canal binario
			BufferedOutputStream canalD = new BufferedOutputStream(
					clienteD.getOutputStream());
			while (sent + 256 < total) {
				byte dados[] = new byte[256]; // cria array para bloco
				arquivo.read(dados, 0, 256); // le dados para bloco
				canalD.write(dados, 0, 256); // envia bloco
				sent += 256; // totaliza blocos
			}
			if (sent < total) {
				int fim = (int) (total - sent);
				byte dados[] = new byte[fim]; // cria array para bloco final
				arquivo.read(dados, 0, fim); // le dados para bloco final
				canalD.write(dados, 0, fim); // envia bloco final
			}
			canalD.close(); // fecha canal binario
			arquivo.close(); // fecha arquivo
			System.out.printf("[%d bytes enviados]\n", total);
		} catch (IOException e) {
			System.out.println("Problemas no envio");
			e.printStackTrace();
		} // fecha conexao com close() implicito de clienteC e clienteD
		System.out.println("[Conexao encerrada]");
	}
}
