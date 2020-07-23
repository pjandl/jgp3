/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 5.2
 */
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SwingDialog extends JDialog {
	public SwingDialog(Frame resp, boolean modal) {
		// ajusta responsável, título e operação modal
		super(resp, "Swing Dialog", modal);
		setSize(250, 90); // ajusta tamanho
		// ajusta posição em relação a janela responsável
		setLocation(resp.getX() + getWidth() + 10, resp.getY());
		add(new JLabel("Dialogo")); // conteúdo
	}
}
