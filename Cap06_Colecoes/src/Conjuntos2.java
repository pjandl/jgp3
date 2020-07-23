/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.17
 */
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Conjuntos2 extends JFrame {
	private JTextArea taRes;
	private JButton bIncluir, bRemover, bContem;
	private List<Collection<String>> col = new ArrayList<>(); // coleções

	public Conjuntos2() {
		super("Conjuntos2"); // ajusta titulo
		// painel superior
		JPanel pTop = new JPanel();
		JPanel pAux = new JPanel(new GridLayout(1, 3, 5, 5));
		pAux.add(bIncluir = new JButton("Incluir"));
		pAux.add(bRemover = new JButton("Remover"));
		pAux.add(bContem = new JButton("Contém?"));
		pTop.add(pAux);
		// area central
		JScrollPane sp = new JScrollPane(taRes = new JTextArea());
		taRes.setEditable(false);
		// adicione componentes ao JFrame
		add("North", pTop);
		add("Center", sp);
		// instancia coleções usadas
		col.add(new ArrayList<String>()); // lista
		col.add(new HashSet<String>()); // conjunto
		col.add(new LinkedHashSet<String>()); // conjunto
		col.add(new TreeSet<String>()); // conjunto ordenado
		// referência de método e expressão lambda
		ActionListener alGeral = (e) -> {
			String elem = JOptionPane.showInputDialog(Conjuntos2.this,
					"Elemento?", "");
			// verifica elemento fornecido e seleciona ação
			if (elem == null || elem.trim().length() == 0) {
				return;
			} else if (e.getSource() == bIncluir) {
				incluir(elem);
			} else if (e.getSource() == bRemover) {
				remover(elem);
			} else if (e.getSource() == bContem) {
				contem(elem);
			}
			mostraConteudos();
		};
		// registra eventos
		bIncluir.addActionListener(alGeral);
		bRemover.addActionListener(alGeral);
		bContem.addActionListener(alGeral);
		// ajustes gerais do JFrame
		getRootPane().setDefaultButton(bIncluir);
		setSize(300, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// inicia textarea
		mostraConteudos();
	}

	protected void incluir(String elem) { // acao do botao bIncluir
		for (Collection<String> c : col)
			c.add(elem);
	}

	protected void remover(String elem) { // acao do botao bRemover
		String s_n = col.get(0).contains(elem) ? "' removido."
				: "' não encontrado.";
		if (col.get(0).contains(elem)) {
			for (Collection<String> c : col)
				c.remove(elem);
		}
		JOptionPane.showMessageDialog(this, "Objeto '" + elem + s_n, "Remover",
				JOptionPane.INFORMATION_MESSAGE);
	}

	protected void contem(String elem) { // acao do botao bContem
		String s_n = col.get(0).contains(elem) ? "'" : "' não";
		JOptionPane.showMessageDialog(this, "Objeto '" + elem + s_n
				+ " encontrado.", "Contém?", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostraConteudos() { // metodo auxiliar
		taRes.setText("Elementos Distintos = " + col.get(3).size());
		for (Collection<String> c : col) {
			taRes.append("\n");
			taRes.append(c.getClass().getSimpleName());
			taRes.append(c.toString());
		}
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Conjuntos2().setVisible(true);
			}
		});
	}
}
