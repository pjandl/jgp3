/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.4
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class SwingWindow extends JWindow {
	public SwingWindow() {
		setBounds(50, 50, 250, 90); // ajusta posi��o e tamanho
		JLabel label = new JLabel("<HTML><U>Fechar</U></HTML>", JLabel.RIGHT);
		label.addMouseListener(new MouseAdapter() { // classe an�nima
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); // fecha aplica��o
			}
		});
		add("North", label);
	}

	public static void main(String a[]) {
		// op��o simplificada de in�cio
		new SwingWindow().setVisible(true);
	}
}
