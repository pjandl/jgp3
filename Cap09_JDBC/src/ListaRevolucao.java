/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.6
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ListaRevolucao {
	public static void main(String a[]) throws SQLException {
		Connection con = DB.getInstance().getConnection(); // obt�m conex�o
		// cria sess�o interativa
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		// executa consulta
		ResultSet rs = stmt.executeQuery("SELECT * FROM REVOLUCAO");
		int nPlanetas = 0;
		while (rs.next()) {
			nPlanetas++;
		} // conta planetas
		Scanner sc = new Scanner(System.in);
		int id;
		do { // pesquisa navegada
			System.out.print("Indique o planeta [1.." + nPlanetas
					+ " ] ou 0 para sair: ");
			id = sc.nextInt();
			if (id > 0 && id <= nPlanetas) {
				rs.absolute(id);
				System.out.println(rs.getString("POSICAO") + " Rev: "
						+ rs.getDouble("SIDERAL") + "dias Rot:"
						+ rs.getString("ROTACAO") + "horas");
			}
		} while (id != 0);
		sc.close();
		stmt.close(); // fecha sess�o
		DB.getInstance().shutdown(); // encerra conex�o
	}
}
