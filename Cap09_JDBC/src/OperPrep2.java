/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.10
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperPrep2 {
	public static void main(String a[]) throws SQLException {
		Connection con = DB.getInstance().getConnection(); // obt�m conex�o
		// cria comando preparado
		String sql = "INSERT INTO planetas(posicao, nome, distancia, diametro) VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		for (int i = 0; i < 100; i++) { // prepara conjuntos de par�metros
			double valor = Math.random(); // gera valor aleat�rio
			pstmt.setInt(1, 1000 + i); // par�metro 1
			pstmt.setString(2, "Planeta#" + i); // par�metro 2
			pstmt.setDouble(3, 1000000 * valor); // par�metro 3
			pstmt.setDouble(4, 1000 * valor); // par�metro 4
			pstmt.addBatch(); // separa conjuntos de par�metros
		}
		int res[] = pstmt.executeBatch(); // processa lote
		pstmt.close(); // encerra comando preparado
		DB.getInstance().shutdown(); // encerra conex�o
		int check = 0; // totalizador de oks
		for (int i = 0; i < res.length; i++) {
			check += res[i] > 0 ? 1 : 0;
		}
		System.out.println(check + " datasets ok em " + res.length);
	}
}
