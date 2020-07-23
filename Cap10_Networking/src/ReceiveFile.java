/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.5
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveFile {
	public static void main(String a[]) {
		System.out.println("[Criando Servidor...]");
		try (ServerSocket servidorC = new ServerSocket(1234);
				ServerSocket servidorD = new ServerSocket(1235);) {
			System.out.println("[Servidor operando nas portas 1234/1235]");
			while (true) {
				System.out.println("[Esperando conexao...]");
				try (Socket clienteC = servidorC.accept();
						Socket clienteD = servidorD.accept();) {
					System.out.printf("[Conexao aberta de %s]\n", clienteC
							.getInetAddress().toString());
					// abre canal de controle (modo texto)
					BufferedReader canalC = new BufferedReader(
							new InputStreamReader(clienteC.getInputStream()));
					// recebe dados do arquivo a ser transferido
					String nomeArq = canalC.readLine() + ".rcv";
					if (nomeArq.startsWith("@shutdown")) { // verifica shutdown
						System.out.println("[@shutdown]");
						break;
					}
					System.out.printf("[Recebendo arquivo '%s']\n", nomeArq);
					long recv = 0;
					long total = Integer.parseInt(canalC.readLine());
					canalC.close(); // fecha canal controle
					// abre canal de dados (modo binario)
					BufferedInputStream canalD = new BufferedInputStream(
							clienteD.getInputStream());
					// abre arquivo para dados transferidos
					BufferedOutputStream arquivo = new BufferedOutputStream(
							new FileOutputStream(nomeArq));
					while (recv + 256 < total) {
						// cria array para bloco
						byte dados[] = new byte[256];
						canalD.read(dados, 0, 256); // le bloco
						arquivo.write(dados, 0, 256); // grava bloco
						recv += 256; // totaliza blocos
					}
					if (recv < total) {
						int fim = (int) (total - recv);
						// cria array para bloco final
						byte dados[] = new byte[fim];
						canalD.read(dados, 0, fim); // le bloco final
						arquivo.write(dados, 0, fim); // grava bloco final
					}
					arquivo.close(); // fecha arquivo
					canalD.close(); // fecha canal binario
					System.out.println("[" + total + " bytes recebidos]");
				} catch (IOException e) {
					System.out.println("Problemas na recepcao");
					e.printStackTrace();
				} // fecha conexao com close() implicito de clienteC e clienteD
				System.out.println("[Conexao encerrada]");
			}
			System.out.println("[Servidor encerrado]");
		} catch (Exception e) {
			System.out.println("Erro!\n");
			e.printStackTrace();
		}
	}
}
