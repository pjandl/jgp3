/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.1
 */
import javax.swing.*;

@SuppressWarnings("serial")
public class SwingFrame1 extends JFrame {
	public SwingFrame1() {
		super("Swing Frame1"); // ajusta t�tulo
		setBounds(50, 50, 250, 100); // ajusta posi��o e tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ajusta a��o fechar
	}

	public static void main(String a[]) {
		// Op��o simplificada de in�cio
		new SwingFrame1().setVisible(true);
	}
}
