/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.17
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class QuoteServer extends Thread {
	protected DatagramSocket socket = null;
	protected BufferedReader ent = null;
	protected boolean maisFrases = true;

	public QuoteServer() {
		super("QuoteServer");
		try { // cria datagram socket na porta 4444
			socket = new DatagramSocket(4444);
			// abre arquivo de frases
			ent = new BufferedReader(new FileReader("quotes.txt"));
		} catch (FileNotFoundException fnfe) {
			System.err
					.println("[QuoteServer] Arquivo de frase n\u00E3o pode ser aberto.");
			System.exit(-1);
		} catch (SocketException ioe) {
			System.err
					.println("[QuoteServer] Socket n\u00E3o pode ser aberto.");
			System.exit(-1);
		}
	}

	public void run() {
		while (maisFrases) {
			try {
				System.out.println("[QuoteServer] Aguardando pedido...");
				byte[] buf = new byte[256]; // prepara pacote de entrada
				DatagramPacket pacote = new DatagramPacket(buf, buf.length);
				socket.receive(pacote); // recebe pacote
				String frase = getFrase(); // obtem frase
				buf = frase.getBytes(); // prepara buffer
				// prepara resposta para cliente no endereco e porta
				InetAddress end = pacote.getAddress();
				int porta = pacote.getPort();
				pacote = new DatagramPacket(buf, buf.length, end, porta);
				socket.send(pacote); // envia resposta
				System.out.println("[QuoteServer] Frase enviada para " + end
						+ ":" + porta);
			} catch (IOException e) {
				System.err.println("[QuoteServer] Erro: " + e);
				maisFrases = false;
			}
		}
		socket.close();
	}

	protected String getFrase() {
		String frase = null;
		try { // le frases (linhas) do arquivo de frases
			if ((frase = ent.readLine()) == null) {
				ent.close();
				maisFrases = false;
				frase = "Acabaram as frases!";
			}
		} catch (IOException e) {
			frase = "IOException no servidor.";
		}
		return frase;
	}

	public static void main(String[] args) throws IOException {
		new QuoteServer().start();
	}
}
