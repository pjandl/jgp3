/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.11
 */
package jandl.minichat;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MiniChatServer extends JFrame implements ActionListener, IChat {
	//
	private JTextArea taInfo;
	private JButton bAcao;
	private JTextField tfNomeSvr;
	private int porta, filaEspera;
	private ChatServer servidor;

	//

	public MiniChatServer(int porta, int filaEspera) {
		super("MiniChatServer");
		this.porta = porta;
		this.filaEspera = filaEspera;
		//
		JPanel p = new JPanel(new GridLayout(1, 3));
		p.add(new JLabel("Nome"));
		p.add(tfNomeSvr = new JTextField());
		p.add(bAcao = new JButton("Iniciar"));
		bAcao.addActionListener(this);
		add("North", p);
		JScrollPane sp = new JScrollPane(taInfo = new JTextArea());
		taInfo.setLineWrap(true);
		taInfo.setWrapStyleWord(true);
		taInfo.setEditable(false);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add("Center", sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		//
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (bAcao.getText().equals("Iniciar")) {
			startServer();
		} else {
			stopServer();
		}
	}

	private void startServer() {
		try {
			taInfo.setText("");
			servidor = new ChatServer(porta, filaEspera, this,
					tfNomeSvr.getText());
			servidor.start();
			tfNomeSvr.setEditable(false);
			bAcao.setText("Parar");
		} catch (ChatException exc) {
			taInfo.setText("[Error: " + exc.getMessage() + "]");
			exc.printStackTrace();
		}
	}

	private void stopServer() {
		servidor.shutdown();
		servidor = null;
		tfNomeSvr.setEditable(true);
		bAcao.setText("Iniciar");
	}

	@Override
	public void write(String msg) {
		taInfo.append(msg);
		taInfo.setCaretPosition(taInfo.getText().length());
	}

	//
	public static void main(String a[]) {
		try {
			final MiniChatServer mcs = new MiniChatServer(
					a.length > 0 ? Integer.parseInt(a[0]) : 3000,
					a.length > 1 ? Integer.parseInt(a[1]) : 10);
			SwingUtilities.invokeLater(() -> {
				mcs.setVisible(true);
			});
		} catch (NumberFormatException e) {
			System.out.println("Argumento(s) invalido(s)\n"
					+ "Uso: MiniChatServer [porta] [filaEspera]");
			System.exit(-1);
		}
	}
	//
}
