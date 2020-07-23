/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.13
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class ProcArm {
	public static void main(String a[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Posicao do Planeta [1..9]? ");
		int posicao = sc.nextInt();
		sc.close();
		Connection con = DB.getInstance().getConnection(); // obt�m conex�o
		// cria objeto para executar procedimento armazenado
		String sql = "CALL procNomePlaneta(?, ?)";
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, posicao); // ajusta par�metro
		cstmt.registerOutParameter(2, Types.CHAR); // registra par�metro de
													// sa�da
		cstmt.execute(); // executa procedimento armazenado
		String res = cstmt.getString(2); // obt�m e exibe resultado
		System.out.println("Resultado=" + res);
		cstmt.close();// encerra procedimento armazenado
		DB.getInstance().shutdown(); // encerramento da conex�o
	}
}
