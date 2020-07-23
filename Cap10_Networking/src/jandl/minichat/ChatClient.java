/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.12
 */
package jandl.minichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient extends Thread {
	//
	public static final String EOT = "EOT";
	private Socket conexao;
	private ChatServer servidor;
	private PrintWriter output;
	private BufferedReader input;
	private int idCliente;
	private IChat icSaida;
	private boolean ativo;

	//

	public ChatClient(Socket conexao, ChatServer servidor, IChat icSaida,
			int idCliente) throws ChatException {
		try {
			this.conexao = conexao;
			this.servidor = servidor;
			this.icSaida = icSaida;
			this.idCliente = idCliente;
			input = new BufferedReader(new InputStreamReader(
					conexao.getInputStream()));
			output = new PrintWriter(conexao.getOutputStream(), true);
			icSaida.write("[Conex\u00E3o aberta]\n" + conexao + "\n");
		} catch (IOException e) {
			e.printStackTrace();
			throw new ChatException("Canais de I/O n\u00E3o foram criados", e);
		}
	}

	public ChatClient(String srvIP, int srvPort, IChat icSaida)
			throws ChatException {
		try {
			conexao = new Socket(srvIP, srvPort);
			servidor = null;
			this.icSaida = icSaida;
			input = new BufferedReader(new InputStreamReader(
					conexao.getInputStream()));
			output = new PrintWriter(conexao.getOutputStream(), true);
			icSaida.write("[Conex\u00E3o aberta]\n" + conexao + "\n");
		} catch (IOException e) {
			throw new ChatException("Canais de I/O n\u00E3o foram criados", e);
		}
	}

	public void run() {
		try {
			ativo = true;
			while (ativo) {
				String msg = new String(input.readLine());
				if (msg != null) {
					if (msg.equals(EOT)) {
						closeConnection();
						return;
					} else {
						if (servidor == null) {
							icSaida.write(msg + "\n");
						} else {
							servidor.broadcast(msg);
						}
					}
				}
			}
		} catch (Exception e) {
			if (ativo) {
				icSaida.write("ERRO: Canal de I/O n\u00E3o pode ser lido\n");
			}
		}
	}

	public void sendMessage(String msg) throws ChatException {
		try {
			output.println(msg);
		} catch (Exception e) {
			throw new ChatException(
					"N\u00E3o foi poss\u00EDvel enviar mensagem", e);
		}
	}

	public void closeConnection() throws ChatException {
		try {
			ativo = false;
			String s = conexao.getInetAddress().toString();
			input.close();
			output.close();
			conexao.close();
			if (servidor != null) {
				icSaida.write("[Conex\u00E3o encerrada de " + s + "]\n");
				servidor.removeClient("" + idCliente);
			}
		} catch (IOException e) {
			throw new ChatException("Conex\u00E3o n\u00E3o pode ser fechada", e);
		}
	}
}
