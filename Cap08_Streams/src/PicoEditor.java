/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.9
 */
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PicoEditor extends JFrame {
	private JLabel lArquivo;
	private JFileChooser fc = new JFileChooser(".");
	private JTextArea taConteudo;
	private JButton bSalvar;

	public PicoEditor() { // construtor
		super("PicoEditor ");
		JPanel p = new JPanel(new BorderLayout());
		lArquivo = new JLabel("N\u00e3o salvo");
		bSalvar = new JButton(new ImageIcon("images/saveas16.gif"));
		p.add(lArquivo, "Center");
		p.add(bSalvar, "East");
		add("North", p); // painel e seus componentes na area superior
		JScrollPane sp = new JScrollPane(taConteudo = new JTextArea());
		add("Center", sp); // textarea e seu scrollpane na area central
		// registro do listener como expressão lambda
		bSalvar.addActionListener((e) -> {
			fileSelection();
		});
		// ajustes nos componentes e janelas
		//
		taConteudo.setTabSize(2); // tamanho da tabulacao
		taConteudo.setLineWrap(true); // quebra automatica de linha
		taConteudo.setWrapStyleWord(true); // mantem palavras inteiras
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
	}

	private void fileSelection() {
		if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File arq = fc.getSelectedFile();
			try {
				textFileWrite(taConteudo.getText(), arq.getPath());
				lArquivo.setText(arq.getPath());
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(this, "Arquivo '" + arq.getPath()
						+ "' n\u00e3o pode ser salvo.", "PicoEditor",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void textFileWrite(String content, String fname) throws IOException {
		// abre arquivo indicado
		PrintWriter out = new PrintWriter(new FileWriter(fname));
		// grava conteudo numa unica operacao de escrita
		out.print(content);
		out.close(); // fecha arquivo
	}

	//
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PicoEditor().setVisible(true);
			}
		});
	}
	//
}
