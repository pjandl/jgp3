/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.14
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingTabs extends JFrame implements ActionListener {
	private JTabbedPane tabs; // painel de abas
	private JButton bAnt, bProx; // botoes de navegacao

	public SwingTabs() {
		super("Swing Tabs"); // ajusta titulo
		tabs = new JTabbedPane();
		ImageIcon icon = new ImageIcon("images/selected.gif");
		/* Aba 1 */
		JTextArea ta = new JTextArea();
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		tabs.addTab("Aba 1", icon, new JScrollPane(ta), "Primeira Aba");
		/* Aba 2 */
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.white);
		panel2.add(new JButton("Conteúdo da Aba 2"));
		tabs.addTab("Aba 2", icon, panel2, "Segunda Aba");
		/* Aba 3 */
		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("Conteúdo da Aba 3"));
		tabs.addTab("", icon, panel3);
		/* Aba 4 */
		tabs.addTab("Aba 4", new JLabel(new ImageIcon("images/mini-j.gif")));
		// adiciona painel de abas na area central da janela
		getContentPane().add(tabs, "Center");
		JPanel p1 = new JPanel(); // painel inferior
		JPanel p2 = new JPanel(new GridLayout(1, 2, 5, 5)); // auxiliar
		p2.add(bAnt = new JButton("<< Anterior")); // botoes
		p2.add(bProx = new JButton("Próxima >>"));
		p1.add(p2);
		getContentPane().add(p1, "South"); // adiciona a janela
		bAnt.addActionListener(this); // registro listener
		bProx.addActionListener(this);
		setSize(400, 180); // dimensiona janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = tabs.getSelectedIndex();
		if (e.getSource() == bAnt) {
			tabs.setSelectedIndex(i > 0 ? i - 1 : tabs.getTabCount() - 1);
		} else {
			tabs.setSelectedIndex(i < tabs.getTabCount() - 1 ? i + 1 : 0);
		}
	}

	public static void main(String s[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingTabs().setVisible(true);
			}
		});
	}
}
