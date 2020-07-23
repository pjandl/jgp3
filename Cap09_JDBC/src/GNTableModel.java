/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.15
 */
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GNTableModel extends AbstractTableModel {
	private Object[][] dados = {
			{ "He", "H�lio", new Integer(2), new Double(4.0026),
					new Double(0.179), new Boolean(true) },
			{ "Ne", "Ne�nio", new Integer(10), new Double(20.17),
					new Double(0.90), new Boolean(true) },
			{ "Ar", "Arg�nio", new Integer(18), new Double(39.94),
					new Double(1.78), new Boolean(true) },
			{ "Kr", "Cript�nio", new Integer(36), new Double(83.80),
					new Double(3.7), new Boolean(true) },
			{ "Xe", "Xen�nio", new Integer(54), new Double(131.30),
					new Double(5.85), new Boolean(true) },
			{ "Rd", "Rad�nio", new Integer(86), new Double(222),
					new Double(9.73), new Boolean(true) } };
	private String[] colunas = { "S�mb", "Nome", "NAtom", "M Atom", "M Espec",
			"Nobre" };

	// M�todos de implementa��o obrigat�ria
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.length;
	}

	@Override
	public Object getValueAt(int lin, int col) {
		return dados[lin][col];
	}

	// M�todos de implementa��o opcional
	@Override
	public String getColumnName(int col) {
		return colunas[col];
	}

	@Override
	public boolean isCellEditable(int lin, int col) {
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int col) {
		return dados[0][col].getClass();
	}
}
