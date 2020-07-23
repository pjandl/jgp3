/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.21
 */
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingOptionPane extends JFrame {
	private static String[] acao = { "Informação", "Aviso", "Erro", "Mensagem",
			"Input", "Entrada", "Aplicação", "Aviso2", "Confirmação" }; // acoes
	private JButton[] b = new JButton[acao.length]; // botoes

	public SwingOptionPane() {
		super("SwingOptionPane"); // ajusta titulo
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2, b.length / 2)); // layout grade
		ActionListener al = (evt) -> { // expressão lambda
			JButton b = (JButton) evt.getSource();
			String a = b.getText();
			if (a.equals(acao[0])) {
				JOptionPane.showMessageDialog(SwingOptionPane.this,
						"Uma informação para o usuário", acao[0],
						JOptionPane.INFORMATION_MESSAGE);
			} else if (a.equals(acao[1])) {
				JOptionPane.showMessageDialog(SwingOptionPane.this,
						"Um aviso para o usuário", acao[1],
						JOptionPane.WARNING_MESSAGE);
			} else if (a.equals(acao[2])) {
				JOptionPane.showMessageDialog(SwingOptionPane.this,
						"Um erro para o usuário", acao[2],
						JOptionPane.ERROR_MESSAGE);
			} else if (a.equals(acao[3])) {
				JOptionPane.showMessageDialog(SwingOptionPane.this,
						"Uma mensagem qualquer", acao[3],
						JOptionPane.PLAIN_MESSAGE);
			} else if (a.equals(acao[4])) {
				JOptionPane.showInputDialog("Forneça um inteiro");
			} else if (a.equals(acao[5])) {
				JOptionPane.showInputDialog(SwingOptionPane.this,
						"Digite o nome", acao[5],
						JOptionPane.INFORMATION_MESSAGE);
			} else if (a.equals(acao[6])) {
				JOptionPane.showConfirmDialog(SwingOptionPane.this,
						"Encerrar aplicação?", acao[6],
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
			} else if (a.equals(acao[7])) {
				JOptionPane.showConfirmDialog(SwingOptionPane.this,
						"Deseja continuar?", acao[7],
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			} else {
				Object[] options = { "Sim", "Não" };
				JOptionPane.showOptionDialog(null, "Deseja continuar?",
						acao[8], JOptionPane.YES_NO_OPTION,
						JOptionPane.ERROR_MESSAGE, null, options, options[0]);
			}
		};
		for (int i = 0; i < b.length; i++) {
			b[i] = new JButton(acao[i]);
			cp.add(b[i]);
			b[i].addActionListener(al);
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingOptionPane().setVisible(true);
			}
		});
	}
}
