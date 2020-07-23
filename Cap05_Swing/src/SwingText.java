/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.9
 */
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingText extends JFrame implements ActionListener {
	private JLabel lRes;
	private JButton bConv;
	private JTextField tfC;

	public SwingText() {
		setTitle("Conversor C->F"); // ajusta titulo
		Container cp = getContentPane(); // painel de conteudo
		cp.setLayout(new GridLayout(2, 2, 1, 1)); // layout grade 2x2
		cp.add(tfC = new JTextField());
		cp.add(new JLabel("Celsius", JLabel.RIGHT));
		cp.add(bConv = new JButton("Converter", new ImageIcon(
				"images/about16.gif")));
		cp.add(lRes = new JLabel("Fahrenheit", JLabel.RIGHT));
		tfC.addActionListener(this); // registro do listener
		tfC.setToolTipText("Temperatura em Celsius");
		bConv.addActionListener(this); // registro do listener
		bConv.setToolTipText("Converte temperatura para Fahrenheit");
		getRootPane().setDefaultButton(bConv); // botao como default
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); // autodimensiona janela
	}

	@Override
	public void actionPerformed(ActionEvent e) { // classe implementa listener
		try { // conversao de temperatura
			float temp = 1.8f * Float.parseFloat(tfC.getText()) + 32;
			lRes.setText(temp + "F");
		} catch (NumberFormatException nfe) {
			lRes.setText("Valor inválido!");
		}
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingText().setVisible(true);
			}
		});
	}
}
