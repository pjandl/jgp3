/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.19
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class TestaFila extends JFrame implements ActionListener {
	private JTextArea taVisaoFila; // textarea para conteudo da fila
	private JTextField tfDado; // textfield para entrada
	private JButton botao[] = new JButton[6]; // botoes de controle
	private String cmd[] = { "Add", "Remove", "Element ", "Offer", "Pool",
			"Peek" };
	private Queue<String> fila = new LinkedList<>(); // fila

	public TestaFila() {
		super("TestaFila");
		// instancia componentes e os organiza em paineis
		JPanel pTop = new JPanel(new GridLayout(2, 3, 3, 3));
		for (int i = 0; i < cmd.length; i++) {
			botao[i] = new JButton(cmd[i]);
			botao[i].addActionListener(this);
			pTop.add(botao[i]);
		}
		taVisaoFila = new JTextArea();
		JScrollPane sp = new JScrollPane(taVisaoFila);
		JPanel pBot = new JPanel(new BorderLayout());
		pBot.add("West", new JLabel("Elemento"));
		pBot.add("Center", tfDado = new JTextField());
		// adiciona componentes ao JFrame
		getContentPane().add("North", pTop);
		getContentPane().add("Center", sp);
		getContentPane().add("South", pBot);
		// outros ajuste na interface
		taVisaoFila.setEditable(false);
		taVisaoFila.setText(fila.toString()); // atualiza visao da fila
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i; // determina indice do botao foi acionado
		for (i = 0; i < 6; i++) {
			if (e.getSource() == botao[i])
				break;
		}
		if (i == 6)
			return; // em caso de erro
		try { // monitora excecoes nas operacoes
			switch (i) { // operacoes conforme array cmd
			case 0:
				fila.add(tfDado.getText());
				tfDado.setText("");
				break;
			case 1:
				tfDado.setText(fila.remove());
				break;
			case 2:
				tfDado.setText(fila.element());
				break;
			case 3:
				fila.offer(tfDado.getText());
				tfDado.setText("");
				break;
			case 4:
				tfDado.setText(fila.poll());
				break;
			case 5:
				tfDado.setText(fila.peek());
				break;
			}
		} catch (RuntimeException rte) { // exibe eventual excecao
			JOptionPane.showMessageDialog(this, rte.toString());
		}
		taVisaoFila.setText(fila.toString()); // atualiza visao da fila
	}

	public static void main(String a[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TestaFila().setVisible(true);
			}
		});
	}
}
