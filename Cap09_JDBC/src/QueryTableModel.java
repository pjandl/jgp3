/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.17
 */
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class QueryTableModel extends AbstractTableModel {
	private ArrayList<Object[]> linhas;
	private String[] colunas;
	private Statement stmt;
	private String query;

	public QueryTableModel(String query) { // Construtor
		try {
			stmt = DB.getInstance().getConnection().createStatement();
			this.query = query;
			linhas = new ArrayList<Object[]>();
			loadData();
		} catch (Exception e) {
			System.out.println("QueryTableModel[" + e.toString() + "]");
		}
	}

	public void loadData() { // Carrega dados do BD no modelo
		System.out.println("QueryTableModel[loadData()]");
		try (ResultSet rs = stmt.executeQuery(query);) {
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			colunas = new String[numCols];
			for (int i = 0; i < numCols; i++) {
				colunas[i] = rsmd.getColumnName(i + 1);
			}
			linhas.clear();
			while (rs.next()) {
				Object l[] = new Object[numCols];
				for (int i = 0; i < numCols; i++) {
					l[i] = rs.getObject(i + 1);
				}
				linhas.add(l);
			}
			fireTableDataChanged();
		} catch (Exception e) {
			System.out.println("QueryTableModel[" + e.toString() + "]");
		} // rs.close() implicitos
	}

	// Metodos de implementcao obrigatoria
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {
		try {
			Object l[] = linhas.get(lin);
			return l[col];
		} catch (Exception e) {
			System.out.println("QueryTableModel[" + e.toString() + "]");
		}
		return null;
	}

	//
	// Metodos de implementacao opcional
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
		return getValueAt(0, col).getClass();
	}

	@Override
	public void setValueAt(Object value, int lin, int col) {
		Object l[] = linhas.get(lin);
		l[col] = value;
		fireTableCellUpdated(lin, col);
	}
	//
}
