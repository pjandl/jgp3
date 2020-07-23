/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.13
 */
import java.io.File;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class SwingSplit extends JFrame implements ListSelectionListener {
	private File corrente, dir[]; // array com info arquivos
	private JList<String> listaDir; // caixa de lista p/ info diretorio
	private JTextArea taInfo; // area de texto p/ info arquivo

	public SwingSplit() {
		super("Swing SplitPane"); // ajusta titulo
		corrente = new File("."); // aponta diretorio atual
		dir = corrente.listFiles(); // lista arquivos do diretorio atual
		String dirInfo[] = new String[dir.length];
		for (int i = 0; i < dir.length; i++)
			dirInfo[i] = (dir[i].isDirectory() ? "[D]" : "[F]")
					+ dir[i].getName();
		// painel de divisao
		JSplitPane split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				new JLabel(new ImageIcon("images/mini-j.gif")), // imagem
				new JScrollPane(listaDir = new JList<>(dirInfo))); // diretorio
		// painel de divisao interno
		JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, split1,
				new JScrollPane(taInfo = new JTextArea())); // area de texto
		getContentPane().add(split2, "Center"); // adiciona a janela
		split1.setDividerLocation(0.75); // outros ajustes
		split2.setDividerLocation(275);
		split2.setOneTouchExpandable(true);
		listaDir.addListSelectionListener(this);
		setSize(500, 175); // dimensiona janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
	}

	// classe implementa listener
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int i = listaDir.getSelectedIndex();
		if (i == -1)
			return;
		StringBuffer sb = new StringBuffer("Nome: " + dir[i].getName() + "\n");
		// exibe informacoes do arquivo: caminho, caminho absolute,
		// atributos, data de modificacao e tamanho.
		sb.append("Path: " + dir[i].getPath() + "\n");
		sb.append("Abs Path: " + dir[i].getAbsolutePath() + "\n");
		sb.append("Diretório: " + dir[i].isDirectory() + "\n");
		sb.append("Arquivo: " + dir[i].isFile() + "\n");
		sb.append("Oculto: " + dir[i].isHidden() + "\n");
		sb.append("LastModif: " + new Date(dir[i].lastModified()).toString()
				+ "\n");
		sb.append("Tamanho: " + dir[i].length() + "\n");
		taInfo.setText(sb.toString());
	}

	public static void main(String s[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingSplit().setVisible(true);
			}
		});
	}
}
