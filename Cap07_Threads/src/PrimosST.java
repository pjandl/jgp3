/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.4
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PrimosST extends JFrame implements ActionListener {
	private PrimosPanel pp; // componente de interface
	private boolean stop; // variavel de controle do processamento

	public PrimosST() {
		super("Primos Sem Thread");
		setContentPane(pp = new PrimosPanel());
		pp.getButton1().addActionListener(this);
		pp.getButton2().addActionListener(this);
		pp.getButton3().addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pp.getButton3()) {
			try {
				pp.getButton2().setEnabled(false);
				pp.getButton3().setEnabled(false);
				calcPrimos(Integer.parseInt(pp.getTextField1().getText()),
						Integer.parseInt(pp.getTextField2().getText()));
				pp.getButton2().setEnabled(true);
				pp.getButton3().setEnabled(true);
			} catch (NumberFormatException nfe) {
				pp.getTextArea().setText("Intervalo inválido!");
				return;
			}
		} else if (e.getSource() == pp.getButton2()) {
			pp.getTextArea().setText(null);
		} else {
			stop = true;
			pp.getButton2().setEnabled(true);
			pp.getButton3().setEnabled(true);
		}
	}

	public void calcPrimos(int inicio, int fim) {
		pp.getTextArea().setText("Calculando:\n");
		stop = false;
		for (int n = inicio; n <= fim && !stop; n++) {
			int i;
			for (i = 2; i <= n; i++)
				if (n % i == 0)
					break;
			if (i == n)
				pp.getTextArea().append(n + ", ");
		}
		pp.getTextArea().append("\n");
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(() -> {
			new PrimosST().setVisible(true);
		});
	}
}
