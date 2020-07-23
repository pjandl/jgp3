/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 6.13
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String a[]) {
		Properties dados = new Properties(); // cria tabela chave/valor
		try { // carrega properties com um arquivo de propriedades
			dados.load(new FileInputStream("dinos.properties"));
		} catch (IOException ioe) {
			System.err.println(ioe); // exibe erro
			System.exit(-1); // encerra programa
		}
		// cria mapa ordenado e adiciona conteúdo do properties
		SortedMap<String, String> dinos = new TreeMap<>();
		for (Map.Entry<Object, Object> e : dados.entrySet()) { // for avançado
			dinos.put((String) e.getKey(), (String) e.getValue());
		}
		Scanner sc = new Scanner(System.in); // prepara console
		System.out.print("Inicio intervalo? "); // solicita início
		String ini = sc.nextLine();
		System.out.print("Fim intervalo? "); // solicita fim
		String fim = sc.nextLine();
		sc.close();
		System.out.println("Dinos: "); // resultados
		SortedMap<String, String> sub = dinos.subMap(ini, fim); // submapa
		for (Map.Entry<String, String> me : sub.entrySet()) { // for avançado
			System.out.println(me.getKey() + "=" + me.getValue());
		}
	}
}
