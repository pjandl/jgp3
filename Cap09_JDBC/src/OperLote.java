/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.8
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OperLote {
	public static void main(String a[]) throws SQLException {
		Connection con = DB.getInstance().getConnection(); // obtém conexão
		con.setAutoCommit(false); // desativa autocommit
		Statement stmt = con.createStatement(); // cria sessão interativa
		// adiciona comandos ao lote
		stmt.addBatch("UPDATE planetas SET diametro=diametro*2");
		stmt.addBatch("DELETE FROM planetas WHERE posicao>=100");
		stmt.addBatch("UPDATE planetas SET diametro=diametro/2");
		int res[] = stmt.executeBatch(); // executa lote
		boolean ok = true; // verifica resultados
		for (int i = 0; i < res.length; i++) {
			if (res[i] < 0) {
				ok = false;
			}
		}
		if (ok) {
			con.commit();
		} else {
			con.rollback();
		}
		stmt.close(); // fecha sessão
		con.setAutoCommit(true); // ativa autocommit
		DB.getInstance().shutdown(); // encerra conexão
	}
}
