/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.4
 */
import java.sql.*;
public class CriaTabela {
	public static void main(String[] a) {
		try { // conexão com o BD
			Connection conexao = DB.getInstance().getConnection();
			Statement stmt = conexao.createStatement();
			String[] cmdList = { // "DROP TABLE TMP",
				"CREATE TABLE TMP (CHAVE INT NOT NULL UNIQUE, VALOR VARCHAR(50))",
				"INSERT INTO TMP VALUES (1, 'Peter')",
				"INSERT INTO TMP VALUES (2, 'Jandl')",
				"INSERT INTO TMP VALUES (3, 'Junior')",
			};
			for(String cmd: cmdList) {
				System.out.println(cmd);
				stmt.executeUpdate(cmd);
			}
			stmt.close();
			DB.getInstance().shutdown();
		} catch (Exception e) {
			System.err.println("Erro:" + e.getMessage());
} } }
