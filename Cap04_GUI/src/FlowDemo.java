/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 4.3
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class FlowDemo extends JFrame {
	public FlowDemo() {
		setTitle("FlowDemo"); // ajustes JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		cp.setLayout(new FlowLayout()); // layout FlowLayout
		for (int i = 0; i < 5; i++) {
			JButton b = new JButton("Bot�o " + (i + 1));
			cp.add(b); // adi��o do componente
		}
	}

	public static void main(String args[]) {
		// op��o simplificada de in�cio da aplica��o
		new FlowDemo().setVisible(true);
	}
}
