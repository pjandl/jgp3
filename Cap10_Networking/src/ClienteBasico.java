/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.3
 */
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClienteBasico {
	public static void main(String a[]) {
		String host = a.length == 0 ? "127.0.0.1" : a[0];
		System.out.println("[Conectando Servidor...]");
		try (Socket cliente = new Socket(host, 1234);) {
			System.out.println("[Conexao aceita de: "
					+ cliente.getInetAddress().toString() + "]");
			System.out.println("[Recebendo Mensagens...]");
			ObjectInputStream entrada = new ObjectInputStream(
					cliente.getInputStream());
			String msg;
			do { // recepcao de mensagens do servidor
				msg = (String) entrada.readObject();
				System.out.println(msg);
			} while (!msg.equals("EOT"));
			System.out.println("[Conexao encerrada]");
		} catch (Exception e) {
			System.out.println("Erro!\n" + e.getMessage());
		} // cliente.close() implicito
	}
}
