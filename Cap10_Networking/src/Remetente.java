/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.15
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Remetente {
	public static void main(String a[]) {
		//
		if (a.length == 0) {
			System.out.println("Uso:\n\tRemetente <IP> <porta> <mensagem>");
			System.exit(0);
		}
		//
		try { // Determina endereco, porta e buffer a partir dos argumentos
			InetAddress end = InetAddress.getByName(a[0]);
			int porta = Integer.parseInt(a[1]);
			byte buf[] = a[2].getBytes();
			// Prepara pacote de dados
			DatagramPacket pacote = new DatagramPacket(buf, buf.length, end,
					porta);
			// Cria datagram socket
			DatagramSocket socket = new DatagramSocket();
			socket.send(pacote); // envia pacote de dados
			System.out.println("[Remetente]"); // exibe status
			System.out.println("Mensagem: " + a[2]);
			System.out.println("Endereco: " + end + ":" + porta);
			socket.close(); // fecha socket
		} catch (IOException exc) {
			System.err.println("[Erro]\n" + exc);
		}
	}
}
