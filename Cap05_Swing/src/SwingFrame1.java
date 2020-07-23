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
		super("Swing Frame1"); // ajusta título
		setBounds(50, 50, 250, 100); // ajusta posição e tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ajusta ação fechar
	}

	public static void main(String a[]) {
		// Opção simplificada de início
		new SwingFrame1().setVisible(true);
	}
}
