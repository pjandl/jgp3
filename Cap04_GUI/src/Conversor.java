/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 4.1
 */
import java.awt.*; // importa��o dos pacotes t�picos para GUI
import java.awt.event.*;
import javax.swing.*;
import java.text.*; // pacote para formatador decimal

@SuppressWarnings("serial")
public class Conversor extends JFrame {
	private JTextField tfValor1, tfValor2; // componentes ativos
	private JButton bLimpar, bConverter;
	private JLabel lUnidade1, lUnidade2; // componentes n�o ativos
	DecimalFormat df = new DecimalFormat("#,##0.00"); // formatador decimal

	public Conversor() { // construtor
		super("Conversor"); // ajusta t�tulo da janela
		lUnidade1 = new JLabel("Celsius"); // instancia componentes
		lUnidade2 = new JLabel("Farenheit");
		tfValor1 = new JTextField();
		tfValor2 = new JTextField();
		bLimpar = new JButton("Limpar");
		bLimpar.setToolTipText("Limpa as caixas de entrada");
		bConverter = new JButton("Converter");
		bConverter.setToolTipText("Efetua convers�o do valor dado");
		Container cp = getContentPane(); // obt�m container
		cp.setLayout(new GridLayout(3, 2, 5, 5)); // ajusta layout
		cp.add(lUnidade1);
		cp.add(tfValor1); // adi��o dos componentes
		cp.add(lUnidade2);
		cp.add(tfValor2);
		cp.add(bLimpar);
		cp.add(bConverter);
		bLimpar.addActionListener( // listener com express�o lambda
		(e) -> {
			bLimparClick();
		});
		// bLimpar.addActionListener(new ActionListener() { // listener com
		// classe an�nima
		// @Override
		// public void actionPerformed(ActionEvent e) { // limpar
		// bLimparClick();
		// } } );
		// bConverter.addActionListener( // listener com express�o lambda
		// (e) -> { bConverterClick(); }
		// );
		bConverter.addActionListener(new ActionListener() { // listener com
															// classe an�nima
					@Override
					public void actionPerformed(ActionEvent e) { // converter
						bConverterClick();
					}
				});
		cp.setBackground(Color.orange); // ajustes para janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	private void bLimparClick() { // limpa caixas de texto
		tfValor1.setText("");
		tfValor2.setText("");
	}

	private void bConverterClick() { // efetua convers�o
		// C -> F se tfValor2 vazia e tfValor1 com conte�do
		if (tfValor2.getText().equals("") && !tfValor1.getText().equals("")) {
			try {
				double res = 9 * Double.parseDouble(tfValor1.getText()) / 5 + 32;
				tfValor1.setText("");
				tfValor2.setText("" + df.format(res));
			} catch (NumberFormatException exc) {
				tfValor1.selectAll();
				tfValor1.requestFocus();
				Toolkit.getDefaultToolkit().beep();
			}
			// F -> C se tfValor1 vazia e tfValor2 com conte�do
		} else if (tfValor1.getText().equals("")
				&& !tfValor2.getText().equals("")) {
			try {
				double res = 5 * (Double.parseDouble(tfValor2.getText()) - 32) / 9;
				tfValor2.setText("");
				tfValor1.setText("" + df.format(res));
			} catch (NumberFormatException exc) {
				tfValor2.selectAll();
				tfValor2.requestFocus();
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}

	public static void main(String a[]) { // in�cio da aplica��o
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// instancia��o e exibi��o da janela principal
				new Conversor().setVisible(true);
			}
		});
	}
}
