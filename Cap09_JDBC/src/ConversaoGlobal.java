/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.7
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConversaoGlobal {
	public static void main(String a[]) throws SQLException {
		Connection con = DB.getInstance().getConnection(); // obt�m conex�o
		// cria sess�o interativa com resultados atualiz�veis
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		// executa consulta
		ResultSet rs = stmt.executeQuery("SELECT * FROM PLANETAS");
		int nPlanetas = 0;
		while (rs.next()) {
			// navega pelo resultado e altera dist�ncias e di�metros
			nPlanetas++;
			double distancia = rs.getDouble("DISTANCIA");
			rs.updateDouble("DISTANCIA", distancia / 1.6);
			double diametro = rs.getDouble("DIAMETRO");
			rs.updateDouble("DIAMETRO", diametro / 1.6);
			rs.updateRow();
		}
		stmt.close(); // fecha sess�o
		System.out
				.println(nPlanetas + " planetas tiveram valores convertidos.");
		DB.getInstance().shutdown(); // encerramento da conex�o
	}
}
