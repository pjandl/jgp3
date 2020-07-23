/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.24
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	public static void main(String[] a) throws Exception {
		URL jandl = new URL(a[0]);
		URLConnection conexao = jandl.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				conexao.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}
}
