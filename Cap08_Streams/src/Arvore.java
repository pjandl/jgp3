/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 8.12
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

@SuppressWarnings("serial")
public class Arvore extends JFrame implements TreeSelectionListener {
	private JTree arvore;
	private JLabel lSel;

	public Arvore(String dir, boolean main) {
		super("�rvore de Diret�rios");
		arvore = new JTree(criaNos(new DefaultMutableTreeNode(new File(dir))));
		arvore.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		arvore.addTreeSelectionListener(this);
		arvore.addMouseListener(new TreeMouseListener());
		getContentPane().add("Center", new JScrollPane(arvore));
		getContentPane().add("South",
				lSel = new JLabel("diret�rio (" + dir + ")"));
		setDefaultCloseOperation(main ? EXIT_ON_CLOSE : DISPOSE_ON_CLOSE);
		pack();
	}

	private DefaultMutableTreeNode criaNos(DefaultMutableTreeNode raiz) {
		File arq[] = ((File) raiz.getUserObject()).listFiles();
		for (int i = 0; i < arq.length; i++) {
			DefaultMutableTreeNode no = new DefaultMutableTreeNode(arq[i]);
			if (arq[i].isDirectory()) {
				criaNos(no);
			}
			raiz.add(no);
		}
		return raiz;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode no = (DefaultMutableTreeNode) arvore
				.getLastSelectedPathComponent();
		if (no == null)
			return;
		File arq = (File) no.getUserObject();
		if (no.isLeaf()) {
			lSel.setText("arquivo (" + arq.getName() + ", " + arq.length()
					+ " bytes)");
		} else {
			try {
				lSel.setText("diret�rio (" + arq.getAbsolutePath() + ")");
			} catch (SecurityException se) {
				showError("Diret�rio n�o pode ser determinado.", se);
			}
		}
	}

	//
	private void showError(String msg, Exception e) {
		JOptionPane.showMessageDialog(this, msg, "�rvore",
				JOptionPane.ERROR_MESSAGE);
		System.err.println(e);
	}

	public static void main(final String[] a) {
		SwingUtilities.invokeLater(() -> {
			new Arvore(a.length == 0 ? "." : a[0], true).setVisible(true);
		});
	}

	//

	private class TreeMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int selRow = arvore.getRowForLocation(e.getX(), e.getY());
			TreePath selPath = arvore.getPathForLocation(e.getX(), e.getY());
			if (selRow != -1 && e.getClickCount() == 2) {
				arvore.setSelectionPath(selPath);
				DefaultMutableTreeNode no = (DefaultMutableTreeNode) arvore
						.getLastSelectedPathComponent();
				if (no == null) {
					return;
				}
				File arq = (File) no.getUserObject();
				if (no.isLeaf()) {
					String fName = arq.getAbsolutePath();
					if (fName.endsWith(".txt") || fName.endsWith(".java")) {
						String os = System.getProperty("os.name").toLowerCase();
						try { // identifica SO para usar comando correto
							if (os.indexOf("mac") != -1) {
								Runtime.getRuntime().exec("open " + fName);
							} else if (os.indexOf("win") != -1) {
								Runtime.getRuntime().exec("notepad " + fName);
							} else {
								return;
							}
						} catch (Exception exc) {
							showError("Arquivo '" + arq.getAbsolutePath()
									+ "' não pode ser aberto.", exc);
						}
					}
				} else {
					if (!arq.getPath().equals(".")) {
						new Arvore(arq.getPath(), false).setVisible(true);
					}
				}
			}
		}
	}
}
