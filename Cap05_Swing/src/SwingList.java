/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.15
 */
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class SwingList extends JFrame implements ItemListener,
		ListSelectionListener {
	private String opcoes[] = { "Simples", "Intervalo", "Múltipla" };
	private String elem[] = { "Um", "Dois", "Três", "Quatro", "Cinco", "Seis",
			"Sete" };
	private JRadioButton rb[] = new JRadioButton[3];
	private JList<String> lista = new JList<>(elem); // cria lista com elementos
	private JLabel lSel;

	public SwingList() {
		setTitle("Swing List"); // ajusta titulo
		Container cp = getContentPane(); // painel de conteudo
		JPanel pRadio = new JPanel(new GridLayout(1, 3));
		ButtonGroup bg = new ButtonGroup(); // grupo de radios
		for (int i = 0; i < 3; i++) { // cria e agrupa radios
			pRadio.add(rb[i] = new JRadioButton(opcoes[i]));
			rb[i].addItemListener(this);
			bg.add(rb[i]);
		}
		cp.add(pRadio, "North");
		cp.add(new JScrollPane(lista), "Center");
		cp.add(lSel = new JLabel("Sem Seleção"), "South");
		lista.addListSelectionListener(this); // listener para lista
		rb[0].setSelected(true); // seleciona modo default
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
		pack(); // autodimensiona janela
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rb[0]) { // ajusta modo de selecao
			lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		} else if (e.getSource() == rb[1]) {
			lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		} else {
			lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int itens[] = lista.getSelectedIndices(); // obtem selecao
		if (itens.length > 0) { // verifica selecao
			StringBuffer sb = new StringBuffer();
			// cria lista com selecao
			for (int i = 0; i < itens.length - 1; i++) {
				sb.append(itens[i]);
				sb.append(",");
			}
			sb.append(itens[itens.length - 1]);
			lSel.setText("Seleção: " + sb.toString());
		} else {
			lSel.setText("Sem Seleção");
		}
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater( // expressão lambda
				() -> {
					new SwingList().setVisible(true);
				});
	}
}
