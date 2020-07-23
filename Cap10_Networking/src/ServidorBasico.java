/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.2
 */
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBasico {
	public static void main(String a[]) {
		System.out.println("[Criando Servidor...]");
		try (ServerSocket servidor = new ServerSocket(1234);) {
			System.out.println("[Servidor operando na porta 1234]");
			while (true) {
				System.out.println("[Esperando conexao...]");
				Socket cliente = servidor.accept(); // aceita conexão
				System.out.println("[Conexao aberta de: "
						+ cliente.getInetAddress().toString() + "]");
				System.out.println("[Enviando dados...]");
				ObjectOutputStream saida = new ObjectOutputStream(
						cliente.getOutputStream());
				saida.flush(); // envia cabeçalho de preparo do outro endpoint
				saida.writeObject("Servidor Basico Conectado");
				saida.writeObject("Dados conexao: " + cliente.toString());
				saida.writeObject("Tchau!");
				System.out.println("[Dados enviados]");
				saida.writeObject("EOT");
				cliente.close();
				System.out.println("[Conexao encerrada]");
			}
		} catch (IOException e) {
			System.out.println("Erro!\n" + e.getMessage());
		}
	}
}
