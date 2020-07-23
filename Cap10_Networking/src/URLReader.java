/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.23
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
	public static void main(String a[]) throws Exception {
		URL url = new URL(a[0]);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();
	}
}
