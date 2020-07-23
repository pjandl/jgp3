/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.3
 */
import java.sql.Connection;

public class DBTest {
	public static void main(String a[]) throws Exception {
		// obtém conexão
		Connection con = DB.getInstance().getConnection();
		// exibe informação mínima
		System.out.println(con.getMetaData().getDatabaseProductName() + ":"
				+ con);
		// encerramento da conexão
		DB.getInstance().shutdown();
	}
}
