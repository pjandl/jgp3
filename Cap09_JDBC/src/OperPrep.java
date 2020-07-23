/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.9
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperPrep {
	public static void main(String a[]) throws SQLException {
		Connection con = DB.getInstance().getConnection(); // obtém conexão
		// cria comando preparado
		String sql = "INSERT INTO "
				+ "planetas(posicao, nome, distancia, diametro) VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		for (int i = 0, res = 1; i < 100 && res > 0; i++) { // insere novos
															// planetas de teste
			double valor = Math.random(); // gera valor aleatório
			pstmt.setInt(1, 1000 + i); // parâmetro 1
			pstmt.setString(2, "Planeta#" + i); // parâmetro 2
			pstmt.setDouble(3, 1000000 * valor); // parâmetro 3
			pstmt.setDouble(4, 1000 * valor); // parâmetro 4
			res = pstmt.executeUpdate(); // executa comando
			System.out.println("Planeta#" + i + (res > 0 ? " ok" : " erro"));
		}
		pstmt.close(); // encerra comando preparado
		DB.getInstance().shutdown(); // encerra conexão
	}
}
