/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.22
 */
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingColorChooser extends JFrame {
	private JButton bBack, bFore; // botoes de controle
	private JLabel lText; // rotulo de texto

	public SwingColorChooser() {
		super("Swing ColorChooser"); // ajusta titulo
		Container cp = getContentPane(); // painel de conteudo
		cp.add("North", bFore = new JButton("Label Foreground"));
		cp.add("Center", lText = new JLabel("Java Guia do Programador 3aEd."));
		lText.setOpaque(true); // rotulo nao-transparente
		cp.add("South", bBack = new JButton("Label Background"));
		bFore.addActionListener((e) -> { // expressão lambda
			lText.setForeground(JColorChooser.showDialog(
					SwingColorChooser.this, bFore.getText(),
					lText.getForeground()));
		});
		bBack.addActionListener((e) -> { // expressão lambda
			lText.setBackground(JColorChooser.showDialog(
					SwingColorChooser.this, bBack.getText(),
					lText.getBackground()));
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
		pack(); // autodimensiona janela
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingColorChooser().setVisible(true);
			}
		});
	}
}
