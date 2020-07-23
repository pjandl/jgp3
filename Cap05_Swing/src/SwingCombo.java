/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.16
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingCombo extends JFrame {
	private JComboBox<String> combo; // combo para padroes
	private JLabel resultado; // rotulo para resultados
	public static final String padrao[] = { "dd MMMMM yyyy", "dd.MM.yy",
			"MM/dd/yy", "yyyy.MM.dd hh:mm:ss z", "EEE, MMM d, _yy", "h:mm a",
			"H:mm:ss:SSS", "K:mm a,z", "yyyy.MMMMM.dd GGG hh:mm aaa" };

	public SwingCombo() {
		super("SwingCombo"); // ajusta titulo
		Container cp = getContentPane(); // painel de conteudo
		cp.setLayout(new GridLayout(4, 1)); // layout grade 4x1
		cp.add(new JLabel("Forneça um padrão ou selecione da lista:"));
		cp.add(combo = new JComboBox<>(padrao)); // combo e seus ajustes
		combo.setEditable(true);
		combo.addActionListener( // expressao lambda
		(e) -> {
			formatar((String) combo.getSelectedItem());
		});
		cp.add(new JLabel("Hora e Data Atuais:", JLabel.LEFT));
		cp.add(resultado = new JLabel()); // rotulo para resultados
		resultado.setForeground(Color.black); // ajustes para rotulo
		resultado.setBorder(BorderFactory.createMatteBorder(2, 2, 3, 2,
				Color.green));
		formatar(padrao[0]); // formata hora com 1o padrÃ£o
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
		pack(); // autodimensiona janela
	}

	public void formatar(String padrao) { // formata data com padrao
		try { // cria e usa formatador de data-hora com padrao dado
			SimpleDateFormat sdf = new SimpleDateFormat(padrao);
			resultado.setForeground(Color.black);
			resultado.setText(sdf.format(new Date()));
		} catch (IllegalArgumentException iae) {
			resultado.setForeground(Color.red);
			resultado.setText(iae.getMessage());
		}
	}

	public static void main(String s[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingCombo().setVisible(true);
			}
		});
	}
}
