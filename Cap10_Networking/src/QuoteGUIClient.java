/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.19
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

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
public class QuoteGUIClient extends JFrame {
	//
	private JTextField tfHost;
	private JButton bReq;
	private JTextArea taFrases;

	//

	public QuoteGUIClient() {
		super("Quote Client");
		//
		JPanel pAux = new JPanel();
		pAux.add(new JLabel("Host"));
		pAux.add(tfHost = new JTextField(14));
		pAux.add(bReq = new JButton("Nova Frase"));
		pAux.setBorder(BorderFactory.createEtchedBorder());
		add("South", pAux);
		JScrollPane sp = new JScrollPane(taFrases = new JTextArea());
		taFrases.setEditable(false);
		add("Center", sp);
		//
		bReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bReqClick();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
	}

	private void bReqClick() {
		bReq.setEnabled(false);
		new QuoteRequest().start();
	}

	//
	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new QuoteGUIClient().setVisible(true);
			}
		});
	}

	//

	private class QuoteRequest extends Thread {
		public void run() {
			// cria datagram socket
			try (DatagramSocket socket = new DatagramSocket();) {
				byte[] buf = new byte[256]; // prepara buffer (vazio)
				// determina endereco do servico a partir da caixa de texto
				InetAddress end = InetAddress.getByName(tfHost.getText());
				// prepara e envia pacote
				DatagramPacket pacote = new DatagramPacket(buf, buf.length,
						end, 4444);
				socket.send(pacote);
				// prepara outro pacote (para resposta)
				pacote = new DatagramPacket(buf, buf.length);
				socket.setSoTimeout(15000); // 15s de espera maxima
				socket.receive(pacote); // recebe pacote de resposta
				// exibe frase na area de texto
				String frase = new String(pacote.getData()).trim();
				taFrases.append(frase + "\n");
			} catch (IOException ioe) {
				taFrases.append("Exce\u00E7\u00E3o:\n" + ioe + "\n");
			} // socket.close() implicito
			bReq.setEnabled(true); // habilita botao
		}
	}
}
