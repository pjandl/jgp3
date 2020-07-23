/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.11
 */
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingPassword extends JFrame {
	private JLabel lRes;
	private JPasswordField pf;
	private JButton bAnalisar;

	public SwingPassword() {
		setTitle("Senhas"); // ajusta titulo
		Container cp = getContentPane(); // painel de conteudo
		cp.setLayout(new GridLayout(1, 4, 1, 1)); // layout grade 1x2
		cp.add(new JLabel("Senha", JLabel.RIGHT));
		cp.add(pf = new JPasswordField(10));
		cp.add(bAnalisar = new JButton("Analisar"));
		cp.add(lRes = new JLabel()); // resultado
		lRes.setOpaque(true); // para rótulo não seja transparente
		bAnalisar.addActionListener((e) -> { // expressão lambda
					PasswordStrength forca = PasswordStrength
							.evaluateStrength(pf.getPassword());
					lRes.setText(forca.toString());
					lRes.setBackground(forca.getColor());
				});
		getRootPane().setDefaultButton(bAnalisar); // botao como default
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); // autodimensiona janela
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingPassword().setVisible(true);
			}
		});
	}
}
