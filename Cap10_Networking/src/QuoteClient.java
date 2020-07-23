/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.18
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class QuoteClient {
	public static void main(String[] args) throws IOException {
		//
		if (args.length != 1) {
			System.out.println("Uso: QuoteClient <endhost>");
			return;
		}
		//
		DatagramSocket socket = new DatagramSocket(); // cria datagram socket
		byte[] buf = new byte[256]; // prepara buffer (vazio)
		// determina endereco do servico
		InetAddress end = InetAddress.getByName(args[0]);
		// prepara e envia pacote
		DatagramPacket pacote = new DatagramPacket(buf, buf.length, end, 4444);
		socket.send(pacote);
		// prepara pacote para resposta
		pacote = new DatagramPacket(buf, buf.length);
		socket.setSoTimeout(5000); // 5s de espera maxima
		socket.receive(pacote); // recebe pacote de resposta
		String frase = new String(pacote.getData()).trim(); // exibe frase
		System.out.println("[QuoteClient] Frase do Momento:\n" + frase);
		socket.close(); // fecha socket
	}
}
