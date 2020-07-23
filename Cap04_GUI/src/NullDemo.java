/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 4.2
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class NullDemo extends JFrame {
	public NullDemo() {
		setTitle("NullDemo"); // ajustes JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		cp.setLayout(null); // layout desativado
		for (int i = 0; i < 5; i++) {
			JButton b = new JButton("Botão " + (i + 1));
			b.setBounds(10 + i * 90, 30, 80, 20); // x, y, larg, alt
			cp.add(b); // adição do componente
		}
	}

	public static void main(String args[]) {
		// opção simplificada de início da aplicação
		new NullDemo().setVisible(true);
	}
}
