/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.14
 */
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingTable extends JFrame {
	private JTable tabela;
	private String[] colunas = { "Símb", "Nome", "NAtom", "M Atom", "M Espec" };
	private Object[][] dados = { // Dados da tabela
			{ "He", "Hélio", new Integer(2), new Double(4.0026),
					new Double(0.179) },
			{ "Ne", "Neônio", new Integer(10), new Double(20.17),
					new Double(0.90) },
			{ "Ar", "Argônio", new Integer(18), new Double(39.94),
					new Double(1.78) },
			{ "Kr", "Criptônio", new Integer(36), new Double(83.80),
					new Double(3.7) },
			{ "Xe", "Xenônio", new Integer(54), new Double(131.30),
					new Double(5.85) },
			{ "Rd", "Radônio", new Integer(86), new Double(222),
					new Double(9.73) } };

	public SwingTable() { // Construtor
		setTitle("Gases Nobres");
		tabela = new JTable(dados, colunas);
		getContentPane().add(new JScrollPane(tabela), "Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 150);
	}

	//
	public static void main(String a[]) { // main
		SwingUtilities.invokeLater(() -> {
			new SwingTable().setVisible(true);
		});
	}
	//
}
