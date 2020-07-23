/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 7.18
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ThreadMonitor extends JFrame {
	private ThreadTree monitor;
	private JButton bNew, bRefresh;
	private int gruposCriados = 0;

	public ThreadMonitor() {
		super("ThreadMonitor");
		monitor = ThreadTree.getInstance();
		monitor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//
		Container cp = getContentPane();
		cp.add("Center", monitor);
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new GridLayout(1, 2, 3, 3));
		p2.add(bNew = new JButton("Novo Grupo"));
		p2.add(bRefresh = new JButton("Atualizar"));
		p1.add(p2);
		cp.add("South", p1);
		//
		bNew.addActionListener((e) -> { // expressao lambda
			criaGrupo(); // cria novo grupo
		});
		ActionListener al = (e) -> { // expressao lambda
			monitor.refresh(); // atualiza ThreadTree
		};
		bRefresh.addActionListener(al);
		new Timer(30000, al).start(); // timer para auto-refresh
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public void criaGrupo() { // cria grupo extra na raiz
		Thread threadMain = Thread.currentThread(); // determina grupo raiz
		ThreadGroup grupoRaiz = threadMain.getThreadGroup().getParent();
		ThreadGroup newGroup = new ThreadGroup(grupoRaiz, "Extra-"
				+ gruposCriados++);
		newGroup.setDaemon(true); // ajusta auto-remocao do grupo
		int quant = (int) (Math.random() * 10);
		for (int i = 0; i < quant; i++) { // adiciona EmptyThreads ao grupo
			new EmptyThread(newGroup, "EmptyThread-" + i).start();
		}
		bRefresh.doClick();
	}

	private class EmptyThread extends Thread {
		public EmptyThread(ThreadGroup group, String name) {
			super(group, name);
		}

		public void run() {
			int time = (int) (Math.random() * 120);
			for (int i = 0; i < time; i++) {
				try {
					sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		}
	}

	//
	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ThreadMonitor().setVisible(true);
			}
		});
	}
	//
}
