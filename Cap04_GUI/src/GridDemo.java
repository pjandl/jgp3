/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 4.4
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GridDemo extends JFrame {
	public GridDemo() {
		setTitle("GridDemo"); // ajustes JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		cp.setLayout(new GridLayout(2, 3)); // layout GridLayout
		for (int i = 0; i < 5; i++) {
			JButton b = new JButton("Bot�o " + (i + 1));
			cp.add(b); // adi��o do componente
		}
	}

	public static void main(String args[]) {
		// op��o simplificada de in�cio da aplica��o
		new GridDemo().setVisible(true);
	}
}
