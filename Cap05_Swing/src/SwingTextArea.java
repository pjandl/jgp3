/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.10
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingTextArea extends JFrame implements ItemListener {
	private JTextArea textArea;
	private JRadioButton rbNoWrap, rbWordWrap, rbCharWrap;

	public SwingTextArea() {
		super("SwingTextArea"); // ajusta titulo
		Container cp = getContentPane(); // painel de conteudo
		// layout grade 1x3
		JPanel pTop = new JPanel(new GridLayout(1, 3, 2, 2));
		pTop.setBorder(BorderFactory.createTitledBorder( // borda
				BorderFactory.createEtchedBorder(), "Quebra de Linha"));
		pTop.add(rbNoWrap = new JRadioButton("Sem quebra", true));
		pTop.add(rbWordWrap = new JRadioButton("Palavras"));
		pTop.add(rbCharWrap = new JRadioButton("Caracteres"));
		cp.add(pTop, "North");
		ButtonGroup bg = new ButtonGroup(); // grupo de radios
		rbNoWrap.addItemListener(this);
		bg.add(rbNoWrap);
		rbWordWrap.addItemListener(this);
		bg.add(rbWordWrap);
		rbCharWrap.addItemListener(this);
		bg.add(rbCharWrap);
		JScrollPane sp = new JScrollPane(textArea = new JTextArea());
		sp.setPreferredSize(new Dimension(300, 150)); // ajustes do scrollpane
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		cp.add(sp, "Center");
		pack(); // autodimensiona janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
	}

	@Override
	public void itemStateChanged(ItemEvent e) { // classe implementa listener
		textArea.setLineWrap(!rbNoWrap.isSelected());
		textArea.setWrapStyleWord(rbWordWrap.isSelected());
		textArea.repaint();
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingTextArea().setVisible(true);
			}
		});
	}
}
