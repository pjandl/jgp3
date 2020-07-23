/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.25
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ContaPalavras extends JFrame implements ActionListener {
	private JTextArea taTexto = new JTextArea();
	private JButton bAbrir = new JButton("Analisa arquivo");

	public ContaPalavras() {
		super("ContaPalavras");
		// Instancia e organiza componentes no JFrame
		getContentPane().add("North", bAbrir);
		getContentPane().add("Center", new JScrollPane(taTexto));
		// Registro do listener
		bAbrir.addActionListener(this);
		// outros ajuste na interface
		taTexto.setEditable(false);
		taTexto.setLineWrap(true);
		taTexto.setWrapStyleWord(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 145);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser("."); // dialogo de arquivos
		if (fc.showOpenDialog(taTexto) == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile(); // obtem arquivo escolhido
			taTexto.setText(file + "\n"); // exibe nome do arquivo
			try { // cria processador de tokens
				StreamTokenizer arq = new StreamTokenizer(new BufferedReader(
						new FileReader(file)));
				arq.commentChar(0); // ajusta processador de tokens
				arq.lowerCaseMode(true);
				arq.ordinaryChars('\u0021', '\u0040');
				// cria mapa parametrizado chave->String, valor-->Integer
				Map<String, Integer> mapa = new TreeMap<>();
				// processa tokens do arquivo enquanto este nao acaba
				while (arq.nextToken() != StreamTokenizer.TT_EOF) {
					// se for uma palavra trata "sval" como chave
					if (arq.ttype == StreamTokenizer.TT_WORD) {
						Integer n = mapa.get(arq.sval); // procura ocorrencias
						// insere chave e numero de ocorrencias atualizado
						mapa.put(arq.sval, n == null ? 1 : n.intValue() + 1);
					}
				}
				taTexto.append(mapa.entrySet().toString()); // exibe resultados
				taTexto.append("\nTermos encontrados:" + mapa.size() + "\n");
			} catch (IOException ioe) {
				taTexto.setText(ioe.toString()); // exibe erro
			}
		}
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ContaPalavras().setVisible(true);
			}
		});
	}

}
