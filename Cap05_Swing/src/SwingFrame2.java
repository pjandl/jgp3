/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.3
 */
import javax.swing.*;

@SuppressWarnings("serial")
public class SwingFrame2 extends JFrame {
	public SwingFrame2() {
		super("Swing Frame 2"); // ajusta título
		setBounds(50, 50, 250, 90); // ajusta posição e tamanho
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ação Fechar
		add(new JLabel("Janela")); // conteúdo
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SwingFrame2 principal = new SwingFrame2(); // cria janela
															// principal
				principal.setVisible(true); // exibe janela principal
				SwingDialog dialogo = new SwingDialog(principal, true); // cria
																		// diálogo
				dialogo.setVisible(true); // exibe diálogo
			}
		});
	}
}
