/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.20
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class InfoServer extends Thread {
	private static String endGrupo = "230.0.0.1", nome = "IS:JGP3";
	private static int porta = 1964, periodo = 5000;
	//
	private static String help = "[-e:<ip>] [-p:<porta>] [-t:<per>] [-n:<nome>] [-h]\n"
			+ "onde:\n"
			+ "\tip - endere\u00E7o do grupo no formato nnn.nnn.nnn.nnn\n"
			+ "\tporta - numero da porta do servico\n "
			+ "\tper - intervalo de tempo para envio de dados em ms\n"
			+ "\tnome - nome do servidor";
	private DatagramSocket socket = null;
	private boolean executar = true;

	//

	// construtor
	public InfoServer() {
		super("IS:" + nome);
		try { // cria datagram socket na porta configurada
			socket = new DatagramSocket(porta);
			System.out.println("[" + nome + "] end=" + endGrupo + ":" + porta
					+ "(" + periodo + "ms) preparado.");
		} catch (SocketException ioe) {
			System.err.println("[" + nome
					+ "] Socket n\u00E3o pode ser aberto.");
			System.exit(-1);
		}
	}

	@Override
	public void run() {
		System.out.println("[" + nome + "] executando...");
		DatagramPacket pacote = null;
		while (executar) {
			try {
				String dados = infoRetrieve(); // obtem dados
				byte[] buf = dados.getBytes(); // prepara pacote de entrada
				InetAddress end = InetAddress.getByName(endGrupo);
				pacote = new DatagramPacket(buf, buf.length, end, porta);
				socket.send(pacote); // envia dados
				System.out.println("[" + nome + "] Dados enviados:\n" + dados);
				try { // espera variavel (0 < espera < periodo)
					sleep((long) (Math.random() * periodo));
				} catch (InterruptedException ie) {
				}
			} catch (IOException e) {
				System.err.println("[" + nome + "] Erro: " + e);
				executar = false;
			}
		}
	}

	private String infoRetrieve() {
		return "[" + nome + "] " + new Date();
	}

	public static void main(String a[]) {
		// processa os argumentos da linha de comando
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i].startsWith("-e:")) {
				endGrupo = a[i].substring(3);
			} else if (a[i].startsWith("-p:")) {
				porta = Integer.parseInt(a[i].substring(3));
			} else if (a[i].startsWith("-t:")) {
				periodo = Integer.parseInt(a[i].substring(3));
			} else if (a[i].startsWith("-n:")) {
				nome = a[i].substring(3);
			} else if (a[i].equals("-h")) {
				System.out.println("Uso:\nInfoServer " + help);
				break;
			}
		}
		new InfoServer().start();
	}
}
