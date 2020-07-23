/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.20
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingFileDialog extends JFrame {
	private JButton bDialogo; // botao p/ acionar dialogo
	private JLabel lResultado; // rotulo p/ resultados
	private JFileChooser dialogo; // dialogo de arquivos

	public SwingFileDialog() {
		super("SwingFileDialog"); // ajusta titulo
		Container cp = getContentPane(); // painel de conteudo
		cp.setLayout(new GridLayout(2, 1)); // layout grade 4x1
		cp.add(bDialogo = new JButton("Selecionar Arquivo"));
		cp.add(lResultado = new JLabel("Sem seleção"));
		lResultado.setBorder(BorderFactory.createMatteBorder(2, 2, 3, 2,
				Color.green));
		bDialogo.addActionListener((e) -> { // expressão lambda
			dialogo = new JFileChooser(); // instancia dialogo
			int res = dialogo.showOpenDialog(SwingFileDialog.this);
			// verifica se usuario fez selecao
			if (res == JFileChooser.APPROVE_OPTION) {
				File arq = dialogo.getSelectedFile();
				lResultado.setText(arq.getName());
			}
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingFileDialog().setVisible(true);
			}
		});
	}
}
