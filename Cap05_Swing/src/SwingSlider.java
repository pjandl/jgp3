/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.23
 */
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SwingSlider extends JFrame implements ChangeListener {
	private JLabel lAlvo; // rotulo
	private JPanel pCenter; // painel auxiliar
	private JSlider sHor, sVer; // sliders

	public SwingSlider() {
		super("SwingSlider"); // ajusta titulo
		pCenter = new JPanel(null); // painel auxiliar com layout nulo
		pCenter.setBackground(Color.white); // cor de fundo do painel
		pCenter.add(lAlvo = new JLabel()); // adiciona rotulo ao painel
		lAlvo.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		sVer = new JSlider(JSlider.VERTICAL, 20, 140, 20); // sliders
		sHor = new JSlider(JSlider.HORIZONTAL, 20, 200, 20);
		adjustSlider(sVer, 10, 40, true, true, true, this); // ajusta sliders
		adjustSlider(sHor, 20, 20, true, false, false, this);
		getContentPane().add(sHor, "South");
		getContentPane().add(pCenter, "Center");
		getContentPane().add(sVer, "East");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
		setSize(300, 150); // dimensiona janela
		stateChanged(null); // aciona listener para ajustar alvo
	}

	private void adjustSlider(JSlider slider, int minTS, int maxTS, boolean pT,
			boolean pL, boolean inv, ChangeListener cl) {
		slider.setMinorTickSpacing(minTS); // espacamento fino
		slider.setMajorTickSpacing(maxTS); // espacamento grosso
		slider.setPaintTicks(pT); // exibe escala
		slider.setPaintLabels(pL); // exibe rotulos da escala
		slider.setInverted(inv); // inverte escala
		slider.addChangeListener(cl); // registro do listener
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		lAlvo.setSize(sHor.getValue(), sVer.getValue()); // muda tamanho rotulo
		lAlvo.setText(sHor.getValue() + "x" + sVer.getValue()); // tamanho do
																// rotulo
		pCenter.doLayout(); // ajusta layout do painel auxiliar
	}

	public static void main(String s[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingSlider().setVisible(true);
			}
		});
	}
}
