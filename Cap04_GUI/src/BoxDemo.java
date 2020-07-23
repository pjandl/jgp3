/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 4.5
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BoxDemo extends JFrame {
	public BoxDemo() {
		setTitle("BoxDemo"); // ajustes JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		// layout BoxLayout: use X._AXIS ou Y_AXIS
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		cp.add(new JButton("Bot�o 1")); // adi��o dos componentes
		cp.add(new JButton("Bot�o 2"));
		cp.add(new JButton("Bot�o 3 Diferente"));
		cp.add(new JButton("Bot�o 4"));
	}

	public static void main(String args[]) {
		// op��o simplificada de in�cio da aplica��o
		new BoxDemo().setVisible(true);
	}
}
