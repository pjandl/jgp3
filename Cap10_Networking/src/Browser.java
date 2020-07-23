/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.27
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

@SuppressWarnings("serial")
public class Browser extends JFrame {
	//
	private JEditorPane conteudo;
	private JTextField endereco;
	private JLabel status;

	//

	public Browser() {
		super("Browser");
		JPanel pAux = new JPanel(new BorderLayout());
		pAux.add("West", new JLabel("URL:"));
		pAux.add("Center", endereco = new JTextField());
		pAux.setBorder(BorderFactory.createEtchedBorder());
		endereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enderecoEnter(e.getActionCommand());
			}
		});
		add("North", pAux);
		add("Center", new JScrollPane(conteudo = new JEditorPane()));
		conteudo.setEditable(false);
		conteudo.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent he) {
				if (he.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					enderecoEnter(he.getURL().toString());
				} else {
					status.setText(he.getURL().toString());
				}
			}
		});
		pAux = new JPanel(new BorderLayout());
		pAux.add("Center", status = new JLabel());
		add("South", pAux);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
	}

	private void enderecoEnter(String url) {
		try {
			if (url.trim().equals(""))
				return;
			conteudo.setPage(url.trim());
			endereco.setText(url.trim());
			setTitle("Browser [" + url.trim() + "]");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(this, "URL \"" + url
					+ "\"\nn\u00E3o pode ser carregada.", "Browser [Erro]",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	//
	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Browser().setVisible(true);
			}
		});
	}
	//
}
