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
		cp.add(new JButton("Botão 1"),"North"); // adição dos componentes
		cp.add(new JButton("Botão 2"),"South");
		cp.add(new JButton("Botão 3"),"East");
		cp.add(new JButton("Botão 4"),"West");
		cp.add(new JButton("Botão 5"),"Center");
	}
	public static void main (String args[]) {
		// opção simplificada de início da aplicação
		new BorderDemo().setVisible(true);
} }
