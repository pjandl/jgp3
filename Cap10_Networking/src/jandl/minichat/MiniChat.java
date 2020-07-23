/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.13
 */
package jandl.minichat;

import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.Keymap;

@SuppressWarnings("serial")
public class MiniChat extends JFrame implements ActionListener, IChat {
	//
	private JTextArea taDialogo, taMensagem;
	private JButton bAcao;
	private JTextField tfIPSvr, tfNome;
	private ChatClient cliente;

	//

	public MiniChat() {
		super("MiniChat");
		//
		setSize(350, 280);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 3));
		p.add(new JLabel("Apelido"));
		p.add(tfNome = new JTextField());
		p.add(bAcao = new JButton("Conectar"));
		bAcao.addActionListener(this);
		p.add(new JLabel("IP Servidor"));
		p.add(tfIPSvr = new JTextField());
		add("North", p);
		JScrollPane sp1 = new JScrollPane(taDialogo = new JTextArea());
		taDialogo.setLineWrap(true);
		taDialogo.setWrapStyleWord(true);
		taDialogo.setEditable(false);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JScrollPane sp2 = new JScrollPane(taMensagem = new JTextArea());
		taMensagem.setLineWrap(true);
		taMensagem.setWrapStyleWord(true);
		sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp1, sp2);
		// split.setDividerLocation(0.7);
		add("Center", split);
		//
		Action sendAction = new AbstractAction("SendMessage") {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (cliente != null) {
						cliente.sendMessage(tfNome.getText() + "> "
								+ taMensagem.getText());
						taMensagem.setText("");
					}
				} catch (ChatException exc) {
					taDialogo.append(exc.toString() + "\n" + exc.getMessage()
							+ "\n");
				}
			}
		};
		KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK);
		Keymap km = taMensagem.getKeymap();
		km.addActionForKeyStroke(ks, sendAction);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bAcao) {
			if (bAcao.getText().equals("Conectar")) {
				connectToServer();
				taMensagem.requestFocus();
			} else {
				disconnectFromServer();
			}
		}
	}

	public void connectToServer() {
		taDialogo.setText("[Conectando servidor " + tfIPSvr.getText()
				+ " ...]\n");
		try {
			tfNome.setEditable(false);
			tfIPSvr.setEditable(false);
			cliente = new ChatClient(tfIPSvr.getText(), 3000, this);
			cliente.start();
			cliente.sendMessage("[" + tfNome.getText() + " entrou]");
			bAcao.setText("Desconectar");
		} catch (ChatException exc) {
			taDialogo.append(exc.toString() + "\n" + exc.getMessage() + "\n");
		}
	}

	public void disconnectFromServer() {
		try {
			cliente.sendMessage("[" + tfNome.getText() + " saiu]");
			cliente.sendMessage(ChatClient.EOT);
			cliente.closeConnection();
			tfNome.setEditable(true);
			tfIPSvr.setEditable(true);
			bAcao.setText("Conectar");
		} catch (ChatException exc) {
			taDialogo.append(exc.toString() + "\n" + exc.getMessage() + "\n");
		}
		tfNome.setEditable(true);
		bAcao.setText("Conectar");
	}

	@Override
	public void write(String msg) {
		taDialogo.append(msg);
		taDialogo.setCaretPosition(taDialogo.getText().length());
	}

	//
	public static void main(String a[]) {
		SwingUtilities.invokeLater(() -> {
			new MiniChat().setVisible(true);
		});
	}
	//
}
