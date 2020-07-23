/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.4
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLScript {
	public static void main (String a[]) {
		// verifica presenca do nome do arquivo de script
		if (a.length == 0) { 
			System.err.println("Uso: SQLScript <arquivoScript>");
			return;
		}
		Connection conexao = null; // conex�o com o BD
		try { 
			conexao = DB.getInstance().getConnection();
		} catch (Exception e) {
			System.err.println("Erro durante conexao:" + e.getMessage());
			return;
		}
		// processamento do arquivo de script
		int i = 0; // contador de comandos
		try (BufferedReader in = new BufferedReader(new FileReader(a[0]));) {
			Statement stmt = conexao.createStatement(); // cria sess�o interativa
			String cmd = "", line;
			while ((line = in.readLine()) != null) {
				if (line.length() != 0) { // checa linha vazia
					if (!line.substring(0,2).equals("--")) { // checa coment�rio
						if (line.charAt(line.length()-1) == ';') { // checa presen�a do ;
							cmd = cmd + " " + line; // concatena linhas
							System.out.println("> " + cmd); // exibe comando
							// executa comando
							if (stmt.execute(cmd.substring(0, cmd.length()-1))) {
								// se produz ResultSet, exibe resultados tabulados
								System.out.print(displayResultSet(stmt.getResultSet()));
							}
							cmd = "";  i++;
						} else {
							cmd = cmd + " " + line; // concatena linhas
			}	}	}	}
			stmt.close(); // fecha sess�o
		} catch (SQLException | IOException exc) {
			System.err.println("Erro:\n" + exc.getMessage());
		} finally {
			System.out.println(i + " comando(s) executado(s).");
			DB.getInstance().shutdown(); // fecha conex�o
	} }
	private static String displayResultSet(ResultSet rs) throws SQLException {
		StringBuffer sb = new StringBuffer(); // cria buffer para texto
		ResultSetMetaData rsmd = rs.getMetaData(); // obt�m metadados
		int cols = rsmd.getColumnCount(); // obt�m n�mero de colunas
		int[] dispSize = new int[cols]; // aloca arrays para tamanho, 
		String[] label = new String[cols]; // nome e
		String[] espec = new String[cols]; // formata��o
		// obt�m tamanho e nome das colunas
		for(int c=0; c<cols; c++) {
			dispSize[c] = rsmd.getColumnDisplaySize(c+1);
			label[c] = rsmd.getColumnLabel(c+1);
			// constroi String de formato para cada coluna
			espec[c] = String.format("%%-%ds|", dispSize[c]);
			// anexa nome da coluna formatado no buffer
			sb.append(String.format(espec[c], label[c]));
		}
		sb.append("\n"); // quebra linha
		// obt�m conte�do de cada registro
		while (rs.next()) {
			// processa colunas de cada registro
			for(int c=0; c<cols; c++) {
				// anexa conte�do da coluna formatado no buffer
				sb.append(String.format(espec[c], rs.getString(c+1)));
			}
			sb.append("\n"); // quebra linha
		}
		return sb.toString(); // retorna texto do ResultSet
} }
