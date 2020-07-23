/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.18
 */
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class DataView extends JFrame {
	private JTable table;
	private QueryTableModel tm;
	private JButton bRefresh;

	public DataView(String propFile) { // Construtor
		String query = null;
		try { // Leitura das propriedades
			Properties prop = new Properties();
			prop.load(new FileInputStream(propFile));
			query = prop.getProperty("DataView.sql");
			setTitle(prop.getProperty("DataView.title"));
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		tm = new QueryTableModel(query);
		table = new JTable(tm);
		table.setGridColor(Color.LIGHT_GRAY);
		add("Center", new JScrollPane(table));
		bRefresh = new JButton("Atualizar");
		bRefresh.addActionListener((e) -> { // expressão lambda
			tm.loadData();
		});
		JPanel p = new JPanel();
		p.add(bRefresh);
		add("South", p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				DB.getInstance().shutdown();
			}
		});
		pack();
	}

	//
	public static void main(String[] args) { // Main
		final String propFile = args.length == 0 ? "DataView.properties" : args[0];
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new DataView(propFile).setVisible(true);
			}
		});
	}
	//
}
