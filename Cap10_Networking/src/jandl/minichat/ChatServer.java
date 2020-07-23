/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.9
 */
package jandl.minichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

public class ChatServer extends Thread {
	//
	private ServerSocket servidor;
	private IChat icSaida;
	private Hashtable<String, ChatClient> clientes;
	private int idCliente, porta;
	private String apelido;
	private boolean up;

	//

	public ChatServer(int porta, int filaEspera, IChat icSaida, String apelido)
			throws ChatException {
		try {
			this.porta = porta;
			this.icSaida = icSaida;
			icSaida.write("[Atendendo na porta " + porta + "]\n");
			servidor = new ServerSocket(porta, filaEspera);
			clientes = new Hashtable<String, ChatClient>();
			idCliente = 0;
			this.apelido = apelido;
		} catch (IOException e) {
			throw new ChatException("ServerSocket n\u00E3o pode ser criado", e);
		}
	}

	public void run() {
		try {
			icSaida.write("[Servidor " + apelido + " ativado]\n");
			up = true;
			while (true) {
				Socket s = servidor.accept();
				if (!up) {
					break;
				}
				ChatClient cliente = new ChatClient(s, this, icSaida,
						++idCliente);
				cliente.start();
				clientes.put("" + idCliente, cliente);
				cliente.sendMessage("[Benvindo ao Servidor " + apelido + "]\n");
			}
			icSaida.write("[Servidor parado]\n");
		} catch (Exception e) {
			icSaida.write("ERRO: Conex\u00E3o n\u00E3o pode ser efetivada\n");
		}
	}

	public void shutdown() {
		try {
			up = false;
			new Socket("localhost", porta);
		} catch (Exception e) {
			icSaida.write("ERRO: Thread servidora n\u00E3o pode ser conectada\n");
		}
	}

	public synchronized void broadcast(String msg) throws ChatException {
		for (Enumeration<ChatClient> e = clientes.elements(); e
				.hasMoreElements();) {
			e.nextElement().sendMessage(msg);
		}
	}

	public synchronized void removeClient(String id) {
		clientes.remove(id);
	}
}
