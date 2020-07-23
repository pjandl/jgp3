/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.8
 */
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingOptions extends JFrame {
	private JRadioButton rb[] = new JRadioButton[3]; // array para radio
	private JCheckBox cb[] = new JCheckBox[3]; // array para checkbox
	private JLabel lRadio, lCheck;

	public SwingOptions() {
		setTitle("Swing Option Buttons"); // ajusta titulo
		Container cp = getContentPane(); // painel de conte�do
		cp.setLayout(new GridLayout(1, 2)); // layout grade 1x2
		JPanel pRadio = new JPanel(new GridLayout(4, 1)); // painel auxiliar
		pRadio.setBorder(BorderFactory.createEtchedBorder());
		JPanel pCheck = new JPanel(new GridLayout(4, 1)); // painel auxiliar
		pCheck.setBorder(BorderFactory.createEtchedBorder());
		// listeners para radiobuttons e checkboxes com express�es lambda
		ItemListener ril = (e) -> {
			JRadioButton rb = (JRadioButton) e.getSource();
			String item = rb.getText();
			lRadio.setText("Sele��o: " + item.charAt(item.length() - 1));
		};
		ItemListener cil = (e) -> {
			StringBuffer itens = new StringBuffer("Sele��o: ");
			for (int i = 0; i < 3; i++)
				itens.append(cb[i].isSelected() ? (i + 1) + " " : "");
			lCheck.setText(itens.toString());
		};
		ButtonGroup bg = new ButtonGroup(); // grupo para radios
		for (int i = 0; i < 3; i++) { // la�o para montar paineis
			pRadio.add(rb[i] = new JRadioButton("Alternativa " + (i + 1)));
			rb[i].addItemListener(ril); // usa refer�ncia de m�todo ril
			bg.add(rb[i]);
			pCheck.add(cb[i] = new JCheckBox("Alternativa " + (i + 1)));
			cb[i].addItemListener(cil); // usa refer�ncia de m�todo cil
		}
		pRadio.add(lRadio = new JLabel("Sele��o: "));
		cp.add(pRadio);
		pCheck.add(lCheck = new JLabel("Sele��o: "));
		cp.add(pCheck);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); // autodimensiona janela
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingOptions().setVisible(true);
			}
		});
	}
}
