/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.7
 */
import javax.swing.*;

@SuppressWarnings("serial")
public class Relogio extends JFrame {
	public Relogio() {
		super("Relógio");
		JClockPanel clock = new JClockPanel();
		clock.start();
		getContentPane().add("Center", clock);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Relogio().setVisible(true);
			}
		});
	}
}
