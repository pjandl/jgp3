/*
 * Java - Guia do Programador - 3a Ed.
 * Autor: Peter Jandl Junior
 * (c) 2015, Novatec Editora Ltda.
 * 
 * Exemplo 2.24
 */
import java.io.*;

public class ExemploTryWithResources {
	public static void main(String args[]) {
		try (InputStream recurso = new FileInputStream(args[0]);) {
			// uso do recurso
		} catch (IOException e1) {
			// tratamento de erro na obtenção do recurso
			System.out.println(e1);
		}
	}
}
