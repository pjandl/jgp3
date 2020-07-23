/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.5
 */
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ExibeTexto extends JFrame {
	private JLabel lArquivo;
	private JFileChooser fc = new JFileChooser(".");
	private JTextArea taTexto;
	private JButton bAbrir;
	private JCheckBox cbWrap;

	public ExibeTexto() { // construtor
		super("ExibeTexto");
		// painel superior
		JPanel p = new JPanel(new BorderLayout());
		p.add(bAbrir = new JButton(new ImageIcon("images/open16.gif")), "West");
		p.add(lArquivo = new JLabel("<sem conte�do>"), "Center");
		p.add(cbWrap = new JCheckBox("Wrap", true), "East");
		add("North", p); // painel e seus components na parte superior
		JScrollPane sp = new JScrollPane(taTexto = new JTextArea());
		add("Center", sp); // textarea e seu scrollpane na parte central
		// registro dos listeners com express�es lambda
		bAbrir.addActionListener((e) -> {
			carregaArquivo();
		});
		cbWrap.addItemListener((e) -> {
			taTexto.setLineWrap(cbWrap.isSelected());
		});
		// ajustes nos componentes e janela da aplicacao
		taTexto.setEditable(false); // textarea nao editavel
		taTexto.setLineWrap(true); // ativa quebra de linha
		taTexto.setTabSize(2); // tamanho da tabulacao
		taTexto.setBorder(BorderFactory.createEtchedBorder());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
	}

	private void carregaArquivo() {
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File arq = fc.getSelectedFile(); // obtem arquivo selecionado
			try { // carrega conteudo do arquivo no textarea
				taTexto.setText(textFileRead(arq.getPath()));
				lArquivo.setText(arq.getPath());
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(this, "Arquivo '" + arq.getPath()
						+ "' n�o foi aberto.", "ExibeTexto",
						JOptionPane.ERROR_MESSAGE);
				lArquivo.setText("<sem conteúdo>");
			}
		}
	}

	public String textFileRead(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder buffer = new StringBuilder();
		while ((line = in.readLine()) != null) {
			buffer.append(line + "\n");
		}
		in.close();
		return buffer.toString();
	}

	//
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ExibeTexto().setVisible(true);
			}
		});
	}
	//
}
