/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.8
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteMulti {
	public static void main(String a[]) {
		//
		if (a.length < 2) {
			System.out.println("Uso: ClienteMulti <endIP> <limite>");
			System.exit(0);
		}
		//
		System.out.println("[Conectando Servidor...]");
		try (Socket cliente = new Socket(a[0], 1234);) {
			System.out.printf("[Conexao aceita de: %s]\n", cliente
					.getInetAddress().toString());
			System.out.println("[Enviando Limite...]");
			ObjectOutputStream saida = new ObjectOutputStream(
					cliente.getOutputStream());
			saida.flush();
			saida.writeObject(new Integer(a[1])); // envia limite
			System.out.println("[Recebendo Contagem...]");
			ObjectInputStream entrada = new ObjectInputStream(
					cliente.getInputStream());
			String msg;
			do { // recebe contagem (objetos String)
				msg = (String) entrada.readObject();
				System.out.println(msg);
			} while (!msg.equals("EOT"));
			System.out.println("[Contagem OK. Conexao encerrada]");
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Erro!\n" + e.getMessage());
		} // fechamento implicito da conexao
	}
}
