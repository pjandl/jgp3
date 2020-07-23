/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.25
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Reverso {
	public static void main(String[] a) throws Exception {
		//
		if (a.length != 1) {
			System.err.println("Usage:  java Reverse " + "string_to_reverse");
			System.exit(1);
		}
		//
		// concatena argumentos em uma String
		StringBuilder sb = new StringBuilder();
		for (String arg : a) {
			sb.append(arg);
			sb.append(" ");
		}
		String stringToReverse = URLEncoder.encode(sb.toString(), "UTF-8");
		URL url = new URL("http://localhost:8080/Cap11_Servlets/ReverseServlet");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		out.println("string=" + stringToReverse);
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}
}
