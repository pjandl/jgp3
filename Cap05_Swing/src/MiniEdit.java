/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.18
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MiniEdit extends JFrame {
	private JTextArea taEditor;
	private static String sArquivo[] = { "Novo", "new16.gif", "N", "Abrir ...",
			"open16.gif", "A", "Salvar", "save16.gif", "S", "Salvar como ...",
			"saveas16.gif", "c", null, "Imprimir ...", "print16.gif", "I",
			null, "Sair", "blank16.gif", "r" };
	private static String sEditar[] = { "Recortar", "cut16.gif", "R", "Copiar",
			"copy16.gif", "C", "Colar", "paste16.gif", "o", null, "Excluir",
			"delete16.gif", "x", "Selecionar tudo", "blank16.gif", "t", null };
	private static String sAjuda[] = { "Ajuda", "help16.gif", "A", null,
			"Sobre ...", "about16.gif", "S" };

	public MiniEdit() {
		super("MiniEdit");
		JMenuBar mb = new JMenuBar();
		MenuHandler mh = new MenuHandler();
		MenuBuilder.imagePrefix = "images/";
		mb.add(MenuBuilder.newMenu("Arquivo", 'A', sArquivo, mh));
		JMenu menu = MenuBuilder.newMenu("Editar", 'E', sEditar, mh);
		JMenuItem mi = menu.add(new JCheckBoxMenuItem("Quebra de Linha"));
		mi.addActionListener(mh);
		mb.add(menu);
		mb.add(MenuBuilder.newMenu("Ajuda", 'u', sAjuda, mh));
		setJMenuBar(mb);
		JScrollPane sp = new JScrollPane(taEditor = new JTextArea());
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().add(sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MiniEdit().setVisible(true);
			}
		});
	}

	private class MenuHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String acao = ((JMenuItem) e.getSource()).getText();
			taEditor.append(acao + "\n");
			if (acao.equals("Sair"))
				System.exit(0);
		}
	}
}
