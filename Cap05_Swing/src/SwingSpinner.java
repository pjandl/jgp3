/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.24
 */
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SwingSpinner extends JFrame implements ChangeListener {
	private JLabel lAlvo; // rotulo
	private JSpinner spFSize; // Spinner
	private SpinnerNumberModel snm; // declara modelo para spinner

	public SwingSpinner() {
		super("Swing Spinner"); // ajusta titulo
		Container cp = getContentPane(); // painel de conteudo
		lAlvo = new JLabel("PeterJandlJr2015"); // cria rotulo
		cp.add("Center", new JScrollPane(lAlvo));
		// cria um modelo numerico para o JSpinner
		snm = new SpinnerNumberModel(lAlvo.getFont().getSize(), 6, 72, 2);
		spFSize = new JSpinner(snm); // cria spinner com modelo
		spFSize.addChangeListener(this); // registra listener
		JPanel pAux = new JPanel(); // painel auxiliar
		pAux.add(new JLabel("Tamanho do Fonte"));
		pAux.add(spFSize);
		cp.add("South", pAux);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
		setSize(300, 130); // dimensiona janela
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Font f = lAlvo.getFont(); // obtem fonte do rotulo
		float valor = snm.getNumber().floatValue(); // obtem valor do spinner
		// ajusta fonte do label com outro derivado
		lAlvo.setFont(f.deriveFont(valor));
		lAlvo.validate(); // valida exibição
	}

	public static void main(String s[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingSpinner().setVisible(true);
			}
		});
	}
}
