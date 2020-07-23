/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.26
 */
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;

public class GoogleSearch {
	public static void main(String[] args) throws Exception {
		//
		if (args.length == 0) {
			System.err.println("Uso: GoogleSearch <argumentos>");
			System.exit(1);
		}
		//
		// concatena argumentos em uma String
		StringBuilder sb = new StringBuilder();
		sb.append(args[0]);
		for (int i = 1; i < args.length; i++) {
			sb.append(" ");
			sb.append(args[i]);
		}
		String protocolo = "http";
		String endereco = "www.google.com.br";
		String consulta = "/search?q="
				+ URLEncoder.encode(sb.toString(), "UTF-8");
		URL url = new URL(protocolo, endereco, consulta);
		System.out.printf("GoogleSearch[%s]\n", url.toString());
		// efetua conexao
		URLConnection connection = url.openConnection();
		// habilita entrada e saida sem cache
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		// configura HTTP header (obrigatorio para Google)
		connection
				.setRequestProperty(
						"User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1312.60 Safari/537.17");
		// le e salva resultados
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		Date date = new Date();
		String fileName = "GoogleSearch " + date.toString() + ".html";
		System.out.printf("Arquivo [%s]\n", fileName);

		PrintWriter out = new PrintWriter(new FileWriter(fileName));
		String line;
		while ((line = in.readLine()) != null) {
			out.println(line);
		}
		in.close();
		out.close();
		System.out.println("[Ok]");
	}
}
