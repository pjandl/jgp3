/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.6
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiveFileShutdown {
	public static void main(String[] a) throws IOException {
		System.out.println("[Conectando Servidor...]");
		Socket controle = new Socket(a[0], 1234);
		Socket dados = new Socket(a[0], 1235);
		// abre canal controle (modo texto)
		PrintWriter saidaTexto = new PrintWriter(controle.getOutputStream(),
				true);
		System.out.println("[Requisitando shutdown]");
		saidaTexto.println("@shutdown"); // envia comando de encerramento
		saidaTexto.close();// fecha canais e conexões
		controle.close();
		dados.close();
		System.out.println("[ok]");
	}
}
