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
		cp.add(new JButton("Botão 1")); // adição dos componentes
		cp.add(new JButton("Botão 2"));
		cp.add(new JButton("Botão 3 Diferente"));
		cp.add(new JButton("Botão 4"));
	}

	public static void main(String args[]) {
		// opção simplificada de início da aplicação
		new BoxDemo().setVisible(true);
	}
}
