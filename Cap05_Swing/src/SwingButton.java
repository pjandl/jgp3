/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.7
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingButton extends JFrame implements ActionListener {
	private JLabel label1;
	private JButton button1;
	private int count = 0; // contador de clicks
	private final String msg = "N�mero de clicks: ";

	public SwingButton() {
		setTitle("Swing Button"); // ajusta titulo
		Container cp = getContentPane(); // painel de conteudo
		cp.setLayout(new FlowLayout()); // ajusta layout FlowLayout
		cp.setBackground(Color.orange); // ajusta cor de fundo
		// instanciação e adição
		cp.add(button1 = new JButton("Bot�o Swing"));
		cp.add(label1 = new JLabel(msg + count));
		button1.addActionListener(this); // listener
		button1.setMnemonic('S'); // tecla de atalho
		button1.setToolTipText("Clique aqui para contar."); // dica
		setSize(300, 75);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		++count;
		label1.setText(msg + count);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingButton().setVisible(true);
			}
		});
	}
}
