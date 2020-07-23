/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 4.6
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BorderDemo extends JFrame {
	public BorderDemo () {
		setTitle("BorderDemo"); // ajustes JFrame
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); // container
		// BorderLayout e default para JFrame
		cp.add(new JButton("Bot�o 1"),"North"); // adi��o dos componentes
		cp.add(new JButton("Bot�o 2"),"South");
		cp.add(new JButton("Bot�o 3"),"East");
		cp.add(new JButton("Bot�o 4"),"West");
		cp.add(new JButton("Bot�o 5"),"Center");
	}
	public static void main (String args[]) {
		// op��o simplificada de in�cio da aplica��o
		new BorderDemo().setVisible(true);
} }
