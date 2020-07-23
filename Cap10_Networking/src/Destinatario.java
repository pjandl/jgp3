/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.16
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Destinatario {
	public static void main(String a[]) {
		//
		if (a.length < 1 || a.length > 2) {
			System.out.println("Uso:\n\tDestinatario <porta> [n]");
			System.exit(0);
		}
		//
		try { // Determina porta e no de mensagens a receber
			int porta = Integer.parseInt(a[0]);
			int n = a.length == 1 ? 1 : Integer.parseInt(a[1]);
			// Cria datagram socket
			DatagramSocket socket = new DatagramSocket(porta);
			while (n > 0) { // aguarda n pacotes
				System.out.printf(
						"[Destinatario:%d] Espera por #%d mensagens...\n",
						porta, n);
				// prepara buffer para recebimento de mensagem
				byte buf[] = new byte[256];
				// Prepara pacote de dados
				DatagramPacket pacote = new DatagramPacket(buf, buf.length);
				socket.receive(pacote); // recebe um pacote de dados
				// exibe status
				System.out.println("Mensagem: "
						+ new String(pacote.getData()).trim());
				System.out.println("Endereco: " + pacote.getAddress());
				n--;
			}
			socket.close(); // fecha socket
		} catch (IOException exc) {
			System.err.println("[Erro]\n" + exc);
		}
	}
}
