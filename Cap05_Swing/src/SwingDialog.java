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
		// ajusta respons�vel, t�tulo e opera��o modal
		super(resp, "Swing Dialog", modal);
		setSize(250, 90); // ajusta tamanho
		// ajusta posi��o em rela��o a janela respons�vel
		setLocation(resp.getX() + getWidth() + 10, resp.getY());
		add(new JLabel("Dialogo")); // conte�do
	}
}
