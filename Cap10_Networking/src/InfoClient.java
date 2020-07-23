/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.21
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class InfoClient extends JFrame {
	//
	private JTextField tfHost;
	private JButton bIniciar, bParar, bLimpar;
	private JTextArea taInfo;
	private boolean ativo;
	private String dados;

	//

	public InfoClient() {
		super("InfoClient");
		//
		JPanel pAux1 = new JPanel(new BorderLayout());
		pAux1.add("West", new JLabel("Host"));
		pAux1.add("Center", tfHost = new JTextField("230.0.0.1:1964"));
		pAux1.setBorder(BorderFactory.createEtchedBorder());
		add("North", pAux1);
		pAux1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel pAux2 = new JPanel(new GridLayout(1, 3, 3, 3));
		pAux2.add(bLimpar = new JButton("Limpar"));
		pAux2.add(bParar = new JButton("Parar"));
		pAux2.add(bIniciar = new JButton("Iniciar"));
		pAux1.add(pAux2);
		pAux1.setBorder(BorderFactory.createEtchedBorder());
		add("South", pAux1);
		JScrollPane sp = new JScrollPane(taInfo = new JTextArea());
		taInfo.setEditable(false);
		add("Center", sp);
		//
		bIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bIniciar.setEnabled(false);
				tfHost.setEnabled(false);
				new InfoReceive().start();
			}
		});
		bParar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ativo = false;
			}
		});
		bLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!ativo) {
					taInfo.setText("");
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
	}

	//
	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new InfoClient().setVisible(true);
			}
		});
	}

	//

	private class InfoReceive extends Thread {
		@SuppressWarnings("resource")
		@Override
		public void run() {
			MulticastSocket socket = null;
			try { // determina endereco e porta
				String host = tfHost.getText();
				int porta = Integer
						.parseInt(host.substring(host.indexOf(":") + 1));
				InetAddress grupo = InetAddress.getByName(host.substring(0,
						host.indexOf(":")));
				socket = new MulticastSocket(porta); // cria multicast socket
				socket.joinGroup(grupo); // se une ao grupo
				ativo = true; // habilita laco
			} catch (IOException ioe) {
				taInfo.append("Exce\u00E7\u00E3o:\n" + ioe + "\n");
				return;
			}
			while (ativo) {
				try {
					byte[] buf = new byte[256]; // prepara buffer
					// prepara pacote para resposta
					DatagramPacket pacote = new DatagramPacket(buf, buf.length);
					socket.receive(pacote); // recebe pacote
					// exibe dados na area de texto
					dados = new String(pacote.getData()).trim();
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							taInfo.append(dados + "\n");
							taInfo.setCaretPosition(taInfo.getText().length());
						}
					});
				} catch (IOException ioe) {
					taInfo.append("Exce\u00E7\u00E3o:\n" + ioe + "\n");
					return;
				}
			}
			socket.close(); // fecha socket
			bIniciar.setEnabled(true); // habilita controles
			tfHost.setEnabled(true);
		}
	}
}
