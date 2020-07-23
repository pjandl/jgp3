/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.5
 */
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingLabel1 extends JFrame {
	public SwingLabel1() {
		super("Swing Labels"); // ajusta t�tulo
		setSize(400, 100); // ajusta posi��o e tamanho
		Container cp = getContentPane(); // painel de conte�do
		cp.setLayout(new GridLayout(2, 2)); // ajusta layout GridLayout
		cp.add(new JLabel("R�tulo � Esquerda"));
		cp.add(new JLabel("R�tulo � Direita", JLabel.RIGHT));
		cp.add(new JLabel("R�tulo Centralizado", JLabel.CENTER));
		cp.add(new JLabel("<html><font color=#FF0000>Swing</font>"
				+ " � <i>diferente</i>!</html>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // a��o fechar
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater( // express�o lambda
				() -> {
					new SwingLabel1().setVisible(true);
				});
	}
}
