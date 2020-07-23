/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.6
 */
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingLabel2 extends JFrame {
	public SwingLabel2() {
		super("Swing Labels com Ícones"); // ajusta titulo
		setSize(300, 100); // posicao e tamanho da janela
		Container cp = getContentPane(); // painel de conteudo
		cp.setLayout(new GridLayout(2, 2)); // ajusta layout GridLayout
		cp.add(new JLabel("Sem Ícone"));
		cp.add(new JLabel(new ImageIcon("images/new16.gif"))); // centralizado
		cp.add(new JLabel(new ImageIcon("images/print16.gif"), JLabel.LEFT));
		cp.add(new JLabel("Ajuda", new ImageIcon("images/help16.gif"),
				JLabel.RIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(() -> {
			new SwingLabel2().setVisible(true);
		});
	}
}
