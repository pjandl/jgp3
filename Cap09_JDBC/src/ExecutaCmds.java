/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 9.5
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class ExecutaCmds {
	public static void main(String[] a) {
		//
		if (a.length == 0) { // verifica presenca do nome da lista de comandos
			System.err.println("Uso: ExecutaCmds <arquivoLista>");
			return;
		}
		//
		// processamento da lista de comandos
		try (BufferedReader in = new BufferedReader(new FileReader(a[0]));) {
			Connection conexao = DB.getInstance().getConnection();
			Statement stmt = conexao.createStatement();
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println("> " + line);
				stmt.executeUpdate(line);
			}
			stmt.close();
			DB.getInstance().shutdown();
		} catch (Exception e) {
			System.err.println("Erro:" + e.getMessage());
		}
	}
}
