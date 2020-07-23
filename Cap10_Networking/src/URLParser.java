/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 10.22
 */
import java.net.MalformedURLException;
import java.net.URL;

public class URLParser {
	public static void main(String a[]) {
		try {
			URL aURL = new URL(a[0]);
			System.out.println("protocolo = " + aURL.getProtocol());
			System.out.println("host = " + aURL.getHost());
			System.out.println("porta = " + aURL.getPort());
			System.out.println("caminho = " + aURL.getPath());
			System.out.println("arquivo = " + aURL.getFile());
			System.out.println("ref = " + aURL.getRef());
			System.out.println("query = " + aURL.getQuery());
		} catch (MalformedURLException mul) {
			System.err.println(mul.toString());
		} catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println("Uso: URLParser <URL>");
		}
	}
}
