/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.12
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ListaSatelites {
	public static void main(String a[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome do Planeta ? ");
		String planeta = sc.next();
		sc.close();
		Connection con = DB.getInstance().getConnection(); // obtém conexão
		Statement stmt = con.createStatement();// cria sessão interativa
		String sql = "SELECT * FROM satelites WHERE posicao = funcPosPlaneta('"
				+ planeta + "')";
		ResultSet rs = stmt.executeQuery(sql); // executa consulta
		while (rs.next()) { // exibe resultados
			System.out.println(rs.getInt("POSICAO") + ": " + rs.getString("NOME"));
		}
		stmt.close(); // fecha sessão
		DB.getInstance().shutdown();// encerra conexão
} }
