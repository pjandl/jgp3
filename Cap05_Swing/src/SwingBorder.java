/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.12
 */
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class SwingBorder extends JFrame {
	public SwingBorder() {
		setTitle("Bordas em Paineis");
		JPanel cp = (JPanel) getContentPane();
		cp.setLayout(new GridLayout(1, 8, 5, 5));
		cp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		// cria painéis com bordas diferentes, adicionando-os ao contentPanel
		cp.add(createJPanelWithBorder(BorderFactory.createEtchedBorder()));
		cp.add(createJPanelWithBorder(BorderFactory.createLineBorder(
				Color.orange, 2)));
		cp.add(createJPanelWithBorder(BorderFactory.createLoweredBevelBorder()));
		cp.add(createJPanelWithBorder(BorderFactory.createMatteBorder(0, 3, 0,
				3, Color.blue)));
		cp.add(createJPanelWithBorder(BorderFactory.createMatteBorder(11, 11,
				11, 11, new ImageIcon("images/selected.gif"))));
		cp.add(createJPanelWithBorder(BorderFactory.createRaisedBevelBorder()));
		cp.add(createJPanelWithBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.green, 2),
				BorderFactory.createMatteBorder(0, 3, 0, 3, Color.blue))));
		cp.add(createJPanelWithBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(), "Título")));
		setSize(542, 111);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JPanel createJPanelWithBorder(Border border) {
		JPanel p = new JPanel(); // cria painel
		p.setBorder(border); // adiciona borda indicada
		return p; // retorna painel com borda indicada
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingBorder().setVisible(true);
			}
		});
	}
}
