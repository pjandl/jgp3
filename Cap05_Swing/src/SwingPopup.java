/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.19
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SwingPopup extends JFrame implements ActionListener {
	private JTextArea output = new JTextArea(); // area de edicao
	private JPopupMenu popup = new JPopupMenu(); // menu popup
	private String menuItens[] = { "Recortar", "Copiar", "Colar" };

	public SwingPopup() {
		super("SwingPopup");
		getContentPane().add(new JScrollPane(output), "Center");
		for (String item : menuItens) { // itens do popup
			JMenuItem mi = new JMenuItem(item); // cria item do menu
			mi.addActionListener(this); // registra listener
			popup.add(mi); // adiciona ao popup
		}
		output.addMouseListener(new PopupHandler()); // listener para popup
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 260);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // listener p/ itens do popup
		String acao = ((JMenuItem) e.getSource()).getText();
		if (acao.equals("Recortar")) {
			output.cut(); // cut text (recortar)
		} else if (acao.equals("Copiar")) {
			output.copy(); // copy text (copiar)
		} else {
			output.paste(); // paste text (colar)
		}
	}

	public static void main(String[] args) {
		new SwingPopup().setVisible(true);
	}

	private class PopupHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			mouseReleased(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) { // exibe popup se acionado botao correto
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}
}
