/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.16
 */
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingTable2 extends JFrame {
	private JTable tabela;

	public SwingTable2() { // Construtor
		setTitle("Gases Nobres 2");
		tabela = new JTable(new GNTableModel());
		getContentPane().add(new JScrollPane(tabela), "Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 150);
	}

	//
	public static void main(String a[]) { // main
		SwingUtilities.invokeLater(() -> {
			new SwingTable2().setVisible(true);
		});
	}
	//
}
