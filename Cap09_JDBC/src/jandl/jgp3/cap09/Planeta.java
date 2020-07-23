/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.11
 */
package jandl.jgp3.cap09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Planeta {
	// m�todo privado para organizar obten��o da conex�o
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:default:connection");
	}
	// fun��o Java para Apache Derby
	public static int functionPosicaoDoPlaneta(String nome) throws SQLException {
		Connection con = getConnection(); // obtem conex�o
		String sql = "SELECT posicao FROM planetas WHERE nome=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, nome);
		ResultSet rs = pstmt.executeQuery();
		// obt�m resultado v�lido ou indica erro
		int posicao = rs.next() ? rs.getInt(1) : -1;
		rs.close(); // fecha recursos usados
		pstmt.close();
		con.close();
		return posicao; // retorno expl�cito
	}
	// procedimento Java para Apache Derby
	public static void procedurePlanetaNaPosicao(int posicao, String[] planeta)
			throws SQLException {
		Connection con = getConnection(); // obtem conex�o
		String sql = "SELECT nome FROM planetas WHERE posicao=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, posicao);
		ResultSet rs = pstmt.executeQuery();
		// obt�m resultado v�lido ou indica erro
		planeta[0] = rs.next() ? rs.getString(1) : "desconhecido";
		rs.close(); // fecha recursos usados
		pstmt.close();
		con.close();
		// retorno impl�cito de resultado
} }
